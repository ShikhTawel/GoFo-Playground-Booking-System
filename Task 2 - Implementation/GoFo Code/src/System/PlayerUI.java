package src.System;

import src.Playground.Playground;
import src.Playground.TimeSlot;
import src.Users.Player;
import src.Users.Team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
            boolean printed = false;
            for (int i = 0; i < playground.getAvailability().size(); ++i) {
                if (!playground.getAvailability().get(i).isBooked() && playground.isActivated()) {
                    if (!printed) {
                        System.out.println(playground.getPlaygroundName());
                        System.out.println(playground.getAddress().toString());
                        printed = true;
                    }
                    System.out.println(playground.getAvailability().get(i).toString());
                }
            }
            printed = false;
        }
    }

    private TimeSlot setTimeslot() {
        int day, month, year, startingHour, endingHour;
        System.out.println("Enter timeslot details: ");
        while (true) {
            System.out.print("\tEnter day: ");
            day = scanner.nextInt();
            if (day >= 1 && day <= 31) {
                break;
            } else {
                System.out.println("***Enter valid day***");
            }
        }
        while (true) {
            System.out.print("\tEnter month: ");
            month = scanner.nextInt();
            if (month >= 1 && month <= 12) {
                break;
            } else {
                System.out.println("***Enter valid month***");
            }
        }
        while (true) {
            System.out.print("\tEnter year: ");
            LocalDate date = LocalDate.now();
            year = scanner.nextInt();
            if (year < date.getYear()) {
                System.out.println("***Enter valid year***");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("\tEnter startingHour: ");
            startingHour = scanner.nextInt();
            if (startingHour < 0 || startingHour > 23) {
                System.out.println("***Enter valid hour***");
            }
            else {
                break;
            }
        }
        while (true) {
            System.out.print("\tEnter endingHour: ");
            endingHour = scanner.nextInt();
            if (endingHour < 0 || endingHour > 23) {
                System.out.println("***Enter valid hour***");
            } else {
                break;
            }
        }

        return new TimeSlot(day, month, year, startingHour, endingHour);
    }

    private void filterPlaygrounds() {

        TimeSlot timeSlot = setTimeslot();

        for (Playground playground : playgrounds) {
            int timesoltIndex = playground.getAvailability().indexOf(timeSlot);
            if (timesoltIndex!=-1 && !playground.getAvailability().get(timesoltIndex).isBooked() && playground.isActivated()) {
                System.out.println(playground.toString());
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
                if (playgroundIndex != -1 && !playground.getAvailability().get(playgroundIndex).isBooked() && playground.isActivated()) {
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

        String playerName;
        boolean added = false;
        var teamPlayers = new ArrayList<Player>();
        while (true) {
            System.out.println("Enter player username to be added: ");
            playerName = scanner.nextLine();
            for (Player player : players) {
                if (player.getUsername().equalsIgnoreCase(playerName)) {

                    teamPlayers.add(player);
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
        players.get(currentPlayer).createTeam(name,teamPlayers);
    }

    private void modifyTeam() {
        if (players.get(currentPlayer).getTeamOwned() == null) {
            System.out.println("***There is no team to modify, consider creating a team firstly***");
            return;
        }
        System.out.print("Enter team name: ");
        String name = scanner.nextLine();
        Team team = new Team(name, players.get(currentPlayer).getUsername());

        String playerName;
        boolean added = false;
        var teamPlayers = new ArrayList<Player>();
        while (true) {
            System.out.println("Enter player username to be added: ");
            playerName = scanner.nextLine();
            for (Player player : players) {
                if (player.getUsername().equalsIgnoreCase(playerName)) {

                    teamPlayers.add(player);
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
        players.get(currentPlayer).modifyTeam(name,teamPlayers);
    }

    private boolean leaveTeam() {
        System.out.println("Enter team name: ");
        String teamName = scanner.nextLine();
        return players.get(currentPlayer).leaveTeam(teamName);
    }

    private void reportPlayground() {
        System.out.println("Enter Playground name: ");
        String playgroundName = scanner.nextLine();
        for (Playground playground : playgrounds) {
            if (playground.getPlaygroundName().equalsIgnoreCase(playgroundName) && playground.isActivated()) {
                players.get(currentPlayer).reportPlayground(playground);
                break;
            }
        }
    }
}

