import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class PersonalDetails {
    private Long task_id=1l;
    private String first_name;
    private String second_name;
    private long contact_number;
    private String role;
    private Long employee_id;
    private String team_name;
    private Long reporting_to;
    private ArrayList<Long> direct_report =new ArrayList<>();
    private HashMap<Long,YourTaskDetails> your_task=new HashMap<>();
    private HashMap<Long,TaskAssignedDetails> task_assigned=new HashMap<>();
    private HashMap<Long,YourTaskDetails> completed_your_task=new HashMap<>();
    private HashMap<Long,TaskAssignedDetails> completed_task_assigned=new HashMap<>();
    private Stack<ReceivedMailDetails> received_mail=new Stack<>();
    private ArrayList<ReceivedMailDetails> inbox=new ArrayList<>();
    private ArrayList<SentMailDetails> mail_sent=new ArrayList<>();
    private String mail_id;
    private String jointed_time=LocalDateTime.now().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    private String jointed_date=LocalDateTime.now().toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    private boolean access_status;


    PersonalDetails(String first_name, String second_name, long contact_number, String role, OrganizationDetails organization_database, String mail_id, String team_name){
        this.first_name=first_name;
        this.second_name=second_name;
        this.contact_number=contact_number;
        this.role=role.toUpperCase();
        this.mail_id=mail_id;
        this.team_name=team_name;
        this.employee_id= organization_database.getId();
        organization_database.setId((organization_database.getId()+1));
        access_status=true;
    }


    public Long getTaskId(){
        return task_id;
    }
    public void setTaskId(Long task_id){
        this.task_id=task_id;
    }
    public String getFirstName(){return first_name;}
    public void setFirstName(String first_name){this.first_name=first_name;}
    public String getSecondName(){return second_name;}
    public void setSecondName(String second_name){this.second_name=second_name;}
    public long getContactNumber(){return contact_number;}
    public void setContactNumber(long contact_number){this.contact_number=contact_number;}
    public String getRole(){return role;}
    public void setRole(String role){this.role=role;}
    public Long getEmployeeId(){return employee_id;}
    public String getTeamName(){return team_name;}
    public Long getReportingTo(){return reporting_to;}
    public void setReportingTo(Long reporting_to){this.reporting_to=reporting_to;}
    public ArrayList<Long> getDirectReport(){return direct_report;}
    public HashMap<Long,YourTaskDetails> getYourTask(){return your_task;}
    public HashMap<Long,TaskAssignedDetails> getTaskAssigned(){return task_assigned;}
    public HashMap<Long,YourTaskDetails> getCompletedYourTask(){return completed_your_task;}
    public HashMap<Long,TaskAssignedDetails> getCompletedTaskAssigned(){return completed_task_assigned;}
    public Stack<ReceivedMailDetails> getReceivedMail(){return received_mail;}
    public ArrayList<ReceivedMailDetails> getInbox(){return inbox;}
    public ArrayList<SentMailDetails> getMailSent(){return mail_sent;}
    public String getMailId(){return mail_id;}
    public void setMailId(String mail_id){this.mail_id=mail_id;}
    public String getJointedTime(){return jointed_time;}
    public String getJointedDate(){return jointed_date;}
    public boolean getAccessStatus(){return access_status;}
    public void setAccessStatus(boolean access_status){this.access_status=access_status;}
}
