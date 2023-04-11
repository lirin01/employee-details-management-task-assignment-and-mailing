import java.util.HashMap;
public class SuperAdminController {
    private View view=new View();
    private GetDetails getDetails=new GetDetails();

    public void start(HashMap<String, OrganizationDetails> database, String organization_name, String username) {
        SuperAdmin superAdmin=new Controller();
        int choice=Integer.MIN_VALUE;
        AuthenticationDetails user_authentication_details=database.get(organization_name).getAuthenticationDatabase().get(username);
        PersonalDetails user_details=database.get(organization_name).getPersonalDetailsDatabase().get(user_authentication_details.getEmployeeId());
        while (choice != 0) {
            view.line();
            System.out.println(
                    """
                    1  profile
                    2  employee
                    3  view all employee
                    4  team
                    5  organization
                    6  Mail
                    0  logout""");
            choice=getDetails.choice("choice");
            switch (choice) {
                case 1->superAdmin.profile(database.get(organization_name).getPersonalDetailsDatabase(),user_authentication_details,user_details.getEmployeeId(),database.get(organization_name).getMailDatabase());
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
                            case 1->superAdmin.addNewEmployee(database.get(organization_name),user_details); //add new employee /
                            case 2->superAdmin.removeEmployee(database.get(organization_name),username); //remove employee /
                            case 3->superAdmin.changeEmployeeRole(database.get(organization_name).getPersonalDetailsDatabase(),database.get(organization_name).getTeamDatabase().get(user_details.getTeamName()).getTeamMemberList(),user_details.getEmployeeId());
                            case 4->superAdmin.changeEmployeeAccess(database.get(organization_name).getPersonalDetailsDatabase(), user_details.getEmployeeId());//restrict employee access /
                            case 0->{}
                            default -> {
                                view.line();
                                System.out.println("invalid command");
                                view.line();
                            }
                        }
                    }
                }
                case 3->superAdmin.viewAll(database.get(organization_name).getPersonalDetailsDatabase()); // view all employee in organization with or without filter
                case 4->{
                    int inner_choice=Integer.MIN_VALUE;
                    while(inner_choice!=0){
                        System.out.println("""
                                1 add new team
                                0 back""");
                        inner_choice= getDetails.choice("choice");
                        switch(inner_choice){
                            case 1->superAdmin.addNewTeam(database.get(organization_name));
                            case 0->{}
                            default -> {
                                view.line();
                                System.out.println("invalid command");
                                view.line();
                            }
                        }
                    }
                }
                case 5->{
                    int inner_choice=Integer.MIN_VALUE;
                    while(inner_choice!=0){
                        System.out.println("""
                                1 add new organization
                                2 organization access
                                0 back""");
                        inner_choice= getDetails.choice("choice");
                        switch(inner_choice){
                            case 1->superAdmin.addNewOrganization(database); // create new organization /
                            case 2->superAdmin.changeOrganizationAccess(database,organization_name);//restrict organization access /
                            case 0->{}
                            default -> {
                                view.line();
                                System.out.println("invalid command");
                                view.line();
                            }
                        }
                    }
                }
                case 6->superAdmin.mail(database.get(organization_name).getMailDatabase(),database.get(organization_name).getPersonalDetailsDatabase(),user_details.getEmployeeId());
                case 0-> {}
                default -> {
                    view.line();
                    System.out.println("invalid command");
                    view.line();
                }
                //remove team
            }
        }
    }
}
