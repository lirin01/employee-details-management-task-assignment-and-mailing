public class TaskAssignedDetails {
    private String assigned_to;
    private String task_title;
    private String task_description;
    private boolean task_status;
    private Long task_id;


    TaskAssignedDetails(PersonalDetails individual_details,String assigned_to, String task_title, String task_description){
        this.assigned_to=assigned_to;
        this.task_title=task_title;
        this.task_description=task_description;
        this.task_status=true;
        this.task_id=individual_details.getTaskId();
        individual_details.setTaskId(individual_details.getTaskId()+1);
    }


    public String getAssignedTo() {return assigned_to;}
    public String getTaskTitle(){return task_title;}
    public String getTaskDescription(){return task_description;}
    public boolean getTaskStatus(){return task_status;}
    public void setTaskStatus(boolean task_status){this.task_status=task_status;}
    public Long getTaskId(){return task_id;}
}
