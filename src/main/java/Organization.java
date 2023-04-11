import java.util.HashMap;
public class Organization {
    private View view=new View();
    private GetDetails getDetails=new GetDetails();
    private Employee employee=new Employee();
    public void add(HashMap<String, OrganizationDetails> database){
        String organization_name = getDetails.organizationName("Enter the organization name");
        database.put(organization_name, new OrganizationDetails(organization_name));
        view.line();
        System.out.println("you should need to add a admin to the newly created organization");
        view.line();
        employee.add(database.get(organization_name), "ADMIN");
    }
    public void changeAccess(HashMap<String, OrganizationDetails> database, String user_organization_name){
        boolean switcher=true;
        boolean inner_switcher=true;
        while(switcher){
            String organization_name = getDetails.organizationName("enter the organization name you want to change access");
            if(database.get(organization_name)!=null) // check organization available in database
            {
                switcher=false;
                if (organization_name.equals(user_organization_name)) // check the given organization and user organization are same
                {
                    view.line();
                    System.out.println("you cannot restrict your own organization");
                    System.out.println("access denied");
                    view.line();
                }
                else {
                    while(inner_switcher){
                        view.line();
                        System.out.println("the given organization access status : "+(database.get(organization_name).getAccessStatus()?"Permitted":"denied"));
                        view.line();
                        System.out.println("""
                            1 restrict access
                            2 allow access
                            0 go back""");
                        switch(getDetails.choice("choice")){
                            case 1-> // restrict organization access
                            {
                                database.get(organization_name).setAccessStatus(false);
                                view.line();
                                System.out.println("the given organization access is restricted successfully");
                                view.line();
                                inner_switcher=false;
                            }
                            case 2-> // allow organization access
                            {
                                database.get(organization_name).setAccessStatus(true);
                                view.line();
                                System.out.println("the given organization access is permitted successfully");
                                view.line();
                                inner_switcher=false;
                            }
                            case 0->inner_switcher=false;// go back
                            default -> {
                                System.out.println("invalid command");
                                view.line();
                            }
                        }

                    }
                }
            }
            else{
                view.line();
                System.out.println("entered organization name is not in the database\nenter the name properly");
                view.line();
            }
        }
    }
}
