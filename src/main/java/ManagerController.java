public class ManagerController {
    private View view=new View();
    private GetDetails getDetails=new GetDetails();
    public void start(OrganizationDetails organization_database, String username){
        Manager manager=new Controller();
        AuthenticationDetails user_authentication_details=organization_database.getAuthenticationDatabase().get(username);
        PersonalDetails user_details= organization_database.getPersonalDetailsDatabase().get(user_authentication_details.getEmployeeId());
        int choice=Integer.MIN_VALUE;

        while (choice != 0) {
            view.line();
            System.out.println(
                    """
                    1  profile
                    2  task
                    3  Employee
                    4  view all employee
                    5  mentor
                    6  mail
                    7  view your team
                    0  logout""");
            choice=getDetails.choice("choice");
            switch (choice) {
                case 1->manager.profile(organization_database.getPersonalDetailsDatabase(),user_authentication_details,user_details.getEmployeeId(),organization_database.getMailDatabase());
                case 2-> {
                    int inner_choice=Integer.MIN_VALUE;
                    while(inner_choice!=0){
                        System.out.println("""
                                1 assign new task
                                2 view assigned task
                                3 change task status
                                0 back""");

                        inner_choice= getDetails.choice("choice");
                        switch(inner_choice){
                            case 1->manager.addNewTask(organization_database.getPersonalDetailsDatabase(),user_details);// add new task to the employee /
                            case 2->manager.viewTaskAssigned(user_details); //view the task assigned by you
                            case 3->manager.changeTaskStatus(organization_database.getPersonalDetailsDatabase(),user_details);// change the task status /
                            case 0->{}
                            default -> {
                                view.line();
                                System.out.println("invalid command");
                                view.line();
                            }
                        }
                    }
                }
                case 3-> {
                    int inner_choice=Integer.MIN_VALUE;
                    while(inner_choice!=0){
                        System.out.println("""
                                1 add employee
                                2 remove employee
                                3 change role
                                0 back""");
                        inner_choice= getDetails.choice("choice");
                        switch(inner_choice){
                            case 1->manager.addNewEmployee(organization_database,user_details); //add new employee /
                            case 2->manager.removeEmployee(organization_database,username); //remove employee /
                            case 3->manager.changeEmployeeRole(organization_database.getPersonalDetailsDatabase(),organization_database.getTeamDatabase().get(user_details.getTeamName()).getTeamMemberList(),user_details.getEmployeeId());
                            case 0->{}
                            default -> {
                                view.line();
                                System.out.println("invalid command");
                                view.line();
                            }
                        }
                    }
                }
                case 4->manager.viewAll(organization_database.getPersonalDetailsDatabase()); // view all employee in organization with or without filter
                case 5->manager.mentor(organization_database.getPersonalDetailsDatabase(),user_details.getEmployeeId(),organization_database.getTeamDatabase());// assign mentor
                case 6->manager.mail(organization_database.getMailDatabase(),organization_database.getPersonalDetailsDatabase(),user_details.getEmployeeId());
                case 7->manager.viewYourTeam(organization_database.getPersonalDetailsDatabase(),organization_database.getTeamDatabase().get(user_details.getTeamName()).getTeamMemberList());
                case 0->{}
                default->{
                    view.line();
                    System.out.println("invalid command");
                    view.line();
                }
            }
        }
    }
}
