package Feedback_System.model;

public class User {
    private String username;
    private String password;
    private String role;
    private String phone;

    public User(String username, String password, String phone, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.phone = phone;
    }

    public User(String username, String phone, String password) {
        this.username = username;
        this.phone = phone;
        this.password =  password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
