import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    private Scanner scanString=new Scanner(System.in);
    private String text;
    boolean switcher;
    public int choice(String content) {
        switcher=true;
        int sent;
        while (switcher) {
            System.out.print(content+" : ");
            text = scanString.nextLine().strip();
            if ((Pattern.matches("[0-9]", text))) {
                switcher = false;
            }
            else if((Pattern.matches("\\d+", text))){
                System.out.println();
                System.out.println("length of the integer should need 0-9");
                System.out.println("try again");
                System.out.println();
            }
            else {
                System.out.println("you have entered wrong input format");
            }
        }
        sent=Integer.parseInt(text);
        return sent;
    }
    public long id(String content){
        switcher=true;
        long sent;
        while (switcher) {
            System.out.print(content+" : ");
            text = scanString.nextLine().strip();
            if ((Pattern.matches("\\d+", text))) {
                switcher = false;
            }
            else {
                System.out.println("you have entered wrong input format");
            }
        }
        sent=Long.parseLong(text);
        return sent;
    }
    public Long checkEmailIdExist(HashMap<String,Long> mail_database,String content){
        int choice=Integer.MIN_VALUE;
        Long temp=0l;
        while(choice!=1){
            System.out.print(content+" : ");
            String mail_id=scanString.nextLine().strip();
            if(mail_database.get(mail_id)==null){
                System.out.println("mail id not found\ntry again !!");
                System.out.println();
            }
            else{
                temp=mail_database.get(mail_id);
                choice=1;
            }
        }
        return temp;
    }
    public long ContactNumber() {
        switcher=true;
        while (switcher) {
            System.out.print("Contact number : ");
             text= scanString.nextLine().strip();
            if ((Pattern.matches("[0-9]{10}", text))) {
                switcher = false;
            } else {
                System.out.println("contact number should contain only 10 integer");
                System.out.println("try again");
            }
        }
        return Long.parseLong(text);
    }
    public String emailAddress(Set<String> mail_address) {
        switcher=true;
        while (switcher) {
            System.out.print("Email Address : ");
            text= scanString.nextLine().strip();
            if ((Pattern.matches("^(.+)@(.+)$", text))) {
                    if(mail_address.contains(text)){
                        System.out.println("email already found");
                        System.out.println("try again");
                    }
                    else{
                        switcher = false;
                    }
            } else {
                System.out.println();
                System.out.println("Email address is in wrong format");
                System.out.println("""
                        example
                        kamal@gmail.com
                        kamal123@gmail.com
                        try again
                        """);
            }
        }
        return text;
    }

    public String password() {
        switcher=true;
        System.out.println("""
                Password must contain at least one digit 0-9.
                Password must contain at least one lowercase character a-z.
                Password must contain at least one uppercase Latin character A-Z.
                Password must contain at least one special character like ! @ # & ( ).
                Password must contain a length of at least 8 characters and a maximum of 20 characters.
                """);
        while (switcher) {
            System.out.print("password : ");
            text= scanString.nextLine();
            if ((Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$^+=<>]).{8,20}$", text))) {
                    switcher = false;
            } else {
                System.out.println("weak password");
                System.out.println("try again");
            }
        }
        return text;
    }
    public String word(String content){
        switcher=true;
        String text="";
        while (switcher) {
            System.out.print(content+" : ");
            text = scanString.nextLine().strip().toLowerCase();
            if ((Pattern.matches("[a-z]++", text))) {
                switcher = false;
            }
            else {
                System.out.println();
                System.out.println("you have entered wrong input format accepts only Alphabetic\ntry again");
                System.out.println();
            }
        }
        return text;
    }

}
