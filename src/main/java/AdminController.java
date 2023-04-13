public class AdminController {
    private View view=new View();
    private GetDetails getDetails=new GetDetails();
    public void start(OrganizationDetails organization_database, String username) {
        AuthenticationDetails USER_AUTHENTICATION_DETAILS=organization_database.getAuthenticationDatabase().get(username);
        PersonalDetails USER_DETAILS=organization_database.getPersonalDetailsDatabase().get(USER_AUTHENTICATION_DETAILS.getEmployeeId());
        Admin admin=new Controller();
        int choice=Integer.MIN_VALUE;
        while (choice != 0) {
            view.line();
            System.out.println(
                    """
                    1  profile
                    2  employee
                    3  view all employee
                    4  Team
                    5  Mail
                    6  view your team
                    0  logout""");
            choice=getDetails.choice("choice");
            switch (choice) {
                case 1->admin.profile(organization_database.getPersonalDetailsDatabase(),USER_AUTHENTICATION_DETAILS,USER_DETAILS.getEmployeeId(),organization_database.getMailDatabase());
                case 2-> {
                    int inner_choice=Integer.MIN_VALUE;
                    while(inner_choice!=0){
                        System.out.println("""
                                1 add employee
                                2 remove employee
                                3 change role
                                4 change access
                                0 back""");
                        inner_choice= getDetails.choice("choice");
                        switch(inner_choice){
                            case 1->admin.addNewEmployee(organization_database,USER_DETAILS); //add new employee /
                            case 2->admin.removeEmployee(organization_database,username); //remove employee /
                            case 3->admin.changeEmployeeRole(organization_database.getPersonalDetailsDatabase(),organization_database.getTeamDatabase().get(USER_DETAILS.getTeamName()).getTeamMemberList(),USER_DETAILS.getEmployeeId());
                            case 4->admin.changeEmployeeAccess(organization_database.getPersonalDetailsDatabase(), USER_DETAILS.getEmployeeId()); // restrict employee access /
                            case 0->{}
                            default -> {
                                System.out.println("invalid command");
                                view.line();
                            }
                        }
                    }
                }
                case 3->admin.viewAll(organization_database.getPersonalDetailsDatabase()); // view all employee in organization with or without filter
                case 4-> {
                    int inner_choice=Integer.MIN_VALUE;
                    while(inner_choice!=0){
                        System.out.println("""
                                1 add new team
                                0 back""");
                        inner_choice= getDetails.choice("choice");
                        switch(inner_choice){
                            case 1->admin.addNewTeam(organization_database);// create new team /
                            case 0->{}
                            default -> {
                                System.out.println("invalid command");
                                view.line();
                            }
                        }
                    }
                }
                case 5->admin.mail(organization_database.getMailDatabase(),organization_database.getPersonalDetailsDatabase(),USER_DETAILS.getEmployeeId());
                case 6->admin.viewYourTeam(organization_database.getPersonalDetailsDatabase(),organization_database.getTeamDatabase().get(USER_DETAILS.getTeamName()).getTeamMemberList());
                case 0-> {}
                default ->  {
                    System.out.println("invalid command");
                    view.line();
                }
            }
        }
    }
}
