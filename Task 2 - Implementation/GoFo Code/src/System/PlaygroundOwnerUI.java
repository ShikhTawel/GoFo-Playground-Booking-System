package src.System;

import src.Playground.Playground;
import src.Playground.PlaygroundOwner;
import src.Playground.TimeSlot;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PlaygroundOwnerUI implements MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Playground> playgrounds;
    private ArrayList<PlaygroundOwner> playgroundOwners;
    private int currentOwner;

    public PlaygroundOwnerUI(ArrayList<Playground> playgrounds, ArrayList<PlaygroundOwner> playgroundOwners, int currentOwner) {
        this.playgrounds = playgrounds;
        this.playgroundOwners = playgroundOwners;
        this.currentOwner = currentOwner;
    }

    @Override
    public void mainMenu() {

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

        return new TimeSlot(day, month, year, startingHour, endingHour);
    }

    private void addPlayground() {
        Playground playground = new Playground();

        System.out.print("Enter Playground Name: ");
        String playgroundName = scanner.nextLine();
        playground.setPlaygroundName(playgroundName);

        System.out.println("Enter Playground description: ");
        String description = scanner.nextLine();
        playground.setDescription(description);

        System.out.println("Enter Playground Address as following:\n no. st neighborhood city ");

        int streetNumber = scanner.nextInt();
        String streetName = scanner.next();
        String neighborhood = scanner.next();
        String city = scanner.next();

        Address address = new Address(streetNumber, streetName, neighborhood, city);
        playground.setAddress(address);

        System.out.println("Enter Link: ");
        String link = scanner.nextLine();

        System.out.println("Enter pricePerHour: ");
        double pricePerHour = scanner.nextDouble();

        var timeSlots = new ArrayList<TimeSlot>();
        TimeSlot timeSlot;
        while (true) {
            System.out.println("Enter available timeslot: ");
            timeSlot = setTimeslot();
            timeSlots.add(timeSlot);
            System.out.println("Add another timeslot? Enter 'Y or any key to exit");
            String option = scanner.nextLine();
            if (!option.equalsIgnoreCase("Y")) {
                break;
            }
        }
        playgroundOwners.get(currentOwner).addPlayground(playground);
        playgroundOwners.get(currentOwner).getPlaygrounds().get(playgroundOwners.get(currentOwner).getPlaygrounds().size()-1).setAvailability(timeSlots);

        System.out.println("Playground added successfully, waiting for activation.");
    }

    /*private boolean updatePlayground() {

        boolean foundPlayground = false;

        // find Playground and update it
        // make foundPlayground true

        return foundPlayground;
    }*/

    private void viewBookings() {
        System.out.println(playgroundOwners.get(currentOwner).getBookings());
    }
}
