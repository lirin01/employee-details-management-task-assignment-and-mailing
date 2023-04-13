import java.util.ArrayList;
import java.util.HashMap;
public class Mail {
    private Validator validator=new Validator();
    private View view=new View();
    private GetDetails getDetails=new GetDetails();
    public void sent(HashMap<String, Long> mail_database, HashMap<Long, PersonalDetails> personal_details_database, Long user_id){
        int choice = Integer.MIN_VALUE;
        ArrayList<Long> list = new ArrayList<>();
        list.add(validator.checkEmailIdExist(mail_database,"TO"));
        while (choice != 2) {
            view.line();
            System.out.println("""
                    1 add more
                    2 done""");
            choice = getDetails.choice("choice");
            switch (choice) {
                case 1 -> list.add(validator.checkEmailIdExist(mail_database,"TO"));
                case 2 -> view.line();
                default -> {
                    view.line();
                    System.out.println("invalid command");
                    view.line();
                }
            }
        }
        String subject = getDetails.statement("subject");
        String content = getDetails.statement("content");
        view.line();
        boolean switcher=true;
        while(switcher){
            System.out.println("""
                1 sent
                2 cancel""");
            choice=getDetails.choice("choice");
            switch (choice) {
                case 1 -> {
                    for (Long i : list) {
                        personal_details_database.get(i).getReceivedMail().push(new ReceivedMailDetails(user_id, subject, content));
                    }
                    personal_details_database.get(user_id).getMailSent().add(new SentMailDetails(list, subject, content));
                    switcher=false;
                }
                case 2 -> {
                    view.line();
                    System.out.println("cancelled successfully");
                    view.line();
                    switcher=false;
                }
                default->
                {
                    view.line();
                    System.out.println("invalid command");
                    view.line();
                }
            }
        }
    }
    public void viewUnread(HashMap<Long, PersonalDetails> personal_details_database, Long user_id){
        if(personal_details_database.get(user_id).getReceivedMail().size()==0) // check any file in the unread box
        {
            view.line();
            System.out.println("you have no unreaded message");
            view.line();
        }
        else{
            view.unreadMail(personal_details_database,user_id);
        }
    }
    public void viewInbox(HashMap<Long, PersonalDetails> personal_details_database, Long user_id){
        if(personal_details_database.get(user_id).getInbox().size()==0) // check mail contain in inbox
        {
            System.out.println("you have no mail in your inbox");
            view.line();
        }
        else{
            view.inboxMail(personal_details_database, user_id);
        }
    }
    public void viewSent(HashMap<Long, PersonalDetails> personal_details_database, Long user_id){
        if(personal_details_database.get(user_id).getMailSent().size()==0) // check the mail you sent is available
        {
            System.out.println("you have not sented any mail yet");
            view.line();
        }
        else{
            view.sentedMail(personal_details_database, user_id);
        }
    }
}
