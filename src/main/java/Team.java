import java.util.ArrayList;
import java.util.HashMap;

public class Team {
    private View view=new View();
    public void add(OrganizationDetails team_details){
        GetDetails getDetails=new GetDetails();
        boolean switcher=true;
        String team_name = getDetails.name("enter the new team name");
        view.line();//dc
        System.out.println("Check the new team name properly : " + team_name);
        while(switcher){
            switch (getDetails.confirmation()) {
                case 1 -> {
                    switcher=false;
                    if (team_details.getTeamDatabase().get(team_name) == null) {
                        team_details.getTeamDatabase().put(team_name, new TeamMemberList());
                        System.out.println("new team created successfully");
                        view.line();

                    } else {
                        System.out.println("the team you entered is already exist");
                        view.line();
                    }
                }
                case 2 -> {
                    System.out.println("you have cancelled creating new team");
                    view.line();
                    switcher=false;
                }
                default ->{
                    System.out.println("invalid command");
                    view.line();
                }
            }
        }
    }
    public void view(HashMap<Long, PersonalDetails> personal_details_database, ArrayList<Long> team_member_list){
        String format = ("|%13s    |%15s    |%15s    |%15s    |%15s     |%20s    |%15s    |%15s   |%n");
        System.out.println("____________________________________________________________________________________________________________________________________________________________________");
        System.out.format(format, "Employee id", "First name", "Second name", "Role", "Team name", "Email address", "Jointed time", "Jointed date");
        System.out.println("____________________________________________________________________________________________________________________________________________________________________");
        for (Long i : team_member_list) {
            PersonalDetails individual_data = personal_details_database.get(i);
            System.out.format(format, individual_data.getEmployeeId(), individual_data.getFirstName(), individual_data.getSecondName(), individual_data.getRole(), individual_data.getTeamName(), individual_data.getMailId(), individual_data.getJointedTime(), individual_data.getJointedDate());
            System.out.println("____________________________________________________________________________________________________________________________________________________________________");
        }
        view.line();
    }
}
