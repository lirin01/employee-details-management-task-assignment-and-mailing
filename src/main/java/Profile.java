import java.util.HashMap;

public class Profile {
    private View view=new View();
    private Search search=new Search();
    private GetDetails getDetails=new GetDetails();

    public void view(HashMap<Long, PersonalDetails> personal_details_database, Long user_id){
        PersonalDetails user_details=personal_details_database.get(user_id);

        System.out.println("employee id       : " + user_details.getEmployeeId());
        System.out.println("name              : " + user_details.getFirstName() + " " + user_details.getSecondName());
        System.out.println("email address     : " + user_details.getMailId());
        System.out.println("contact number    : " + user_details.getContactNumber());
        System.out.println("team name         : " + user_details.getTeamName());
        System.out.println("role              : " + user_details.getRole());
        System.out.println("Reporting to      : " + (user_details.getReportingTo()==null?"-":personal_details_database.get(user_details.getReportingTo()).getFirstName()+" "+personal_details_database.get(user_details.getReportingTo()).getSecondName()));
        System.out.println("Direct report     : " + (user_details.getDirectReport().isEmpty()?"-":personal_details_database.get(user_details.getDirectReport().get(0)).getFirstName()+" "+personal_details_database.get(user_details.getDirectReport().get(0)).getSecondName()));
        if(user_details.getDirectReport().size()!=0) // check the user is reporting to any employee
        {
            user_details.getDirectReport().remove(0);
            for(Long s:user_details.getDirectReport()){
                System.out.println("                    " +personal_details_database.get(s).getFirstName()+" "+personal_details_database.get(s).getSecondName());
            }
        }
        System.out.println("jointed time      : " + user_details.getJointedTime());
        System.out.println("jointed date      : " + user_details.getJointedDate());
        view.line();//dc
    }
    public void edit(PersonalDetails user_details, AuthenticationDetails user_authentication_details,HashMap<String,Long> mail_database){
        int choice = Integer.MIN_VALUE;
        while (choice != 0) {
            System.out.println("""
                    1 first name
                    2 second name
                    3 contact number
                    4 email address
                    5 password
                    0 back""");
            choice=getDetails.choice("choice");
            switch (choice) {
                case 1 -> // edit your first name
                {
                    user_details.setFirstName(getDetails.name("enter your new first name"));
                    System.out.println("your first name changed successfully");
                    view.line();
                }
                case 2 -> // edit your second name
                {
                    user_details.setSecondName(getDetails.name("enter your new second name"));
                    System.out.println("your second name changed successfully");
                    view.line();
                }
                case 3 -> // edit your contact number
                {
                    user_details.setContactNumber(getDetails.contactNumber());
                    System.out.println("your contact number changed successfully");
                    view.line();
                }
                case 4 -> // edit your email address
                {
                    String mail_id=getDetails.mailAddress(mail_database.keySet());
                    mail_database.put(mail_id,mail_database.get(user_details.getMailId()));
                    mail_database.remove(user_details.getMailId());
                    user_details.setMailId(mail_id);
                    System.out.println("your email address changed successfully");
                    view.line();
                }
                case 5-> // edit your password
                {
                    user_authentication_details.setPassword(getDetails.changePassword());
                    view.line();
                    System.out.println("password changed successfully");
                    view.line();
                }
                case 0 -> {}
                default ->
                {
                    System.out.println("invalid command");
                    view.line();
                }
            }
        }
    }
    public void viewOthers(HashMap<Long, PersonalDetails> personal_details_database){
        boolean switcher=true;
        while(switcher){
            PersonalDetails user_details=search.search(personal_details_database);

            if(user_details==null) // check the employee details in database
            {
                view.line();
                System.out.println("no data found in this ID\ntry again");
                view.line();
            }else{
                switcher=false;
                System.out.println("employee id    : " + user_details.getEmployeeId());
                System.out.println("name           : " + user_details.getFirstName() + " " + user_details.getSecondName());
                System.out.println("email address  : " + user_details.getMailId());
                System.out.println("role           : " + user_details.getRole());
                System.out.println("team name      : " + user_details.getTeamName());
                System.out.println("Reporting to   : " + (user_details.getReportingTo()==null?"-":personal_details_database.get(user_details.getReportingTo())));
                System.out.println("Direct report  : " + (user_details.getDirectReport().isEmpty()?"-":personal_details_database.get(user_details.getDirectReport().get(0)).getFirstName()+" "+personal_details_database.get(user_details.getDirectReport().get(0)).getSecondName()));
                if(user_details.getDirectReport().size()!=0){
                    user_details.getDirectReport().remove(0);
                    for(Long s:user_details.getDirectReport()){
                        System.out.println("                 " +personal_details_database.get(s).getFirstName()+" "+personal_details_database.get(s).getSecondName());
                    }
                }
                view.line();//dc
            }
        }
    }
}
