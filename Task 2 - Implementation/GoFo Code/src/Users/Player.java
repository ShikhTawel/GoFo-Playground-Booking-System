package src.Users;

import src.Playground.Playground;
import src.Playground.TimeSlot;
import src.System.Address;

import java.util.ArrayList;

public class Player extends User {

    ArrayList<Playground> bookedPlaygrounds;
    ArrayList<TimeSlot> bookedTimeSlots;
    Team teamOwned;
    ArrayList<Team> teamsEnrolled;

    public Player(String fn, String ln, String em, String pass, String un, String mn, Address ad) {
        super(fn, ln, em, pass, un, mn, ad);
        bookedPlaygrounds = new ArrayList<>();
        bookedTimeSlots = new ArrayList<>();
        teamsEnrolled = new ArrayList<>();
    }

    public ArrayList<Playground> filterPlaygrounds(ArrayList<Playground> playgrounds, TimeSlot ts) {
        ArrayList<Playground> res = new ArrayList<Playground>();
        for (int i = 0; i < playgrounds.size(); i++) {
            for (int j = 0; j < playgrounds.get(i).getAvailability().size(); j++) {
                TimeSlot t = playgrounds.get(i).getAvailability().get(j);
                if (t.equals(ts) && !t.isBooked()) {
                    res.add(playgrounds.get(i));
                    break;
                }
            }
        }
        return res;
    }

    public boolean bookPlayground(Playground playground, TimeSlot timeSlot) {
        if (playground.bookPlayground(timeSlot, this.username)) {
            bookedPlaygrounds.add(playground);
            bookedTimeSlots.add(timeSlot);
            return true;
        }
        return false;
    }

    public void createTeam(String name, ArrayList<Player> players) {
        teamOwned = new Team(name, username);
        for (Player player: players) {
            teamOwned.addPlayer(player);
        }
    }

    public void modifyTeam(String newName, ArrayList<Player> players) {
        if (teamOwned == null) return;
        teamOwned.setTeamName(newName);
        teamOwned.getPlayers().clear();
        for (Player player: players) {
            teamOwned.addPlayer(player);
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
        playground.reportPlayground();
    }

    public ArrayList<Playground> getBookedPlaygrounds() {
        return bookedPlaygrounds;
    }

    public void setBookedPlaygrounds(ArrayList<Playground> bookedPlaygrounds) {
        this.bookedPlaygrounds = bookedPlaygrounds;
    }

    public ArrayList<TimeSlot> getBookedTimeSlots() {
        return bookedTimeSlots;
    }

    public void setBookedTimeSlots(ArrayList<TimeSlot> bookedTimeSlots) {
        this.bookedTimeSlots = bookedTimeSlots;
    }

    public Team getTeamOwned() {
        return teamOwned;
    }

    public void setTeamOwned(Team teamOwned) {
        this.teamOwned = teamOwned;
    }

    public ArrayList<Team> getTeamsEnrolled() {
        return teamsEnrolled;
    }

    public void setTeamsEnrolled(ArrayList<Team> teamsEnrolled) {
        this.teamsEnrolled = teamsEnrolled;
    }
}
