public class Main {
    public static void main(String[] args){
        Model model=Model.getInstance();
        Authentication authentication=new Authentication();
        authentication.verify(model.getDatabase());
    }
}
