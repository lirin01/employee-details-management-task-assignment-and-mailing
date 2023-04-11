public class MTSController{
    private GetDetails getDetails=new GetDetails();
    private View view=new View();
    public void start(OrganizationDetails organization_database, String username){
        MTS mts=new Controller();
        int choice=Integer.MIN_VALUE;
        AuthenticationDetails user_authentication_details=organization_database.getAuthenticationDatabase().get(username);
        PersonalDetails user_details=organization_database.getPersonalDetailsDatabase().get(user_authentication_details.getEmployeeId());
        while (choice != 0) {
            view.line();
            System.out.println(
                    """
                    1  profile
                    2  task
                    3  mail
                    4  view your team
                    0  logout""");
            choice=getDetails.choice("choice");
            switch (choice) {
                case 1->mts.profile(organization_database.getPersonalDetailsDatabase(),user_authentication_details,user_details.getEmployeeId(),organization_database.getMailDatabase());
                case 2-> {
                    int inner_choice=Integer.MIN_VALUE;
                    while(inner_choice!=0){
                        System.out.println("""
                                1 view your task
                                2 assign new task
                                3 view assigned task
                                4 change task status
                                0 back""");
                        inner_choice= getDetails.choice("choice");
                        switch(inner_choice){
                            case 1->mts.viewYourTask(user_details);// view your task /
                            case 2->mts.addNewTask(organization_database.getPersonalDetailsDatabase(),user_details);// add new task to the employee /
                            case 3->mts.viewTaskAssigned(user_details); //view the task assigned by you
                            case 4->mts.changeTaskStatus(organization_database.getPersonalDetailsDatabase(),user_details);// change the task status /
                            case 0->{}
                            default -> {
                                view.line();
                                System.out.println("invalid command");
                                view.line();
                            }
                        }
                    }
                }
                case 3-> mts.mail(organization_database.getMailDatabase(),organization_database.getPersonalDetailsDatabase(),user_details.getEmployeeId());
                case 4->mts.viewYourTeam(organization_database.getPersonalDetailsDatabase(),organization_database.getTeamDatabase().get(user_details.getTeamName()).getTeamMemberList());
                case 0->{}// exit
                default-> {
                    view.line();
                    System.out.println("invalid command");
                    view.line();
                }
            }
        }
    }
}
