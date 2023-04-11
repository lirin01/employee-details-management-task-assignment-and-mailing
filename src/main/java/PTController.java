public class PTController {
    private View view=new View();
    private Task task=new Task();
    private GetDetails getDetails=new GetDetails();
    public void start(OrganizationDetails organization_database, String username){
        PT pt=new Controller();
        int choice=Integer.MIN_VALUE;
        AuthenticationDetails user_authentication_details=organization_database.getAuthenticationDatabase().get(username);
        PersonalDetails user_details=organization_database.getPersonalDetailsDatabase().get(user_authentication_details.getEmployeeId());
        while (choice != 0) {
            view.line();
            System.out.println(
                """
                1  profile
                2  mail
                3  task
                4  view your team
                0  logout""");
            choice=getDetails.choice("choice");
            switch (choice) {
                case 1->pt.profile(organization_database.getPersonalDetailsDatabase(),user_authentication_details,user_details.getEmployeeId(),organization_database.getMailDatabase());
                case 2->pt.mail(organization_database.getMailDatabase(),organization_database.getPersonalDetailsDatabase(),user_details.getEmployeeId());
                case 3->task.viewYourTask(user_details);//view your task /
                case 4->pt.viewYourTeam(organization_database.getPersonalDetailsDatabase(),organization_database.getTeamDatabase().get(user_details.getTeamName()).getTeamMemberList());
                case 0->{}
                default-> {
                    view.line();
                    System.out.println("invalid command");
                    view.line();
                }
            }
        }
     }
}