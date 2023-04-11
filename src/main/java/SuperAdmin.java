import java.util.ArrayList;
import java.util.HashMap;

public interface SuperAdmin extends PT {
    void addNewOrganization(HashMap<String, OrganizationDetails> database);
    void changeOrganizationAccess(HashMap<String, OrganizationDetails> database, String user_organization_name);
    void changeEmployeeAccess(HashMap<Long,PersonalDetails> organization_database, Long user_id);
    void addNewEmployee(OrganizationDetails organization_database,PersonalDetails user_details);
    void removeEmployee(OrganizationDetails organization_database, String username);
    void viewAll(HashMap<Long, PersonalDetails> database);
    void addNewTeam(OrganizationDetails team_details);
    void changeEmployeeRole(HashMap<Long, PersonalDetails> personal_details_database, ArrayList<Long> team_member_list, Long user_id);
}
