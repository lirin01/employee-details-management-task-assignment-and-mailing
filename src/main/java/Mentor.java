import java.util.ArrayList;
import java.util.HashMap;
public class Mentor {
    private GetDetails getDetails=new GetDetails();
    private View view = new View();
    public void assign(HashMap<Long, PersonalDetails> personal_details_database ,Long user_id , HashMap<String,TeamMemberList> team_database,Long client_id){
        PersonalDetails user_details=personal_details_database.get(user_id);
        ArrayList<Long> list=new ArrayList<>();
        boolean switcher=true;
        while(switcher){
            if(personal_details_database.get(client_id).getReportingTo()==0) // check the employee is already assigned are not
            {
                String format = ("|%12s    |%15s    |%15s    |%16s    |%15s    |%18s    |%20s    |%n");
                System.out.println("_____________________________________________________________________________________________________________________________________________________");
                System.out.format(format, "Employee id", "First name", "Second name", "Contact number", "Role","Team name","Email address");
                System.out.println("_____________________________________________________________________________________________________________________________________________________");
                if(personal_details_database.get(client_id).getRole().equals("PT")) // check client role is PT or not
                {
                    for (Long individual_key : team_database.get(user_details.getTeamName()).getTeamMemberList()) {
                        PersonalDetails client_data=personal_details_database.get(individual_key);
                        if(!client_data.getRole().equals("PT")){
                            list.add(client_data.getEmployeeId());
                            System.out.format(format, client_data.getEmployeeId(), client_data.getFirstName(), client_data.getSecondName(), client_data.getContactNumber(), client_data.getRole(),client_data.getTeamName(),client_data.getMailId());
                            System.out.println("_____________________________________________________________________________________________________________________________________________________");
                        }
                    }
                }
                else if(personal_details_database.get(client_id).getRole().equals("MTS")) // check client role is MTS or not
                {
                    for (Long individual_key : team_database.get(user_details.getTeamName()).getTeamMemberList()) {
                        PersonalDetails client_data=personal_details_database.get(individual_key);
                        if(!client_data.getRole().equals("PT") && !client_data.getRole().equals("MTS")){
                            list.add(client_data.getEmployeeId());
                            System.out.format(format, client_data.getEmployeeId(), client_data.getFirstName(), client_data.getSecondName(), client_data.getContactNumber(), client_data.getRole(),client_data.getTeamName(),client_data.getMailId());
                            System.out.println("_____________________________________________________________________________________________________________________________________________________");
                        }
                    }
                }
                view.line();
                long report_to_id=getDetails.id("enter one employee id from above to assign");
                if(list.contains(report_to_id)){
                    switcher=false;
                    personal_details_database.get(client_id).setReportingTo(report_to_id);
                    personal_details_database.get(report_to_id).getDirectReport().add(client_id);
                    view.line();
                    System.out.println("assigned successfully");
                    view.line();
                }
                else{
                    view.line();
                    System.out.println("you should need to select the employee only view in the above table");
                    view.line();
                }
            }
            else{
                view.line();//dc
                System.out.println("the employee has already assigned to "+personal_details_database.get(personal_details_database.get(client_id).getReportingTo()).getFirstName()+" "+personal_details_database.get(personal_details_database.get(client_id).getReportingTo()).getSecondName());
                view.line();
            }
        }

    }
    public void remove(HashMap<Long, PersonalDetails> personal_details_database,Long client_id){
        if(personal_details_database.get(client_id).getReportingTo()!=0) // check the client is already assigned or not
        {
            System.out.println("the entered employee is assigned to : "+personal_details_database.get(personal_details_database.get(client_id).getReportingTo()).getFirstName()+" "+personal_details_database.get(personal_details_database.get(client_id).getReportingTo()).getSecondName());
            personal_details_database.get(personal_details_database.get(client_id).getReportingTo()).getDirectReport().remove(client_id);
            personal_details_database.get(client_id).setReportingTo(0l);
            System.out.println("mentor removed successfully");
            view.line();
        }
        else{
            view.line();
            System.out.println("the entered employee is not assigned to anyone");
            view.line();
        }
    }
    public void change(HashMap<Long, PersonalDetails> personal_details_database,Long user_id, HashMap<String,TeamMemberList> team_database,Long client_id){
        remove(personal_details_database, client_id);
        assign(personal_details_database,user_id,team_database,client_id);
    }
}
