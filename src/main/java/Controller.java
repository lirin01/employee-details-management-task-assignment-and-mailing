import java.util.ArrayList;
import java.util.HashMap;

public class Controller implements SuperAdmin,PT,MTS,Manager,Admin {
    private GetDetails getDetails=new GetDetails();
    private Organization organization=new Organization();
    private Team team=new Team();
    private Employee employee=new Employee();
    private Profile profile=new Profile();
    private View view = new View();
    private Task task = new Task();
    private Mentor mentor=new Mentor();
    private Mail mail=new Mail();

    public void profile(HashMap<Long, PersonalDetails> personal_details_database, AuthenticationDetails user_authentication_details, Long user_id, HashMap<String,Long> mail_database){
        int choice=Integer.MIN_VALUE;
        while(choice!=0){
            System.out.println("""
                    1 view profile
                    2 view others profile
                    3 edit
                    0 back""");
            choice= getDetails.choice("choice");
            switch (choice){
                case 1-> profile.view(personal_details_database,user_id);
                case 2-> profile.viewOthers(personal_details_database);
                case 3-> {
                    PersonalDetails individual_details = personal_details_database.get(user_id);
                    profile.edit(individual_details, user_authentication_details,mail_database);
                }
                case 0->{}
                default -> {
                    view.line();
                    System.out.println("invalid command");
                    view.line();
                }
            }
        }
    }
    public void mail(HashMap<String, Long> mail_database, HashMap<Long, PersonalDetails> personal_details_database, Long user_id){
        int mail_choice = Integer.MIN_VALUE;
        while (mail_choice != 0) {
            System.out.println("unread mail : "+personal_details_database.get(user_id).getReceivedMail().size()+"           inbox : "+personal_details_database.get(user_id).getInbox().size()+"           mail sent : "+personal_details_database.get(user_id).getMailSent().size());
            System.out.println("""
                    _____________________________________________________________
                    1 sent mail
                    2 view unread
                    3 view inbox
                    4 view sent
                    0 back""");
            mail_choice = getDetails.choice("choice");
            switch (mail_choice) {
                case 1 -> mail.sent(mail_database,personal_details_database,user_id);
                case 2 -> mail.viewUnread(personal_details_database, user_id);
                case 3 -> mail.viewInbox(personal_details_database, user_id);
                case 4 -> mail.viewSent(personal_details_database, user_id);
                case 0->{}
                default -> {
                    System.out.println("invalid command");
                    view.line();
                }
            }
        }

    }
    public void viewYourTeam(HashMap<Long, PersonalDetails> personal_details_database, ArrayList<Long> team_member_list){
        team.view(personal_details_database,team_member_list);
    }
    public void mentor(HashMap<Long, PersonalDetails> personal_details_database , Long user_id , HashMap<String,TeamMemberList> team_database){
        PersonalDetails user_details=personal_details_database.get(user_id);
        boolean switcher=true;
        while(switcher){
            long client_id = getDetails.id("employee id");
            view.line();
            if(personal_details_database.get(client_id)!=null){
                switcher=false;
                if(user_details.getEmployeeId()==client_id){
                    view.line();
                    System.out.println("you cannot assign to your self");
                    view.line();
                }
                else if (user_details.getRole().equals(personal_details_database.get(client_id).getRole()))
                {
                    view.line();
                    System.out.println("you cannot assign to a employee with same role");
                    view.line();
                } else if(personal_details_database.get(client_id).getTeamName().equals(user_details.getTeamName())){
                    int choice=Integer.MIN_VALUE;
                    while(choice!=0){
                        System.out.println("""
                        1 assign mentor
                        2 remove mentor
                        3 change mentor
                        0 go back""");
                        choice=getDetails.choice("choice");
                        switch(choice){
                            case 1-> mentor.assign(personal_details_database,user_id,team_database,client_id);
                            case 2-> mentor.remove(personal_details_database,client_id);
                            case 3-> mentor.change(personal_details_database,user_id,team_database,client_id);
                            case 0->{}
                            default -> {
                                view.line();
                                System.out.println("invalid command");
                                view.line();
                            }
                        }
                    }
                }
                else{
                    view.line();//dc
                    System.out.println("you cannot assign mentor to the employee, not in your team");
                    view.line();
                }
            }
            else{
                view.line();
                System.out.println("No data found in this id\ntry again");
                view.line();
            }
        }
    }
    public void addNewEmployee(OrganizationDetails organization_database,PersonalDetails user_details) {employee.add(organization_database,user_details);}
    public void addNewOrganization(HashMap<String, OrganizationDetails> database) {organization.add(database);}
    public void viewAll(HashMap<Long, PersonalDetails> organization_database) {view.tableView(organization_database);}
    public void viewTaskAssigned(PersonalDetails user_details) {task.viewTaskAssigned(user_details);}
    public void addNewTask(HashMap<Long, PersonalDetails> personal_details_database, PersonalDetails user_details) {task.add(personal_details_database, user_details);}
    public void viewYourTask(PersonalDetails user_details) {task.viewYourTask(user_details);}
    public void changeOrganizationAccess(HashMap<String, OrganizationDetails> database, String user_organization_name) {organization.changeAccess(database,user_organization_name);}
    public void changeEmployeeAccess(HashMap<Long, PersonalDetails> organization_database, Long user_id) {employee.changeAccess(organization_database, user_id);}
    public void removeEmployee(OrganizationDetails organization_database, String username) {employee.remove(organization_database, username);}
    public void changeTaskStatus(HashMap<Long, PersonalDetails> personal_details_database, PersonalDetails user_details) {task.changeTaskStatus(personal_details_database, user_details);}
    public void addNewTeam(OrganizationDetails team_details) {team.add(team_details);}
    public void changeEmployeeRole(HashMap<Long, PersonalDetails> personal_details_database,ArrayList<Long> team_member_list,Long user_id){employee.changeRole(personal_details_database,user_id);}
}

