import java.util.ArrayList;
import java.util.HashMap;

public class Search {
    private View view = new View();
    private GetDetails getDetails=new GetDetails();
    public PersonalDetails search(HashMap<Long, PersonalDetails> personal_details_database) {
        PersonalDetails data = null;
        boolean switcher=true;
        while(switcher){
            System.out.println("""
                1 search by ID
                2 search by name
                0 back""");
            int choice=getDetails.choice("choice");
            switch (choice) {
                case 1 -> {
                    view.line();
                    long client_id = getDetails.id("employee id");
                    view.line();//dr
                    data = personal_details_database.get(client_id);
                    switcher=false;
                }
                case 2 -> {
                    ArrayList<Long> list=new ArrayList<>();
                    view.line();
                    String first_name = getDetails.name("first name");
                    String second_name = getDetails.name("second name");
                    view.line();
                    for (Long a : personal_details_database.keySet()) {
                        if ((personal_details_database.get(a)).getFirstName().equals(first_name) && (personal_details_database.get(a)).getSecondName().equals(second_name)) {
                            list.add(personal_details_database.get(a).getEmployeeId());
                        }
                    }
                    if(list.isEmpty());// return null
                    else if(list.size()==1){
                        data=personal_details_database.get(list.get(0));
                    }
                    else {
                        String format = ("|%15s    |%15s    |%15s    |%15s    |%18s    |%n");
                        System.out.println("_____________________________________________________________________________________________________________________________");
                        System.out.format(format, "Employee id", "First name", "Second name", "Role","Team name");
                        System.out.println("_____________________________________________________________________________________________________________________________");
                        for(Long i:list){
                            System.out.format(format, personal_details_database.get(i).getEmployeeId(), personal_details_database.get(i).getFirstName(), personal_details_database.get(i).getSecondName(), personal_details_database.get(i).getRole(),personal_details_database.get(i).getTeamName());
                            System.out.println("_____________________________________________________________________________________________________________________________");
                        }
                        view.line();
                        System.out.println("these are the matches found");
                        view.line();
                        data=personal_details_database.get(getDetails.id("enter the employee id from the above matches"));
                    }
                    switcher=false;
                }
                case 0 ->switcher=false;
                default-> {
                    view.line();
                    System.out.println("invalid command");
                    view.line();
                }
            }
        }
        return data;
    } // search by id or name
}
