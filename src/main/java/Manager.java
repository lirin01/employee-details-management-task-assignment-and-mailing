import java.util.ArrayList;
import java.util.HashMap;

interface Manager extends PT {
    void viewAll(HashMap<Long, PersonalDetails> database);
    void addNewTask(HashMap<Long, PersonalDetails> personal_details_database,PersonalDetails user_details);
    void viewTaskAssigned(PersonalDetails user_details);
    void addNewEmployee(OrganizationDetails organization_database,PersonalDetails user_details);
    void removeEmployee(OrganizationDetails organization_database, String username);
    void changeTaskStatus(HashMap<Long, PersonalDetails> personal_details_database,PersonalDetails user_details);
    void mentor(HashMap<Long, PersonalDetails> personal_details_database , Long user_id,HashMap<String, TeamMemberList> team_database);
    void changeEmployeeRole(HashMap<Long, PersonalDetails> personal_details_database, ArrayList<Long> team_member_list, Long user_id);
}
