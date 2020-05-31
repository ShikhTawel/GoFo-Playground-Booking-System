package src.Users;

import src.Utilities.Playground;
import src.Utilities.TimeSlot;
import src.Utilities.Address;

import java.util.ArrayList;

public class Player extends User {
    private Team teamOwned;
    private ArrayList<Team> teamsEnrolled;

    public Player(String fn, String ln, String em, String pass, String un, String mn, Address ad) {
        super(fn, ln, em, pass, un, mn, ad);
        teamsEnrolled = new ArrayList<>();
        teamOwned = null;
    }

    public boolean bookPlayground(Playground playground, TimeSlot timeSlot) {
        if (playground.isActivated() && playground.bookPlayground(timeSlot, this) ) {
            return true;
        }
        return false;
    }

    public void createTeam(String name, ArrayList<Player> players) {
        teamOwned = new Team(name, username);
        for (Player player : players) {
            teamOwned.addPlayer(player);
            sendInvitations(player.getEmail());
        }
    }

    public void modifyTeam(String newName, ArrayList<Player> players) {
        if (teamOwned == null) return;
        teamOwned.setTeamName(newName);
        teamOwned.getPlayers().clear();
        for (Player player : players) {
            teamOwned.addPlayer(player);
            sendInvitations(player.getEmail());
        }
    }

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

    public void reportPlayground(Playground playground) {
        if (playground.isActivated()) {
            playground.reportPlayground();
        }
    }

    public Team getTeamOwned() {
        return teamOwned;
    }

    public ArrayList<Team> getTeamsEnrolled() {
        return teamsEnrolled;
    }

    private void sendInvitations(String email) {
        System.out.println("Invitation sent to " + email);
    }
}
