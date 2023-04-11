import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceivedMailDetails {
    private String mail_received_time= LocalDateTime.now().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    private String mail_received_date=LocalDateTime.now().toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    private Long received_from;
    private String subject;
    private String content;
    ReceivedMailDetails(Long received_from,String subject,String content){
        this.received_from=received_from;
        this.subject=subject;
        this.content=content;
    }
    public String getMailReceivedTime(){return mail_received_time;}
    public String getMailReceivedDate(){return mail_received_date;}
    public Long getReceivedFrom(){return received_from;}
    public String getSubject(){return subject;}
    public String getContent(){return content;}
}
