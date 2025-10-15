package shop.leejinhyung.api.auth.domain;

public class LoginDTO {
   
    private String userId;
    private String password;
    
    // Getter and Setter for userId
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    // Getter and Setter for password
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
