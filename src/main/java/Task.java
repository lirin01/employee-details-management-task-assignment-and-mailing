import java.util.HashMap;

public class Task {
    private View view=new View();
    private GetDetails getDetails=new GetDetails();

    public void add(HashMap<Long, PersonalDetails> personal_details_database, PersonalDetails user_details){
        long client_id= getDetails.id("Enter the id of the employee you want to assign task");
        PersonalDetails assign_to=personal_details_database.get(client_id);
        view.line();
        if(personal_details_database.get(client_id)!=null) // check client data found in database
        {
            if(assign_to.getYourTask().get(user_details.getEmployeeId())==null) // check any incomplete task assigned by you
            {
                if(user_details.getEmployeeId()==client_id) // check client id and user id are same
                {
                    System.out.println("you cannot assign task to your self");
                    view.line();
                }
                else if((assign_to.getRole()).equals(user_details.getRole())) // check user role and client role are same
                {
                    System.out.println("you cannot assign a task to employee with same role");
                    System.out.println("<---- access denied ---->");
                    view.line();
                }
                else if (user_details.getRole().equals("MTS") && personal_details_database.get(client_id).getRole().equals("MANAGER")) // check the user is MTS and client manager
                {
                    System.out.println("you cannot able to assign task to the manager");
                    System.out.println("<---- access denied ---->");
                    view.line();
                }
                else{
                    String task_title=getDetails.statement("Enter the title of the task");
                    String task_description= getDetails.statement("Enter the task description");
                    assign_to.getYourTask().put(user_details.getEmployeeId(),new YourTaskDetails(assign_to,user_details.getFirstName()+" "+user_details.getSecondName(),task_title,task_description,user_details.getRole()));
                    user_details.getTaskAssigned().put(client_id,new TaskAssignedDetails(assign_to,assign_to.getFirstName()+" "+assign_to.getSecondName(),task_title,task_description));
                    view.line();
                    System.out.println("task assigned successfully");
                    view.line();
                }
            }
            else if(assign_to.getYourTask().get(user_details.getEmployeeId()).getTaskStatus()) // check te task status
            {
                view.line();
                System.out.println("you have already assigned a task which is incomplete");
                view.line();
            }
        }
        else{
            view.line();
            System.out.println("No data found in this id\ntry again");
            view.line();
        }

    }
    public void viewYourTask(PersonalDetails user_details){
            view(1,user_details);
    }
    public void viewTaskAssigned(PersonalDetails user_details){
            view(2,user_details);
    }
    public void view(int choice,PersonalDetails user_details){
        int outer_choice=Integer.MIN_VALUE;
        while(outer_choice!=0){
            System.out.println("""
                    1  incomplete task
                    2  completed task
                    3  all task
                    0  back""");
            switch (choice){
                case 1-> // view your task
                {
                    outer_choice=getDetails.choice("choice");
                    switch(outer_choice){
                        case 1->
                        {
                            if(user_details.getYourTask().size()==0) // check user has any incomplete task
                            {
                                view.line();//dc
                                System.out.println("you have no in complete task");
                                view.line();
                            }
                            else
                            {
                                for (Long a:user_details.getYourTask().keySet()) {
                                    view.inCompleteYourTask(user_details,a);
                                }
                                view.line();
                            }
                        }
                        case 2->
                        {
                            if(user_details.getCompletedYourTask().size()==0) // check user has any completed task
                            {
                                view.line();//dc
                                System.out.println("you have no completed task");
                                view.line();
                            }
                            else
                            {
                                for (Long b:user_details.getCompletedYourTask().keySet()) {
                                    view.completedYourTask(user_details,b);
                                }
                                view.line();
                            }
                        }
                        case 3->
                        {
                            if(user_details.getYourTask().size()==0 && user_details.getCompletedYourTask().size()==0) // check the user has any task(completed or incompleted)
                            {
                                view.line();//dc
                                System.out.println("no task found");
                                view.line();
                            }
                            else{
                                for (Long a:user_details.getYourTask().keySet()) {
                                    view.inCompleteYourTask(user_details,a);
                                }
                                for (Long b:user_details.getCompletedYourTask().keySet()) {
                                    view.completedYourTask(user_details,b);
                                }
                                view.line();
                            }
                        }
                        case 0 ->{}
                        default -> {
                            view.line();
                            System.out.println("invalid command");
                            view.line();
                        }
                    }
                }
                case 2-> // view the task you assigned
                {
                    outer_choice=getDetails.choice("choice");
                    switch(outer_choice){
                        case 1->
                        {
                            if(user_details.getTaskAssigned().size()==0) // check user have assigned any task in incomplete state
                            {
                                view.line();//dc
                                System.out.println("the task assigned by you is not in incomplete state");
                                view.line();
                            }
                            else{
                                for (Long b: user_details.getTaskAssigned().keySet()) {
                                    view.inCompleteTaskAssigned(user_details,b);
                                }
                                view.line();
                            }
                        }
                        case 2->
                        {
                            if(user_details.getCompletedTaskAssigned().size()==0) // check user have assigned any task in complete state
                            {
                                view.line();//dc
                                System.out.println("the task assigned by you is not in incomplete state");
                                view.line();
                            }
                            else{
                                for (Long b: user_details.getCompletedTaskAssigned().keySet()) {
                                    view.completedAssignedTask(user_details,b);
                                }
                                view.line();
                            }
                        }
                        case 3->
                        {
                            if(user_details.getTaskAssigned().size()==0 && user_details.getCompletedTaskAssigned().size()==0) // check user have assigned any task in both complete and incomplete state
                            {
                                view.line();//dc
                                System.out.println("you have not assigned any task");
                            }
                            else{
                                for (Long b: user_details.getTaskAssigned().keySet()) {
                                    view.inCompleteTaskAssigned(user_details,b);
                                }
                                for (Long b: user_details.getCompletedTaskAssigned().keySet()) {
                                    view.completedAssignedTask(user_details,b);
                                }
                                view.line();
                            }
                        }
                        case 0-> {}
                        default -> {
                            view.line();
                            System.out.println("invalid command");
                            view.line();
                        }
                    }

                }
            }
        }
    }
    public void changeTaskStatus(HashMap<Long, PersonalDetails> personal_details_database,PersonalDetails user_details){
        if(user_details.getTaskAssigned().size()==0){
            System.out.println("you have not assigned any task");
            view.line();
        }
        else{
            boolean switcher=true;
            while(switcher){
                long id= getDetails.id("Enter the id of the employee you want to change task status");
                PersonalDetails task=personal_details_database.get(id);
                view.line();
                if(personal_details_database.get(id)!=null){
                    System.out.println("""
                    1 change the task to completed status
                    2 change the task to incomplete status
                    0 back""");
                    view.line();
                    switch(getDetails.choice("choice")){
                        case 1->
                        {
                            view.line();
                            if(task.getYourTask().get(user_details.getEmployeeId())==null) // check you have any task assigned
                            {
                                view.line();
                                System.out.println("you have not assigned any task to the employee");
                                view.line();
                            }
                            else{
                                switcher=false;
                                task.getYourTask().get(user_details.getEmployeeId()).setTaskStatus(false);
                                task.getCompletedYourTask().put(task.getYourTask().get(user_details.getEmployeeId()).getTaskId(),task.getYourTask().get(user_details.getEmployeeId()));
                                task.getYourTask().remove(user_details.getEmployeeId());
                                user_details.getTaskAssigned().get(id).setTaskStatus(false);
                                user_details.getCompletedTaskAssigned().put(user_details.getTaskAssigned().get(id).getTaskId(),user_details.getTaskAssigned().get(id));
                                user_details.getTaskAssigned().remove(id);
                                System.out.println("task status changed from incomplete to completed");
                                view.line();
                            }
                        }
                        case 2->
                        {
                            long task_id=getDetails.id("enter the task id");
                            if(task.getCompletedYourTask().get(task_id)==null){
                                System.out.println("you have not assigned any task to the employee with completed status");
                                view.line();
                            }
                            else{
                                if(task.getYourTask().get(user_details.getEmployeeId())!=null){
                                    System.out.println("the has a pending task which you have assigned finish it first...");
                                    view.line();
                                }
                                else{
                                    switcher=false;
                                    task.getCompletedYourTask().get(task_id).setTaskStatus(true);
                                    task.getYourTask().put(user_details.getEmployeeId(),task.getCompletedYourTask().get(task_id));
                                    task.getCompletedYourTask().remove(task_id);
                                    user_details.getCompletedTaskAssigned().get(task_id).setTaskStatus(true);
                                    user_details.getTaskAssigned().put(id,user_details.getCompletedTaskAssigned().get(task_id));
                                    user_details.getCompletedTaskAssigned().remove(task_id);
                                    System.out.println("task status changed from complete to incomplete");
                                    view.line();
                                }
                            }
                        }
                        case 0->switcher=false;
                        default -> {
                            view.line();
                            System.out.println("invalid command");
                            view.line();
                        }
                    }

                }
                else{
                    System.out.println("No data found in this id\ntry again");
                    view.line();
                }
            }
        }
    }
}
