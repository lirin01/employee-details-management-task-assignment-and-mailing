import java.util.HashMap;
public class Authentication {
    private GetDetails getDetails=new GetDetails();
    private View view =new View();
    public void verify(HashMap<String, OrganizationDetails> database) {
        while (true) {
            try {
                String username = getDetails.userName();
                String password = getDetails.password("password");
                view.line();
                OrganizationDetails organization_database = database.get(username.replaceAll("\\d", ""));
                AuthenticationDetails user_authentication_details = organization_database.getAuthenticationDatabase().get(username);
                PersonalDetails user_details = organization_database.getPersonalDetailsDatabase().get(user_authentication_details.getEmployeeId());
                view.line();

                if(organization_database.getAccessStatus().equals(true)){//check organization access
                    if (password.equals(user_authentication_details.getPassword())) { // verify password
                        System.out.println("welcome " + user_details.getFirstName()+ " " + user_details.getSecondName());
                        if ((user_details.getAccessStatus())) {
                            switch (user_details.getRole()) { // check employee access
                                case "MANAGER" -> {
                                    ManagerController managerController = new ManagerController();
                                    managerController.start(organization_database, username);

                                }
                                case "ADMIN" -> {
                                    AdminController adminController=new AdminController();
                                    adminController.start(organization_database,username);
                                }
                                case "MTS" -> {

                                    MTSController mtsController = new MTSController();
                                    mtsController.start(organization_database,username);
                                }
                                case "PT" -> {
                                    PTController ptController =new PTController();
                                    ptController.start(organization_database,username);
                                }
                                case "SUPERADMIN"->
                                {
                                    SuperAdminController superAdminController=new SuperAdminController();
                                    superAdminController.start(database,organization_database.getOrganizationName(),username);
                                }
                            }
                        }
                        else {
                            view.line();
                            System.out.println("your access restricted");
                            view.line();
                        }
                    } else {
                        view.line();
                        System.out.println("password incorrect");
                        System.out.println("try again");
                        view.line();
                    }
                } else{
                    view.line();
                    System.out.println("you organization access is restricted");
                    view.line();
                }
            } catch (NullPointerException e) {
                view.line();
                System.out.println("username not found");
                System.out.println("try again");
                view.line();
            }
        }
    }
}
