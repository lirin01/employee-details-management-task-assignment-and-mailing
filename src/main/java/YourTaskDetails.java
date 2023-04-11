public class YourTaskDetails {
    private Long task_id;
    private String assigned_by;
    private String task_title;
    private String task_description;
    private String role;
    private boolean task_status;


    YourTaskDetails(PersonalDetails user_details,String assigned_by, String task_title, String description, String role){
        this.assigned_by=assigned_by;
        this.task_title=task_title;
        this.task_description=description;
        this.role=role;
        this.task_id= user_details.getTaskId();
        this.task_status=true;
    }


    public Long getTaskId(){return task_id;}
    public String getAssignedBy(){return assigned_by;}
    public String getTaskTitle(){return task_title;}
    public String getTaskDescription(){return task_description;}
    public String getRole(){return role;}
    public boolean getTaskStatus(){return task_status;}
    public void setTaskStatus(boolean task_status){this.task_status=task_status;}
}
