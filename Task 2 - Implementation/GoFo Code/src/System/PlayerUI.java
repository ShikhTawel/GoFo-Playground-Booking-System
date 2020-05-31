package src.System;

import src.Utilities.Playground;
import src.Utilities.TimeSlot;
import src.Users.Player;
import src.Users.Team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * {@code PlayerUI} class is used to enable players to interact with the system using the console
 */
public class PlayerUI {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Playground> playgrounds;
    private ArrayList<Player> players;
    private int currentPlayer;

    /**
     * A constructor for the {@code PlayerUI} object
     * @param currentPlayer the index of the current player currently logged into the system
     */
    public PlayerUI(ArrayList<Playground> playgrounds, ArrayList<Player> players, int currentPlayer) {
        this.playgrounds = playgrounds;
        this.players = players;
        this.currentPlayer = currentPlayer;
        mainMenu();
    }

    /**
     * A main menu the allows players to choose an operation to be done and redirects them to different parts of the system
     */
    public void mainMenu() {
        String option = "";
        while (true) {
            System.out.println("\n1- Show Available Playgrounds" +
                    "\n2- Filter Playground using time slot" +
                    "\n3- Book a Playground" +
                    "\n4- View Current Bookings" +
                    "\n5- Create Team" +
                    "\n6- Modify Team" +
                    "\n7- Leave Team" +
                    "\n8- View Current Teams" +
                    "\n9- Report a Playground" +
                    "\n10- Access eWallet" +
                    "\n11- Logout");
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("1")) {
                viewAvailablePlaygrounds();
            } else if (option.equalsIgnoreCase("2")) {
                filterPlaygrounds();
            } else if (option.equalsIgnoreCase("3")) {
                bookPlayground();
            } else if (option.equalsIgnoreCase("4")) {
                viewBookings();
            } else if (option.equalsIgnoreCase("5")) {
                createTeam();
            } else if (option.equalsIgnoreCase("6")) {
                modifyTeam();
            } else if (option.equalsIgnoreCase("7")) {
                leaveTeam();
            } else if (option.equalsIgnoreCase("8")) {
                viewTeams();
            } else if (option.equalsIgnoreCase("9")) {
                reportPlayground();
            } else if (option.equalsIgnoreCase("10")) {
                eWalletUI eWalletUI = new eWalletUI(players.get(currentPlayer));
            } else if (option.equalsIgnoreCase("11")) {
                break;
            } else {
                System.out.println("***Enter valid option***\n");
            }
        }
        System.out.println("\nLogging out ...");
    }

    /**
     * Outputs the available playgrounds and their available time slots
     */
    private void viewAvailablePlaygrounds() {
        for (Playground playground : playgrounds) {
            if (!playground.isActivated()) continue;
            boolean printed = false;
            for (int i = 0; i < playground.getAvailability().size(); ++i) {
                if (!playground.getAvailability().get(i).isBooked()) {
                    if (!printed) {
                        System.out.println("==========================================");
                        System.out.println("Playground Name: " + playground.getPlaygroundName());
                        System.out.println("Playground Address: \n" + playground.getAddress().toString());
                        printed = true;
                    }
                    System.out.println(playground.getAvailability().get(i).toString());
                }
            }
        }
    }

    /**
     * Allows a user to enter the data of a time slot
     * @return the time slot the user entered
     */
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
            } else {
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
        scanner.skip("\n");
        return new TimeSlot(day, month, year, startingHour, endingHour);
    }

    /**
     * Allows a player to enter a time slot and view the available playgrounds at this time slot
     */
    private void filterPlaygrounds() {
        TimeSlot timeSlot = setTimeslot();
        for (Playground playground : playgrounds) {
            if (!playground.isActivated()) continue;
            boolean printed = false;
            for (int i = 0; i < playground.getAvailability().size(); ++i) {
                if (!playground.getAvailability().get(i).isBooked()
                        && playground.getAvailability().get(i).equals(timeSlot)) {
                    if (!printed) {
                        System.out.println("=========================================");
                        System.out.println("Playground Name: " + playground.getPlaygroundName());
                        System.out.println("Playground Address: \n" + playground.getAddress().toString());
                        printed = true;
                    }
                    System.out.println(playground.getAvailability().get(i).toString());
                }
            }
        }
    }

    /**
     * Allows a player to book a playground by entering its booking number (ID) and the desired time slot
     */
    private void bookPlayground() {
        System.out.print("Enter playground booking number: ");
        int bookingNumber = scanner.nextInt();
        Playground playground = null;
        for (Playground pg : playgrounds) {
            if (!pg.isActivated()) continue;
            if (pg.getBookingNumber() == bookingNumber) {
                playground = pg;
                break;
            }
        }
        if (playground == null) {
            System.out.println("Playground booking number is invalid!");
            return;
        }
        boolean booked = false;
        System.out.println("Enter time slot details to be booked: ");
        TimeSlot timeSlot = setTimeslot();
        if (players.get(currentPlayer).bookPlayground(playground, timeSlot)) {
            System.out.println("\nPlayground Booked Successfully");
            if (players.get(currentPlayer).getTeamOwned() != null) {
                System.out.println("\nDo you want to send invitations to your owned team ?" +
                        "\n'Y' for yes or any key for no");
                String option;
                option = scanner.nextLine();
                if (option.equalsIgnoreCase("Y")) {
                    players.get(currentPlayer).getTeamOwned().sendInvitations();
                }
            }
        } else {
            System.out.println("\nCould not book playground" +
                    "\nInvalid time slot or insufficient eWallet balance");
        }
    }

    /**
     * Creates a team of the player by entering its name and the players to be added to the team
     */
    private void createTeam() {
        System.out.print("Enter Team name: ");
        String name = scanner.nextLine();
        String playerName;
        boolean added = false;
        var teamPlayers = new ArrayList<Player>();
        while (true) {
            added = false;
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
        players.get(currentPlayer).createTeam(name, teamPlayers);
    }

    /**
     * Modifies the team the player owns by entering the new team name and team members
     */
    private void modifyTeam() {
        if (players.get(currentPlayer).getTeamOwned() == null) {
            System.out.println("***There is no team to modify, consider creating a team firstly***");
            return;
        }
        System.out.print("Enter new Team name: ");
        String name = scanner.nextLine();
        String playerName;
        boolean added = false;
        var teamPlayers = new ArrayList<Player>();
        System.out.println("Enter new list of team players: ");
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
        players.get(currentPlayer).modifyTeam(name, teamPlayers);
    }

    /**
     * Allows a player to leave a team by entering its name
     */
    private void leaveTeam() {
        System.out.println("Enter team name: ");
        String teamName = scanner.nextLine();
        if (players.get(currentPlayer).leaveTeam(teamName)) {
            System.out.println("Left team successfully");
        } else {
            System.out.println("You're not enrolled in a team called " + teamName);
        }
    }

    /**
     * Allows a player to report a playground by entering its name
     */
    private void reportPlayground() {
        System.out.println("Enter Playground booking number: ");
        int playgroundName = scanner.nextInt();
        scanner.skip("\n");
        boolean found = false;
        for (Playground playground : playgrounds) {
            if (playground.getBookingNumber() == playgroundName && playground.isActivated()) {
                players.get(currentPlayer).reportPlayground(playground);
                found = true;
                break;
            }
        }
        if (found) System.out.println("Playground reported successfully");
        else System.out.println("There is no such playground");
    }

    /**
     * Outputs the current bookings of the player
     */
    private void viewBookings() {
        System.out.println("\nThese are your current Bookings: ");
        for (Playground playground : playgrounds) {
            boolean printed = false;
            for (TimeSlot timeSlot : playground.getAvailability()) {
                if (timeSlot.isBooked() && timeSlot.getBookedTo().equalsIgnoreCase(players.get(currentPlayer).getUsername())) {
                    if (!printed) {
                        System.out.println("=========================================");
                        System.out.println("Playground Name: " + playground.getPlaygroundName());
                        System.out.println("Playground Address: \n" + playground.getAddress().toString());
                        printed = true;
                    }
                    System.out.println(timeSlot.toString());
                }
            }
        }
    }

    /**
     * Outputs the current teams the player is enrolled into or owns
     */
    private void viewTeams() {
        boolean hasTeams = false;
        if (players.get(currentPlayer).getTeamOwned() != null) {
            hasTeams = true;
            System.out.println("\nYour owned team: \n");
            System.out.println(players.get(currentPlayer).getTeamOwned().toString());
        }
        if (players.get(currentPlayer).getTeamsEnrolled().size() > 0) {
            hasTeams = true;
            System.out.println("\nTeams you're enrolled in: \n");
            for (Team team : players.get(currentPlayer).getTeamsEnrolled()) {
                System.out.println(team.toString());
            }
        }
        if (!hasTeams) System.out.println("\nYou don't own a team and you're not enrolled in one");
    }
}

