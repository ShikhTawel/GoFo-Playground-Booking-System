package src.Users;

import src.Utilities.Playground;
import src.Utilities.TimeSlot;
import src.Utilities.Address;

import java.util.ArrayList;

/**
 * A {@code Player} class is an extension of the {@code User} class, adding properties and methods of the player
 */
public class Player extends User {
    /**
     * the team that the player owns, if any
     */
    private Team teamOwned;
    /**
     * a list of teams the player is enrolled in
     */
    private ArrayList<Team> teamsEnrolled;

    /**
     * A constructor for the {@code Player} object
     * @param fn first name of the player
     * @param ln last name of the player
     * @param em email of the player
     * @param pass password of the player
     * @param un username of the player
     * @param mn mobile number of the plyer
     * @param ad address of the player
     */
    public Player(String fn, String ln, String em, String pass, String un, String mn, Address ad) {
        super(fn, ln, em, pass, un, mn, ad);
        teamsEnrolled = new ArrayList<>();
        teamOwned = null;
    }

    /**
     * Books a playground for the player at a specific time slot
     * @param playground the playground to be booked
     * @param timeSlot the time slot to book the playground at
     * @return whether successful of not
     */
    public boolean bookPlayground(Playground playground, TimeSlot timeSlot) {
        if (playground.isActivated() && playground.bookPlayground(timeSlot, this) ) {
            return true;
        }
        return false;
    }

    /**
     * Creates a new team owned by the player
     * @param name the name of the team
     * @param players a list of players to be in the team
     */
    public void createTeam(String name, ArrayList<Player> players) {
        teamOwned = new Team(name, username);
        for (Player player : players) {
            teamOwned.addPlayer(player);
            sendInvitations(player.getEmail());
        }
    }

    /**
     * Modifies the team that the player owns
     * @param newName the new name of the team
     * @param players the new list of players in the team
     */
    public void modifyTeam(String newName, ArrayList<Player> players) {
        if (teamOwned == null) return;
        teamOwned.setTeamName(newName);
        teamOwned.getPlayers().clear();
        for (Player player : players) {
            teamOwned.addPlayer(player);
            sendInvitations(player.getEmail());
        }
    }

    /**
     * Removes the player from the team specified
     * @param name the name of the team
     * @return whether successful or not
     */
    public boolean leaveTeam(String name) {
        for (int i = 0; i < teamsEnrolled.size(); i++) {
            if (teamsEnrolled.get(i).getTeamName().equalsIgnoreCase(name)) {
                teamsEnrolled.get(i).deletePlayer(this);
                return true;
            }
        }
        if (teamOwned.getTeamName().equalsIgnoreCase(name)) {
            teamOwned.clearTeam();
            teamOwned = null;
            return true;
        }
        return false;
    }

    /**
     * Reports a playground
     * @param playground the playground to be reported
     */
    public void reportPlayground(Playground playground) {
        if (playground.isActivated()) {
            playground.reportPlayground();
        }
    }

    /**
     * Gets the team owned by the player
     * @return the team owned by the player
     */
    public Team getTeamOwned() {
        return teamOwned;
    }

    /**
     * Gets the teams the player is enrolled in
     * @return the list of teams the player is enrolled in
     */
    public ArrayList<Team> getTeamsEnrolled() {
        return teamsEnrolled;
    }

    /**
     * Sends email invitation to a specific email
     * @param email the email to send the invitation to
     */
    public void sendInvitations(String email) {
        System.out.println("Invitation sent to " + email);
    }
}
