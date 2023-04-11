import java.util.HashMap;

public class OrganizationDetails {
    private long emp_id=1;
    private final String organization_name;
    private final HashMap<String, TeamMemberList> team_database=new HashMap<>();
    private final HashMap<Long, PersonalDetails> personal_details_database=new HashMap<>();
    private final HashMap<String, AuthenticationDetails > authentication_database=new HashMap<>();
    private final HashMap<String,Long> mail_database=new HashMap<>();
    private final HashMap<String,Integer> positions=new HashMap<>();
    private Boolean access_status;


    OrganizationDetails(String organization_name){
        this.organization_name=organization_name;
        this.access_status=true;
        this.positions.put("SUPERADMIN",1);
        this.positions.put("ADMIN",2);
        this.positions.put("MANAGER",3);
        this.positions.put("MTS",4);
        this.positions.put("PT",5);
    }


    public long getId(){
        return emp_id;
    }
    public void setId(Long emp_id){
        this.emp_id=emp_id;
    }
    public String getOrganizationName(){return organization_name;}
    public HashMap<String, TeamMemberList> getTeamDatabase(){return team_database;}
    public HashMap<Long, PersonalDetails> getPersonalDetailsDatabase(){return personal_details_database;}
    public HashMap<String, AuthenticationDetails > getAuthenticationDatabase(){return authentication_database;}
    public HashMap<String,Long> getMailDatabase(){return mail_database;}
    public Boolean getAccessStatus(){return access_status;}
    public HashMap<String,Integer> getPositions(){return positions;}
    public void setAccessStatus(Boolean access_status){this.access_status=access_status;}
}
