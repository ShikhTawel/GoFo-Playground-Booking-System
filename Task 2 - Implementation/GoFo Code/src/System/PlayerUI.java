package src.System;

import src.Playground.Playground;
import src.Playground.TimeSlot;
import src.Users.Player;
import src.Users.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerUI implements MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Playground> playgrounds;
    private ArrayList<Player> players;
    private int currentPlayer;

    public PlayerUI(ArrayList<Playground> playgrounds, ArrayList<Player> players, int currentPlayer) {
        this.playgrounds = playgrounds;
        this.players = players;
        this.currentPlayer = currentPlayer;
    }

    public void mainMenu() {

    }

    private void viewAvailablePlaygrounds() {
        for (Playground playground : playgrounds) {
            playground.toString();
        }
    }

    private TimeSlot setTimeslot() {
        System.out.println("Enter timeslot details: ");
        System.out.print("\tEnter day: ");
        int day = scanner.nextInt();
        System.out.print("\tEnter month: ");
        int month = scanner.nextInt();
        System.out.print("\tEnter year: ");
        int year = scanner.nextInt();
        System.out.print("\tEnter startingHour: ");
        int startingHour = scanner.nextInt();
        System.out.print("\tEnter endingHour: ");
        int endingHour = scanner.nextInt();

        return new TimeSlot(day, month, year, startingHour, endingHour);
    }

    private void filterPlaygrounds() {

        TimeSlot timeSlot = setTimeslot();

        for (Playground playground : playgrounds) {
            if (playground.getAvailability().indexOf(timeSlot) != -1) {
                playground.toString();
            }
        }
    }

    private boolean bookPlayground() {
        boolean booked = false;
        System.out.println("Enter timeslot details to be reserved: ");
        TimeSlot timeSlot = setTimeslot();
        System.out.print("Enter playground booking number: ");
        int bookingNumber = scanner.nextInt();
        int playgroundIndex;
        for (Playground playground : playgrounds) {
            if (playground.getBookingNumber() == bookingNumber) {
                playgroundIndex = playground.getAvailability().indexOf(timeSlot);
                if (playgroundIndex != -1) {
                    playground.getAvailability().remove(playgroundIndex);
                    players.get(currentPlayer).bookPlayground(playground, timeSlot);
                    booked = true;
                }
            }
        }
        return booked;
    }

    private void createTeam() {
        System.out.print("Enter team name: ");
        String name = scanner.nextLine();
        Team team = new Team(name, players.get(currentPlayer).getUsername());
        players.get(currentPlayer).setTeamOwned(team);

        String playerName;
        boolean added = false;
        while (true) {
            System.out.println("Enter player username to be added: ");
            playerName = scanner.nextLine();
            for (Player player : players) {
                if (player.getUsername().equalsIgnoreCase(playerName)) {
                    team.addPlayer(player);
                    sendInvitations(player.getEmail());
                    added = true;
                    break;
                }
            }
            if (!added) {
                System.out.println("***Player not found***");
            } else {
                System.out.println("Player added successfully");
            }
            System.out.println("Enter 'Y' to add another player or any key to exit");
            String option = scanner.nextLine();
            if (!option.equals("Y")) {
                break;
            }
        }
    }

    private void modifyTeam() {
        if (players.get(currentPlayer).getTeamOwned()==null) {
            System.out.println("***There is no team to modify, consider creating a team firstly***");
            return;
        }
        System.out.print("Enter team name: ");
        String name = scanner.nextLine();
        players.get(currentPlayer).getTeamOwned().setTeamName(name);

        String playerName;
        boolean added = false;
        players.get(currentPlayer).getTeamOwned().clearTeam();
        while (true) {
            System.out.println("Enter player username to be added: ");
            playerName = scanner.nextLine();
            for (Player player : players) {
                if (player.getUsername().equalsIgnoreCase(playerName)) {
                    players.get(currentPlayer).getTeamOwned().addPlayer(player);
                    sendInvitations(player.getEmail());
                    added = true;
                    break;
                }
            }
            if (!added) {
                System.out.println("***Player not found***");
            } else {
                System.out.println("Player added successfully");
            }
            System.out.println("Enter 'Y' to add another player or any key to exit");
            String option = scanner.nextLine();
            if (!option.equals("Y")) {
                break;
            }
        }
    }

    private boolean leaveTeam() {
        System.out.println("Enter team name: ");
        String teamName = scanner.nextLine();
        return players.get(currentPlayer).leaveTeam(teamName);
    }

    private void sendInvitations(String email) {
        System.out.println("Invitation sent to " + email);
    }

    private void reportPlayground() {
        String playgroundName;
        System.out.println("Enter Playground name: ");
        playgroundName = scanner.nextLine();
        for (Playground playground : playgrounds) {
            if (playground.getPlaygroundName().equalsIgnoreCase(playgroundName)) {
                playground.reportPlayground();
                break;
            }
        }
    }
}

