public class AuthenticationDetails {
    private  Long employee_id;
    private String password;


    AuthenticationDetails(Long employee_id, String password){
        this.employee_id=employee_id;
        this.password=password;
    }


    public Long getEmployeeId(){
        return employee_id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
}
