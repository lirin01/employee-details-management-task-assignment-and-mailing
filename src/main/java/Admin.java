import java.util.ArrayList;
import java.util.HashMap;

public interface Admin extends PT{
    void changeEmployeeAccess(HashMap<Long,PersonalDetails> organization_database, Long user_id);
    void addNewEmployee(OrganizationDetails organization_database,PersonalDetails user_details);
    void removeEmployee(OrganizationDetails organization_database, String username);
    void viewAll(HashMap<Long, PersonalDetails> database);
    void addNewTeam(OrganizationDetails team_details);
    void changeEmployeeRole(HashMap<Long, PersonalDetails> personal_details_database, ArrayList<Long> team_member_list, Long user_id);
}
