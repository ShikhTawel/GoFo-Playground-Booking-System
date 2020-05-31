package src.System;

import src.Utilities.Address;
import src.Utilities.Playground;
import src.Users.PlaygroundOwner;
import src.Utilities.TimeSlot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PlaygroundOwnerUI{

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Playground> playgrounds;
    private ArrayList<PlaygroundOwner> playgroundOwners;
    private int currentOwner;

    public PlaygroundOwnerUI(ArrayList<Playground> playgrounds, ArrayList<PlaygroundOwner> playgroundOwners, int currentOwner) {
        this.playgrounds = playgrounds;
        this.playgroundOwners = playgroundOwners;
        this.currentOwner = currentOwner;
        mainMenu();
    }

    public void mainMenu() {
        String option = "";
        while (true) {
            System.out.println("\n1- Add a Playground" +
                    "\n2- View current Bookings" +
                    "\n3- Access eWallet" +
                    "\n4- Logout");
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("1")) {
                addPlayground();
            } else if (option.equalsIgnoreCase("2")) {
                viewBookings();
            } else if (option.equalsIgnoreCase("3")) {
                eWalletUI eWalletUI = new eWalletUI(playgroundOwners.get(currentOwner));
            } else if (option.equalsIgnoreCase("4")) {
                break;
            }
            else {
                System.out.println("***Enter valid option***\n");
            }
        }
        System.out.println("\nLogging out ...");
    }

    private void addPlayground() {
        Playground playground = new Playground(playgroundOwners.get(currentOwner));

        System.out.print("Enter Playground Name: ");
        String playgroundName = scanner.nextLine();
        playground.setPlaygroundName(playgroundName);

        System.out.println("Enter Playground description: ");
        String description = scanner.nextLine();
        playground.setDescription(description);

        System.out.println("Enter Address: ");
        System.out.print("Enter Street number: ");
        int streetNumber = scanner.nextInt();
        System.out.print("Enter Street name: ");
        scanner.skip("\n");
        String streetName = scanner.nextLine();
        System.out.print("Enter Neighborhood: ");
        String neighborhood = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        Address address = new Address(streetNumber, streetName, neighborhood, city);
        playground.setAddress(address);

        System.out.println("Enter Link: ");
        String link = scanner.nextLine();
        playground.setLink(link);

        System.out.println("Enter pricePerHour: ");
        double pricePerHour = scanner.nextDouble();
        playground.setPricePerHour(pricePerHour);

        var timeSlots = new ArrayList<TimeSlot>();
        TimeSlot timeSlot;
        while (true) {
            System.out.println("Enter available timeslot: ");
            timeSlot = setTimeslot();
            timeSlots.add(timeSlot);
            System.out.println("Add another timeslot? Enter 'Y' for yes or any key to exit");
            String option = scanner.nextLine();
            if (!option.equalsIgnoreCase("Y")) {
                break;
            }
        }
        playground.setAvailability(timeSlots);
        playgroundOwners.get(currentOwner).addPlayground(playground);
        playgrounds.add(playgroundOwners.get(currentOwner).getPlaygrounds()
                .get(playgroundOwners.get(currentOwner).getPlaygrounds().size() - 1));
        System.out.println("\nPlayground added successfully ✅, waiting for approval by an administrator.");
    }

    private void viewBookings() {
        System.out.println(playgroundOwners.get(currentOwner).getBookings());
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
        scanner.skip("\n");
        return new TimeSlot(day, month, year, startingHour, endingHour);
    }
}
