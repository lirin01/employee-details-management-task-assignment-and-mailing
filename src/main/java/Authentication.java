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
                OrganizationDetails ORGANIZATION_DATABASE = database.get(username.replaceAll("\\d", ""));
                AuthenticationDetails USER_AUTHENTICATION_DETAILS = ORGANIZATION_DATABASE.getAuthenticationDatabase().get(username);
                PersonalDetails USER_DETAILS = ORGANIZATION_DATABASE.getPersonalDetailsDatabase().get(USER_AUTHENTICATION_DETAILS.getEmployeeId());
                view.line();

                if(ORGANIZATION_DATABASE.getAccessStatus().equals(true)){//check organization access
                    if (password.equals(USER_AUTHENTICATION_DETAILS.getPassword())) { // verify password
                        System.out.println("welcome " + USER_DETAILS.getFirstName()+ " " + USER_DETAILS.getSecondName());
                        if ((USER_DETAILS.getAccessStatus())) {
                            switch (USER_DETAILS.getRole()) { // check employee access
                                case "MANAGER" -> {
                                    ManagerController managerController = new ManagerController();
                                    managerController.start(ORGANIZATION_DATABASE, username);

                                }
                                case "ADMIN" -> {
                                    AdminController adminController=new AdminController();
                                    adminController.start(ORGANIZATION_DATABASE,username);
                                }
                                case "MTS" -> {

                                    MTSController mtsController = new MTSController();
                                    mtsController.start(ORGANIZATION_DATABASE,username);
                                }
                                case "PT" -> {
                                    PTController ptController =new PTController();
                                    ptController.start(ORGANIZATION_DATABASE,username);
                                }
                                case "SUPERADMIN"->
                                {
                                    SuperAdminController superAdminController=new SuperAdminController();
                                    superAdminController.start(database,ORGANIZATION_DATABASE.getOrganizationName(),username);
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
