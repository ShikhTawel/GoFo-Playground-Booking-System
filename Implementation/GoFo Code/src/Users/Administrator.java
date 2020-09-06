package src.Users;

import src.Utilities.Playground;

/**
 * An {@code Administrator} class is used to allow administrators to access playgrounds and activate or delete any of them
 */
public class Administrator {
    /**
     * the username of the admin
     */
    private String username;
    /**
     * the password of the admin
     */
    private String password;

    /**
     * A constructor for the {@code Administrator} object
     * @param username the username of the admin
     * @param password the password of the admin
     */
    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username of the admin
     * @return the username of the admin
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of the admin
     * @return the password of the admin
     */
    public String getPassword() {
        return password;
    }

    /**
     * Activates a specific playground
     * @param playground the playground to be activated
     */
    public void activatePlayground(Playground playground) {
        playground.setActivated(true);
    }
}
