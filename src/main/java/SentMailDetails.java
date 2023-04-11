import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SentMailDetails {
    private ArrayList<Long> sent_to;
    private String mail_received_time= LocalDateTime.now().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    private String mail_received_date=LocalDateTime.now().toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    private String subject;
    private String content;


    SentMailDetails(ArrayList<Long> sent_to,String subject,String content){
        this.sent_to=sent_to;
        this.subject=subject;
        this.content=content;
    }


    public ArrayList<Long> getSentTo(){return sent_to;}
    public String getMailReceivedTime(){return mail_received_time;}
    public String getMailReceivedDate(){return mail_received_date;}
    public String getSubject(){return subject;}
    public String getContent(){return content;}
}
