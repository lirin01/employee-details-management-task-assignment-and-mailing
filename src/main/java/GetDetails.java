import java.util.*;

public class GetDetails {
    private Scanner scanString = new Scanner(System.in);
    private Validator validator = new Validator();
    private boolean switcher;
    private String text;

    public int choice(String content) {
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        int choice = validator.choice(content);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        return choice;
    }
    public int confirmation() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("enter 1 to confirm");
        System.out.println("enter 2 to cancel");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        int choice = validator.choice("choice");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        return choice;
    }
    public String userName() {
        System.out.print("user name : ");
        return scanString.nextLine().toUpperCase().strip();
    }
    public String organizationName(String content){
        System.out.print(content+" : ");
        return scanString.nextLine().toUpperCase().strip();
    }
    public String password(String content) {
        System.out.print(content+" : ");
        return scanString.nextLine().strip();
    }
    public long id(String content) {
        return validator.id(content);
    }
    public String name(String content) {
        return validator.word(content);
    }
    public long contactNumber() {
        return validator.ContactNumber();
    }

    public String role(String[] options, String team_name) {
        switcher=true;

            if (team_name.equals("ADMINISTRATION")) // for admin
            {
                while(switcher) {
                    for (int i = 0; i < options.length; i++) {
                        System.out.println("  " + (i + 1) + " " + options[i]);
                    }
                    int choice=validator.choice("role");
                    if(choice<=3){
                        text=options[choice-1];
                        switcher=false;
                    }
                    else{
                        System.out.println();
                        System.out.println("invalid command");
                        System.out.println();
                    }
                }
            }
            else // for other team managers
            {
                    while(switcher){
                    for (int i = 0; i < options.length; i++) {
                        System.out.println(" " + (i + 1) + " " + options[i]);
                    }
                    int choice=validator.choice("role");
                    if(choice<=2){
                        text=options[choice-1];
                        switcher=false;
                    }
                    else{
                        System.out.println();
                        System.out.println("invalid command");
                        System.out.println();
                    }
            }
            }
            return text;
        }
    public String teamName(Set<String> team_names, String user_team_name) {
        int choice;
        switcher=true;
        if (user_team_name.equals("ADMINISTRATION")) // for admin
        {
            while(switcher){
                int count = 0;
                team_names.remove("ADMINISTRATION");
                for (String i : team_names) {
                        System.out.println(" " + (++count) + " " + i);
                }
                choice= validator.choice("team");
                if((count)>=choice){
                    text = (String) team_names.toArray()[choice-1];
                    switcher=false;
                }
                else{
                    System.out.println();
                    System.out.println("invalid command");
                    System.out.println();
                }
            }

        }
        else // for other team managers
        {
            text = user_team_name;
        }
        return text;
    }
    public String mailAddress(Set<String> mail_address){
        return validator.emailAddress(mail_address);
    }
    public String statement(String content){
        System.out.print(content+" : ");
        return scanString.nextLine();
    }
    public String changePassword(){
        return validator.password();
    }
}

