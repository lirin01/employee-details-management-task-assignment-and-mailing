import java.util.HashMap;

public class Employee {
    private GetDetails getDetails=new GetDetails();
    private String[] admin_options={"MANAGER","MTS","PT"};
    private String[] manager_options={"MTS","PT"};
    private View view=new View();
    public void add(OrganizationDetails organization_database,PersonalDetails user_details){
        String first_name= getDetails.name("first name");
        String second_name= getDetails.name("second name");
        long contact_number= getDetails.contactNumber();
        String username=organization_database.getOrganizationName()+organization_database.getId();
        String password= getDetails.password("temporary password");
        String role= getDetails.role(user_details.getTeamName().equals("ADMINISTRATION")?admin_options:manager_options,user_details.getTeamName());
        String team_name=getDetails.teamName(user_details.getTeamName().equals("ADMINISTRATION")?organization_database.getTeamDatabase().keySet():null,user_details.getTeamName());
        String email_address=getDetails.mailAddress(organization_database.getMailDatabase().keySet());

        organization_database.getTeamDatabase().get(team_name).getTeamMemberList().add(organization_database.getId());
        organization_database.getAuthenticationDatabase().put(username,new AuthenticationDetails(organization_database.getId(), password));
        organization_database.getPersonalDetailsDatabase().put(organization_database.getId(), new PersonalDetails(first_name,second_name,contact_number,role,organization_database,email_address,team_name));
        view.line();
        System.out.println("new employee Details saved successfully");
        System.out.println("temp username : "+username);
        System.out.println("temp password : "+password);
        view.line();
    }
    public void add(OrganizationDetails organization_database, String client_role){
        String first_name= getDetails.name("first name");
        String second_name= getDetails.name("second name");
        long contact_number= getDetails.contactNumber();
        String username=organization_database.getOrganizationName()+(organization_database.getId());
        String password= getDetails.password("temporary password");
        String email_address= getDetails.mailAddress(organization_database.getMailDatabase().keySet());
        String team_name="ADMINISTRATION";

        organization_database.getTeamDatabase().put(team_name,new TeamMemberList());
        organization_database.getTeamDatabase().get(team_name).getTeamMemberList().add(organization_database.getId());
        organization_database.getAuthenticationDatabase().put(username,new AuthenticationDetails(organization_database.getId(), password));
        organization_database.getPersonalDetailsDatabase().put(organization_database.getId(), new PersonalDetails(first_name,second_name,contact_number,client_role,organization_database,email_address,team_name));
        view.line();
        System.out.println("new organization added successfully to the Application");
        view.line();
        System.out.println("admin login details");
        System.out.println("username      : "+username);
        System.out.println("temp password : "+password);
        System.out.println();
    }
    public void changeRole(HashMap<Long, PersonalDetails> personal_details_database, Long user_id){
        long client_id= getDetails.id("employee id");
        view.line();
        int choice;
        boolean switcher=true;
        if(personal_details_database.get(client_id)!=null) // check if the data is found
        {
            if(personal_details_database.get(user_id).getEmployeeId()!=client_id) // check the given client id and user id are same
            {
                if(!personal_details_database.get(client_id).getRole().equals(personal_details_database.get(user_id).getRole())) // check the client and the user are in same role
                {
                    if (personal_details_database.get(user_id).getTeamName().equals(personal_details_database.get(client_id).getTeamName())) // check client and user are in same team
                    {
                        switch (personal_details_database.get(user_id).getRole()) {
                            case "MANAGER": // manager can change role for pt to mts
                            {
                                if (personal_details_database.get(client_id).getRole().equals("PT")) // check the client is PT
                                    {
                                        view.line();
                                        System.out.println("entered employee role is PT\nyou can change to MTS");
                                        view.line();
                                    while (switcher) {
                                        choice = getDetails.confirmation();
                                        switch (choice) {
                                            case 1 -> {
                                                personal_details_database.get(client_id).setRole("MTS");
                                                System.out.println("the employee role successfully changed to MTS");
                                                view.line();
                                                switcher = false;
                                            }
                                            case 2 -> {
                                                System.out.println("cancelled successfully");
                                                view.line();
                                                switcher = false;
                                            }
                                            default -> {
                                                System.out.println("invalid command");
                                                view.line();
                                            }
                                        }
                                    }
                                }
                                else {
                                    view.line();
                                    System.out.println("the entered employee role : " + personal_details_database.get(client_id).getRole());
                                    System.out.println("you are only permitted to change the role of PT to MTS");
                                    view.line();
                                }
                                break;
                            }
                            case "SUPERADMIN": {}
                            case "ADMIN": {
                                if (personal_details_database.get(client_id).getRole().equals("MTS") || personal_details_database.get(client_id).getRole().equals("PT")) //check the client is MTS or PT
                                {
                                    switch (getDetails.confirmation()) {
                                        case 1 -> {
                                            if (personal_details_database.get(client_id).getRole().equals("MTS")) // check client is MTS
                                            {
                                                view.line();
                                                personal_details_database.get(client_id).setRole("MANAGER");
                                                System.out.println("the employee role successfully changed to Manager");
                                                view.line();
                                            } else if (personal_details_database.get(client_id).getRole().equals("PT")) // check client is PT
                                            {
                                                view.line();
                                                personal_details_database.get(client_id).setRole("MTS");
                                                System.out.println("the employee role successfully changed to MTS");
                                                view.line();
                                            }
                                        }
                                        case 2 -> {
                                            view.line();
                                            System.out.println("cancelled successfully");
                                            view.line();
                                        }
                                    }
                                } else {
                                    view.line();
                                    System.out.println("the entered employee role : " + personal_details_database.get(client_id).getRole());
                                    System.out.println("you are only permitted to change the role of MTS to Manager and PT to MTS");
                                    view.line();
                                }
                                break;
                            }
                        }
                    }
                    else {
                    view.line();//dc
                    System.out.println("the employee id you have entered is not in your team");
                }
                }
                else{
                    view.line();//dc
                    System.out.println("you cannot change the role of employee equivalent to your role");
                    view.line();
                }
            }
            else{
                view.line();
                System.out.println("you cannot change your role yourself");
                view.line();
            }
        }
        else{
            view.line();
            System.out.println("No employee found in this id \ntry again");
            view.line();
        }
    }
    public void remove(OrganizationDetails organization_database, String username){
        HashMap<Long, PersonalDetails> personalDetails_database=organization_database.getPersonalDetailsDatabase();
        boolean switcher=true;
        long client_id= getDetails.id("employee id");
        Long user_id=organization_database.getAuthenticationDatabase().get(username).getEmployeeId();
        String user_role=personalDetails_database.get(user_id).getRole();
        String client_role=personalDetails_database.get(client_id).getRole();


        while(switcher){
            if(organization_database.getPersonalDetailsDatabase().get(client_id)!=null) // check client data in database
            {
                switcher=false;
                if(client_id==user_id) // check the client id and user id are same
                {
                    view.line();
                    System.out.println("your cannot remove your self from the organization");
                    view.line();
                }
                else if((client_role).equals(user_role)) // check the client and user role are same
                {
                    view.line();
                    System.out.println("you cannot remove the employee with same role");
                    view.line();
                }
                else if(organization_database.getPositions().get(client_role)<organization_database.getPositions().get(user_role) || (user_role.equals("SUPERADMIN") && client_role.equals("ADMIN"))) // check the position
                {
                    view.line();
                    System.out.println("you cannot remove a "+personalDetails_database.get(client_id).getRole());
                    view.line();
                }
                else{
                    boolean inner_switcher=true;
                    while (inner_switcher){
                        switch(getDetails.confirmation()){
                            case 1 ->
                            {
                                view.line();
                                personalDetails_database.remove(client_id);
                                organization_database.getAuthenticationDatabase().remove(username.replaceAll("\\d","")+client_id);
                                System.out.println("employee details removed successfully");
                                view.line();
                                inner_switcher=false;
                            }
                            case 2->
                            {
                                view.line();
                                System.out.println("cancelled successfully");
                                view.line();
                                inner_switcher=false;
                            }
                            default->{
                                view.line();
                                System.out.println("invalid command");
                                view.line();
                            }
                        }
                    }
                }
            }
            else{
                System.out.println("No employee found in this id \ntry again");
                view.line();
            }
        }
    }
    public void changeAccess(HashMap<Long, PersonalDetails> personal_details_database,Long user_id){
        PersonalDetails user_details=personal_details_database.get(user_id);
        boolean switcher=true;
        boolean inner_switcher=true;


        while(switcher){
            long client_id= getDetails.id("employee id");
            if(personal_details_database.get(client_id)!=null) // check the client data in database
            {
                switcher=false;
                if(!(personal_details_database.get(client_id).getRole()).equals(user_details.getRole()) && !(personal_details_database.get(client_id).getRole()).equals("SUPERADMIN")) //check roles
                {
                    while(inner_switcher){
                        view.line();
                        System.out.println("the given employee access status : "+(personal_details_database.get(client_id).getAccessStatus()?"permitted":"denied"));
                        view.line();
                        System.out.println("""
                            1 restrict access
                            2 allow access
                            0 back""");
                        switch(getDetails.choice("choice")){
                            case 1-> // restrict access
                            {
                                personal_details_database.get(client_id).setAccessStatus(false);
                                System.out.println("Access restricted successfully");
                                view.line();
                                inner_switcher=false;
                            }
                            case 2-> // allowed access
                            {
                                personal_details_database.get(client_id).setAccessStatus(true);
                                System.out.println("Access allowed successfully");
                                view.line();
                                inner_switcher=false;
                            }
                            case 0->inner_switcher=false; // go back
                            default -> {
                                System.out.println("invalid command");
                                view.line();
                            }
                        }
                    }
                }
                else if(user_details.getEmployeeId()==client_id) // check the client id and user id are same
                {
                    view.line();
                    System.out.println("access denied");
                    System.out.println("you cannot restrict yourself");
                    view.line();
                }
                else{
                    view.line();
                    System.out.println("Access denied");
                    view.line();
                }
            }
            else{
                System.out.println("No data found in this user id\ntry again");
                view.line();
            }
        }
    }
}
