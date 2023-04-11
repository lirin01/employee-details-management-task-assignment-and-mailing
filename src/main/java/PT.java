import java.util.ArrayList;
import java.util.HashMap;

interface PT {
    void profile(HashMap<Long, PersonalDetails> personal_details_database,AuthenticationDetails user_authentication_details, Long user_id, HashMap<String,Long> mail_database);
    void mail(HashMap<String,Long> mail_database,HashMap<Long, PersonalDetails> personal_details_database,Long user_id  );
    void viewYourTeam(HashMap<Long, PersonalDetails> personal_details_database, ArrayList<Long> team_member_list);
}