import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    private static Model model=null;
    private Model(){}
    public static Model getInstance(){ // singleton
        if(model==null){
            model=new Model();
        }
        return model;
    }
    private HashMap<String, OrganizationDetails> database=new HashMap<>();
    ArrayList<Long> initializer=new ArrayList<>();


    {
        database.put("ZOHO",new OrganizationDetails("ZOHO"));
        database.get("ZOHO").getTeamDatabase().put("CRM",new TeamMemberList());
        database.get("ZOHO").getTeamDatabase().put("ADMINISTRATION",new TeamMemberList());
        database.get("ZOHO").getTeamDatabase().put("PROJECTS",new TeamMemberList());

        database.get("ZOHO").getTeamDatabase().get("CRM").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("kamal@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO1",new AuthenticationDetails(database.get("ZOHO").getId(),"a"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("kamal","s",7893456729L,"MANAGER",database.get("ZOHO"),"kamal@gmail.com","CRM"));


        database.get("ZOHO").getTeamDatabase().get("CRM").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("suresh@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO2",new AuthenticationDetails(database.get("ZOHO").getId(),"b"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("suresh","v",8246372892L,"MTS",database.get("ZOHO"),"suresh@gmail.com","CRM"));

        database.get("ZOHO").getTeamDatabase().get("CRM").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("kumar@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO3",new AuthenticationDetails(database.get("ZOHO").getId(),"c"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("kumar","u",7284938473L,"PT",database.get("ZOHO"),"kumar@gmail.com","CRM"));

        database.get("ZOHO").getTeamDatabase().get("ADMINISTRATION").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("velraj@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO4",new AuthenticationDetails(database.get("ZOHO").getId(),"d"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("vel","raj",9647291483L,"ADMIN",database.get("ZOHO"),"velraj@gmail.com","ADMINISTRATION"));

        database.get("ZOHO").getTeamDatabase().get("ADMINISTRATION").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("vimal@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO5",new AuthenticationDetails(database.get("ZOHO").getId(),"admin"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("vimal","k",9647361836L,"SUPERADMIN",database.get("ZOHO"),"vimal@gmail.com","ADMINISTRATION"));

        database.get("ZOHO").getTeamDatabase().get("CRM").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("ravi@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO6",new AuthenticationDetails(database.get("ZOHO").getId(),"e"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("ravi","s",8745638275L,"PT",database.get("ZOHO"),"ravi@gmail.com","CRM"));

        database.get("ZOHO").getTeamDatabase().get("CRM").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("jeeva@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO7",new AuthenticationDetails(database.get("ZOHO").getId(),"f"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("jeeva","r",6794678392L,"PT",database.get("ZOHO"),"jeeva@gmail.com","CRM"));

        database.get("ZOHO").getTeamDatabase().get("CRM").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("rejo@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO8",new AuthenticationDetails(database.get("ZOHO").getId(),"g"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("rejo","c",7834678273L,"MTS",database.get("ZOHO"),"kumar@gmail.com","CRM"));

        database.get("ZOHO").getTeamDatabase().get("CRM").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("vasu@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO9",new AuthenticationDetails(database.get("ZOHO").getId(),"h"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("vasu","m",8346732819L,"PT",database.get("ZOHO"),"vasu@gmail.com","CRM"));

        database.get("ZOHO").getTeamDatabase().get("PROJECTS").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("shruthi@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO10",new AuthenticationDetails(database.get("ZOHO").getId(),"i"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("shruthi","a",8264672817L,"MANAGER",database.get("ZOHO"),"shruthi@gmail.com","PROJECTS"));

        database.get("ZOHO").getTeamDatabase().get("PROJECTS").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("gowindh@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO11",new AuthenticationDetails(database.get("ZOHO").getId(),"j"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("gowindh","eshwar",9763426178L,"MTS",database.get("ZOHO"),"gowindh@gmail.com","PROJECTS"));

        database.get("ZOHO").getTeamDatabase().get("PROJECTS").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("lokesh@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO12",new AuthenticationDetails(database.get("ZOHO").getId(),"k"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("lokesh","r",8745634568L,"MTS",database.get("ZOHO"),"lokesh@gmail.com","PROJECTS"));

        database.get("ZOHO").getTeamDatabase().get("PROJECTS").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("vikram@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO13",new AuthenticationDetails(database.get("ZOHO").getId(),"l"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("vikram","s",8744278364L,"PT",database.get("ZOHO"),"vikram@gmail.com","PROJECTS"));

        database.get("ZOHO").getTeamDatabase().get("PROJECTS").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("suriya@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO14",new AuthenticationDetails(database.get("ZOHO").getId(),"m"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("suriya","y",8723846759L,"PT",database.get("ZOHO"),"suriya@gmail.com","PROJECTS"));

        database.get("ZOHO").getTeamDatabase().get("PROJECTS").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("rajkamal@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO15",new AuthenticationDetails(database.get("ZOHO").getId(),"n"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("rajkamal","a",7634527189L,"PT",database.get("ZOHO"),"rajkamal@gmail.com","PROJECTS"));

        database.get("ZOHO").getTeamDatabase().get("CRM").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("hari@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO16",new AuthenticationDetails(database.get("ZOHO").getId(),"o"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("hari","v",7127456383L,"MANAGER",database.get("ZOHO"),"hari@gmail.com","CRM"));

        database.get("ZOHO").getTeamDatabase().get("CRM").getTeamMemberList().add(database.get("ZOHO").getId());
        database.get("ZOHO").getMailDatabase().put("vishnu@gmail.com",database.get("ZOHO").getId());
        database.get("ZOHO").getAuthenticationDatabase().put("ZOHO17",new AuthenticationDetails(database.get("ZOHO").getId(),"p"));
        database.get("ZOHO").getPersonalDetailsDatabase().put(database.get("ZOHO").getId(),new PersonalDetails("vishnu","s",8531297468L,"PT",database.get("ZOHO"),"vishnu@gmail.com","CRM"));
    }//organization 1 (zoho)
    {
        database.get("ZOHO").getPersonalDetailsDatabase().get(1l).getDirectReport().add(2l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(1l).getDirectReport().add(7l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(1l).getDirectReport().add(8l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(2l).setReportingTo(1l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(2l).getDirectReport().add(3l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(2l).getDirectReport().add(6l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(3l).setReportingTo(2l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(6l).setReportingTo(2l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(7l).setReportingTo(1l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(8l).setReportingTo(1l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(9l).setReportingTo(8l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(10l).getDirectReport().add(11l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(11l).setReportingTo(10l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(10l).getDirectReport().add(12l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(12l).setReportingTo(10l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(11l).getDirectReport().add(13l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(13l).setReportingTo(11l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(12l).getDirectReport().add(14l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(14l).setReportingTo(12l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(12l).getDirectReport().add(15l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(15l).setReportingTo(12l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(16l).getDirectReport().add(17l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(17l).setReportingTo(16l);
    }// mentor assign (zoho)
    {
        database.get("ZOHO").getPersonalDetailsDatabase().get(7l).getYourTask().put(1l,new YourTaskDetails(database.get("ZOHO").getPersonalDetailsDatabase().get(7l),"kamal s","Bus ticket booking application","do it by your self","MANAGER"));
        database.get("ZOHO").getPersonalDetailsDatabase().get(1l).getTaskAssigned().put(7l,new TaskAssignedDetails(database.get("ZOHO").getPersonalDetailsDatabase().get(7l),"jeeva r","Bus ticket booking application","do it by your self"));
        database.get("ZOHO").getPersonalDetailsDatabase().get(6l).getYourTask().put(2l,new YourTaskDetails(database.get("ZOHO").getPersonalDetailsDatabase().get(6l),"suresh v","social media application","try to implement more functionality","MTS"));
        database.get("ZOHO").getPersonalDetailsDatabase().get(2l).getTaskAssigned().put(6l,new TaskAssignedDetails(database.get("ZOHO").getPersonalDetailsDatabase().get(6l),"ravi s","social media application","try to implement more functionality"));

    }// assign task(zoho)
    {
        database.get("ZOHO").getPersonalDetailsDatabase().get(2l).getReceivedMail().push(new ReceivedMailDetails(3l, "checking 1", "checking 1"));
        initializer.add(2l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(3l).getMailSent().add(new SentMailDetails(initializer, "checking 1", "checking 1"));
        database.get("ZOHO").getPersonalDetailsDatabase().get(3l).getReceivedMail().push(new ReceivedMailDetails(1l, "checking 2", "checking 2"));
        database.get("ZOHO").getPersonalDetailsDatabase().get(2l).getReceivedMail().push(new ReceivedMailDetails(1l, "checking 2", "checking 2"));
        database.get("ZOHO").getPersonalDetailsDatabase().get(9l).getReceivedMail().push(new ReceivedMailDetails(1l, "checking 2", "checking 2"));
        initializer.clear();
        initializer.add(3l);
        initializer.add(2l);
        initializer.add(9l);
        database.get("ZOHO").getPersonalDetailsDatabase().get(1l).getMailSent().add(new SentMailDetails(initializer, "checking 1", "checking 1"));
    }//email (zoho)
    {
        database.put("TCS",new OrganizationDetails("TCS"));
        database.get("TCS").getTeamDatabase().put("DELTA",new TeamMemberList());
        database.get("TCS").getTeamDatabase().put("ADMINISTRATION",new TeamMemberList());

        database.get("TCS").getTeamDatabase().get("DELTA").getTeamMemberList().add(database.get("TCS").getId());
        database.get("TCS").getMailDatabase().put("murali@gmail.com",database.get("TCS").getId());
        database.get("TCS").getAuthenticationDatabase().put("TCS1",new AuthenticationDetails(database.get("TCS").getId(),"a"));
        database.get("TCS").getPersonalDetailsDatabase().put(database.get("TCS").getId(),new PersonalDetails("murali","s",8145784507l,"MANAGER",database.get("TCS"),"murali@gmail.com","DELTA"));

        database.get("TCS").getTeamDatabase().get("DELTA").getTeamMemberList().add(database.get("TCS").getId());
        database.get("TCS").getMailDatabase().put("divya@gmail.com",database.get("TCS").getId());
        database.get("TCS").getAuthenticationDatabase().put("TCS2",new AuthenticationDetails(database.get("TCS").getId(),"b"));
        database.get("TCS").getPersonalDetailsDatabase().put(database.get("TCS").getId(),new PersonalDetails("divya","b",9523561347l,"MTS",database.get("TCS"),"divya@gmail.com","DELTA"));

        database.get("TCS").getTeamDatabase().get("DELTA").getTeamMemberList().add(database.get("TCS").getId());
        database.get("TCS").getMailDatabase().put("harish@gmail.com",database.get("TCS").getId());
        database.get("TCS").getAuthenticationDatabase().put("TCS3",new AuthenticationDetails(database.get("TCS").getId(),"c"));
        database.get("TCS").getPersonalDetailsDatabase().put(database.get("TCS").getId(),new PersonalDetails("harish","m",8246512389l,"PT",database.get("TCS"),"harish@gmail.com","DELTA"));

        database.get("TCS").getTeamDatabase().get("ADMINISTRATION").getTeamMemberList().add(database.get("TCS").getId());
        database.get("TCS").getMailDatabase().put("devi@gmail.com",database.get("TCS").getId());
        database.get("TCS").getAuthenticationDatabase().put("TCS4",new AuthenticationDetails(database.get("TCS").getId(),"d"));
        database.get("TCS").getPersonalDetailsDatabase().put(database.get("TCS").getId(),new PersonalDetails("devi","h",7345672134l,"ADMIN",database.get("TCS"),"devi@gmail.com","ADMINISTRATION"));

        database.get("TCS").getTeamDatabase().get("DELTA").getTeamMemberList().add(database.get("TCS").getId());
        database.get("TCS").getMailDatabase().put("kumaresan@gmail.com",database.get("TCS").getId());
        database.get("TCS").getAuthenticationDatabase().put("TCS5",new AuthenticationDetails(database.get("TCS").getId(),"e"));
        database.get("TCS").getPersonalDetailsDatabase().put(database.get("TCS").getId(),new PersonalDetails("kumaresan","r",8246589689l,"MANAGER",database.get("TCS"),"kumaresan@gmail.com","DELTA"));

        database.get("TCS").getTeamDatabase().get("DELTA").getTeamMemberList().add(database.get("TCS").getId());
        database.get("TCS").getMailDatabase().put("senthil@gmail.com",database.get("TCS").getId());
        database.get("TCS").getAuthenticationDatabase().put("TCS6",new AuthenticationDetails(database.get("TCS").getId(),"f"));
        database.get("TCS").getPersonalDetailsDatabase().put(database.get("TCS").getId(),new PersonalDetails("senthil","kumar",8526512639l,"MTS",database.get("TCS"),"senthil@gmail.com","DELTA"));

        database.get("TCS").getTeamDatabase().get("DELTA").getTeamMemberList().add(database.get("TCS").getId());
        database.get("TCS").getMailDatabase().put("jebin@gmail.com",database.get("TCS").getId());
        database.get("TCS").getAuthenticationDatabase().put("TCS7",new AuthenticationDetails(database.get("TCS").getId(),"g"));
        database.get("TCS").getPersonalDetailsDatabase().put(database.get("TCS").getId(),new PersonalDetails("jebin","s",7626585623l,"MTS",database.get("TCS"),"jebin@gmail.com","DELTA"));

        database.get("TCS").getTeamDatabase().get("DELTA").getTeamMemberList().add(database.get("TCS").getId());
        database.get("TCS").getMailDatabase().put("benin@gmail.com",database.get("TCS").getId());
        database.get("TCS").getAuthenticationDatabase().put("TCS8",new AuthenticationDetails(database.get("TCS").getId(),"h"));
        database.get("TCS").getPersonalDetailsDatabase().put(database.get("TCS").getId(),new PersonalDetails("benin","s",8956584123l,"PT",database.get("TCS"),"benin@gmail.com","DELTA"));

        database.get("TCS").getTeamDatabase().get("DELTA").getTeamMemberList().add(database.get("TCS").getId());
        database.get("TCS").getMailDatabase().put("deva@gmail.com",database.get("TCS").getId());
        database.get("TCS").getAuthenticationDatabase().put("TCS9",new AuthenticationDetails(database.get("TCS").getId(),"i"));
        database.get("TCS").getPersonalDetailsDatabase().put(database.get("TCS").getId(),new PersonalDetails("deva","b",9623825623l,"PT",database.get("TCS"),"deva@gmail.com","DELTA"));

    }//organization 2 (tcs)
    {
        database.get("TCS").getPersonalDetailsDatabase().get(1l).getDirectReport().add(2l);
        database.get("TCS").getPersonalDetailsDatabase().get(2l).setReportingTo(1l);

        database.get("TCS").getPersonalDetailsDatabase().get(2l).getDirectReport().add(3l);
        database.get("TCS").getPersonalDetailsDatabase().get(3l).setReportingTo(2l);

        database.get("TCS").getPersonalDetailsDatabase().get(5l).getDirectReport().add(6l);
        database.get("TCS").getPersonalDetailsDatabase().get(6l).setReportingTo(5l);

        database.get("TCS").getPersonalDetailsDatabase().get(5l).getDirectReport().add(7l);
        database.get("TCS").getPersonalDetailsDatabase().get(7l).setReportingTo(5l);

        database.get("TCS").getPersonalDetailsDatabase().get(7l).getDirectReport().add(8l);
        database.get("TCS").getPersonalDetailsDatabase().get(8l).setReportingTo(7l);

        database.get("TCS").getPersonalDetailsDatabase().get(7l).getDirectReport().add(9l);
        database.get("TCS").getPersonalDetailsDatabase().get(9l).setReportingTo(7l);
    }// mentor assign (tcs)

    public HashMap<String, OrganizationDetails> getDatabase() {
        return database;
    }
}
