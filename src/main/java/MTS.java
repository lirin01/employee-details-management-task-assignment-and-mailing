import java.util.HashMap;

public interface MTS extends PT {
    void addNewTask(HashMap<Long, PersonalDetails> personal_details_database, PersonalDetails user_details);
    void viewYourTask(PersonalDetails user_details);
    void viewTaskAssigned(PersonalDetails user_details);
    void changeTaskStatus(HashMap<Long, PersonalDetails> personal_details_database,PersonalDetails user_details);
}
