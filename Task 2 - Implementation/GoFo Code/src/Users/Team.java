package src.Users;
import java.util.ArrayList;

/**
 * A {@code Team} class is used to group players together into a team with an owner and team members
 */
public class Team {
    /**
     * the name of the team
     */
    private String teamName;
    /**
     * the username of the {@code Player} owner
     */
    private String ownerUsername;
    /**
     * the team member players of the team
     */
    private ArrayList<Player> players;
    private static int cnt = 0;

    /**
     * A constructor for the {@code Team} object
     * @param name name of the team
     * @param username username of the owner of the team
     */
    public Team(String name, String username) {
        teamName = name;
        ownerUsername = username;
        players=new ArrayList<>();
    }

    /**
     * Adds a player to the team
     * @param player the player to be added to the team
     */
    public void addPlayer(Player player) {
        players.add(player);
        player.getTeamsEnrolled().add(this);
    }

    /**
     * Deletes a player from the team
     * @param player the player to be deleted from the team
     */
    public void deletePlayer(Player player) {
        players.remove(player);
        player.getTeamsEnrolled().remove(this);
    }

    /**
     * Clears the team, making it empty with no players
     */
    public void clearTeam() {
        for (int i = 0; i < players.size(); i++) {
            deletePlayer(players.get(0));
        }
    }

    @Override
    public String toString() {
        String res =
                "Team name: " + teamName
                + "\nUsername of the Owner Player: " + ownerUsername
                + "\nOther Players: \n";
        for (Player player: players) {
            res += "- ";
            res += player.getUsername() + "\n";
        }
        return res;
    }

    /**
     * Sends invitation emails to the team members
     */
    public void sendInvitations() {
        for (Player player: players) {
            if (!player.getUsername().equalsIgnoreCase(ownerUsername)) {
                System.out.println("Invitation sent to: " + player.getEmail());
            }
        }
    }

    /**
     * Gets the name of the team
     * @return the name of the team
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets the name of the team
     * @param teamName the new team name
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Gets the username of the owner of the team
     * @return the username of the owner
     */
    public String getOwnerUsername() {
        return ownerUsername;
    }

    /**
     * Gets a list of players that are in the team
     * @return the list of players in the team
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }
}