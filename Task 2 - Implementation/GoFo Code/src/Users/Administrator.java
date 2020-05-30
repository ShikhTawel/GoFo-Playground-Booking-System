package src.Users;
import src.Playground.Playground;

public class Administrator {
    private String username;
    private String password;

    public Administrator() {
        username = "admin";
        password = "admin";
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

    public Administrator(String username, String password) {
        username = username;
        password = password;
    }

    public void approvePlayground(Playground playground) {
        playground.setApproved(true);
    }

    public void activatePlayground(Playground playground) {
        playground.setActivated(true);
    }

    public void suspendPlayground(Playground playground) {
        playground.setActivated(false);
    }

}
