package src.Users;

import src.Playground.Playground;
import src.Playground.TimeSlot;
import src.System.Address;

import java.util.ArrayList;

public class Player extends User {

    private ArrayList<Playground> bookedPlaygrounds;
    private ArrayList<TimeSlot> bookedTimeSlots;
    private Team teamOwned;
    private ArrayList<Team> teamsEnrolled;

    public Player(String fn, String ln, String em, String pass, String un, String mn, Address ad) {
        super(fn, ln, em, pass, un, mn, ad);
        bookedPlaygrounds = new ArrayList<>();
        bookedTimeSlots = new ArrayList<>();
        teamsEnrolled = new ArrayList<>();
    }

    public boolean bookPlayground(Playground playground, TimeSlot timeSlot) {
        if (playground.isActivated() && playground.bookPlayground(timeSlot, this.username) ) {
            bookedPlaygrounds.add(playground);
            bookedTimeSlots.add(timeSlot);
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
        return false;
    }

    public void reportPlayground(Playground playground) {
        if (playground.isActivated()) {
            playground.reportPlayground();
        }
    }

    public ArrayList<Playground> getBookedPlaygrounds() {
        return bookedPlaygrounds;
    }

    public ArrayList<TimeSlot> getBookedTimeSlots() {
        return bookedTimeSlots;
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
