package cordismain;

/**
 * Class that represents user's details.
 * It is used as a data structure to retrieve user data from database and setup rows in Admin panel table.
 *
 * @author dim6ata
 */
public class User {

    private int userId;
    private String name;
    private String email;
    private String password;
    private String status;
    private boolean adminCheck;
    private int passwordErrors;

    public int getPasswordErrors() {
        return passwordErrors;
    }

    public void setPasswordErrors(int passwordErrors) {
        this.passwordErrors = passwordErrors;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdminCheck() {
        return adminCheck;
    }

    public void setAdminCheck(boolean checkAdmin) {
        this.adminCheck = checkAdmin;
    }

    public void setUserStatus(String status) {

        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "\nUser{" + "userId=" + userId + ", name=" + name + ", email=" + email + ", status=" + status + ", passwordErrors=" + passwordErrors + '}';
    }

}
