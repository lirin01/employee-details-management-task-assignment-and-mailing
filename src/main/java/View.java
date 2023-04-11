import java.util.HashMap;
public class View {
    GetDetails getDetails=new GetDetails();

    public void line() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
    }
    public void tableView(HashMap<Long, PersonalDetails> personal_details_database){
        int choice=Integer.MIN_VALUE;
        while (choice!=0){
            System.out.println("""
                1 view with filter
                2 view without filer
                0 to go back""");
            choice=getDetails.choice("choice");
            switch(choice){
                case 1-> //with filter
                {
                    String identifier="";
                    while(identifier.equals("")){
                        System.out.println("""
                        1 filter admin
                        2 filter manager
                        3 filter MTS
                        4 filter Pt""");

                        switch (getDetails.choice("choice")){
                            case 1->identifier="ADMIN";
                            case 2->identifier="MANAGER";
                            case 3->identifier="MTS";
                            case 4->identifier="PT";
                            default->{
                                System.out.println("invalid command");
                                line();
                            }
                        }
                    }
                    String format = ("|%10s    |%15s    |%15s    |%16s    |%15s    |%18s    |%20s    |%15s    |%15s   |%n");
                    System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________");
                    System.out.format(format, "Employee id", "First name", "Second name", "Contact number", "Role","Team name","Email address", "Jointed time", "Jointed date");
                    System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________");
                    for (Long individual_key : personal_details_database.keySet()) {
                        PersonalDetails individual_data=personal_details_database.get(individual_key);
                        if(individual_data.getRole().equals(identifier)){
                            System.out.format(format, individual_data.getEmployeeId(), individual_data.getFirstName(), individual_data.getSecondName(), individual_data.getContactNumber(), individual_data.getRole(),individual_data.getTeamName(),individual_data.getMailId(),individual_data.getJointedTime(), individual_data.getJointedDate());
                            System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________");
                        }
                    }
                }
                case 2-> //without filter
                {
                    String format = ("|%20s    |%20s    |%20s    |%18s    |%20s    |%15s    |%15s    |%15s   |%n");
                    System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________");
                    System.out.format(format, "Employee id", "First name", "Second name", "Contact number", "Role", "Team name" ,"Jointed time", "Jointed date");
                    System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________");
                    for (Long individual_key : personal_details_database.keySet()) {
                        PersonalDetails individual_data=personal_details_database.get(individual_key);
                        if(!individual_data.getRole().equals("SUPERADMIN")){
                            System.out.format(format, individual_data.getEmployeeId(), individual_data.getFirstName(), individual_data.getSecondName(), individual_data.getContactNumber(), individual_data.getRole(),individual_data.getTeamName(),individual_data.getJointedTime(), individual_data.getJointedDate());
                            System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________");
                        }
                    }
                }
                case 0->{}
                default->{
                    System.out.println("invalid command");
                    line();
                }
            }
        }

    }
    public void inCompleteYourTask(PersonalDetails individual_details,Long a){
        line();
        System.out.println("Task NO     : "+individual_details.getYourTask().get(a).getTaskId());
        System.out.println("Assigned by : "+individual_details.getYourTask().get(a).getAssignedBy());
        System.out.println("Role        : "+individual_details.getYourTask().get(a).getRole());
        System.out.println("Task status : "+(((individual_details.getYourTask().get(a).getTaskStatus()))?"incomplete":"completed"));
        System.out.println("Task title  : "+individual_details.getYourTask().get(a).getTaskTitle());
        System.out.println("Description : "+individual_details.getYourTask().get(a).getTaskDescription());
    }
    public void completedYourTask(PersonalDetails individual_details,Long b) {
        line();
        System.out.println("Task NO     : "+individual_details.getCompletedYourTask().get(b).getTaskId());
        System.out.println("Assigned by : "+individual_details.getCompletedYourTask().get(b).getAssignedBy());
        System.out.println("Role        : "+individual_details.getCompletedYourTask().get(b).getRole());
        System.out.println("Task status : "+(((individual_details.getCompletedYourTask().get(b).getTaskStatus()))?"incomplete":"completed"));
        System.out.println("Task title  : "+individual_details.getCompletedYourTask().get(b).getTaskTitle());
        System.out.println("Description : "+individual_details.getCompletedYourTask().get(b).getTaskDescription());
    }
    public void inCompleteTaskAssigned(PersonalDetails individual_details,Long b){
        line();
        System.out.println("Task        : "+individual_details.getTaskAssigned().get(b).getTaskId());
        System.out.println("Assigned to : "+individual_details.getTaskAssigned().get(b).getAssignedTo());
        System.out.println("Task status : "+(((individual_details.getTaskAssigned().get(b).getTaskStatus()))?"incomplete":"completed"));
        System.out.println("Task title  : "+individual_details.getTaskAssigned().get(b).getTaskTitle());
        System.out.println("Description : "+individual_details.getTaskAssigned().get(b).getTaskDescription());
    }
    public void completedAssignedTask(PersonalDetails individual_details,Long b){
        line();
        System.out.println("Task        : "+individual_details.getCompletedTaskAssigned().get(b).getTaskId());
        System.out.println("Assigned to : "+individual_details.getCompletedTaskAssigned().get(b).getAssignedTo());
        System.out.println("Task status : "+(((individual_details.getCompletedTaskAssigned().get(b).getTaskStatus()))?"incomplete":"completed"));
        System.out.println("Task title  : "+individual_details.getCompletedTaskAssigned().get(b).getTaskTitle());
        System.out.println("Description : "+individual_details.getCompletedTaskAssigned().get(b).getTaskDescription());
    }
}

