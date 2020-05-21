package com.company;

import java.util.ArrayList;

/**
 * A {@code Player} object is a User that can show available playgrounds and book the playground that he wants
 */
public class Player extends User {

    /**
     * A Constructor that sets the Player data using User constructor
     * @param fn the first name of the player
     * @param ln the last name of the player
     * @param mail the email of the player
     * @param un the username of the player
     * @param pw the password of the player
     */
    public Player(String fn, String ln, String mail, String un, String pw) {
        super(fn, ln, mail, un, pw, "Player");
    }

    /**
     * A method to display a list of operations available to the {@code Player} object
     * @param playgrounds playgrounds available in the system
     */
    @Override
    public void operations(ArrayList<Playground> playgrounds) {
        while (true) {
            System.out.println("\n--------------------Welcome " + firstName + " " + lastName + "--------------------------");
            System.out.println("1- Show available playground" +
                    "\n2- Book a playground with known booking number" +
                    "\n3- Log out");
            int option = in.nextInt();
            if (option == 1) {
                showAvailablePlaygrounds(playgrounds);
            } else if (option == 2) {
                System.out.print("Enter the booking number of the playground: ");
                int bn = in.nextInt();
                for (int i = 0; i < playgrounds.size(); i++) { //checks if the booking number is valid in the system
                    if (playgrounds.get(i).getBookingNumber() == bn) {
                        boolean booked = bookPlayground(playgrounds.get(i));
                        while (!booked) { // checks if the user wants to re-enter the time slot in case he entered it wrong in the first time
                            System.out.print("Do you want to try again ? (y for yes): ");
                            String book = in.next();
                            if (book.equalsIgnoreCase("y")) {
                                booked = bookPlayground(playgrounds.get(i));
                            } else
                                break;
                        }
                    }
                }
            } else if (option == 3) {
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    /**
     * Shows all the available playgrounds in the system and displays an option to filter or book playgrounds
     * @param playgrounds playgrounds available in the system
     */
    public void showAvailablePlaygrounds(ArrayList<Playground> playgrounds) {
        for (int i = 0; i < playgrounds.size(); i++) {
            System.out.println(playgrounds.get(i).toString());
        }
        System.out.print("\nDo you want to filter Playgrounds by time slot? (y for yes): ");
        String filter;
        filter = in.next();
        ArrayList<Playground> filteredPlaygrounds = new ArrayList<Playground>(); // an ArrayList that will hold the filtered Playgrounds in specific time slot
        if (filter.equalsIgnoreCase("y")) {
            filteredPlaygrounds = filterPlaygrounds(playgrounds);
        }
        for (int i = 0; i < filteredPlaygrounds.size(); i++) {
            System.out.println(filteredPlaygrounds.get(i).toString());
        }
        System.out.print("\nDo you want to book a playground? (y for yes): ");
        String book;
        book = in.next();
        if (book.equalsIgnoreCase("y")) {
            System.out.print("Enter the playground Booking number: ");
            int bn;
            bn = in.nextInt();
            for (int j = 0; j < playgrounds.size(); j++) {
                if (playgrounds.get(j).getBookingNumber() == bn) {
                    boolean booked = bookPlayground(playgrounds.get(j));
                    while (!booked) {
                        System.out.print("Do you want to try again ? (y for yes): ");
                        book = in.next();
                        if (book.equalsIgnoreCase("y")) {
                            booked = bookPlayground(playgrounds.get(j));
                        } else
                            break;
                    }
                }
            }
        }
    }

    /**
     * Filters the playgrounds in the system to a certain time slot inputted by the player
     * @param playgrounds playgrounds available in the system
     * @return an ArrayList of Playgrounds after being filtered using the time slots the player entered
     */
    public ArrayList<Playground> filterPlaygrounds(ArrayList<Playground> playgrounds) {
        int day, month, year, hour;
        System.out.println("Enter date in this format (day month year): ");
        day = in.nextInt();
        month = in.nextInt();
        year = in.nextInt();
        while (day < 0 || day > 31 || month < 0 || month > 12 || year < 2020) { // checks if the date is invalid
            System.out.println("Invalid date, please try again");
            System.out.println("Enter date in this format (day month year): ");
            day = in.nextInt();
            month = in.nextInt();
            year = in.nextInt();
        }
        System.out.println("Enter hour (in 24-hour format): ");
        hour = in.nextInt();
        while (hour < 0 || hour > 23) { //checks if the hour is invalid
            System.out.println("Please enter a valid hour between 0 and 23");
            hour = in.nextInt();
        }
        TimeSlot t = new TimeSlot(day, month, year, hour);
        ArrayList<Playground> pg = new ArrayList<Playground>();
        for (int i = 0; i < playgrounds.size(); i++) { //compares this time slot to every time slot in every playground in the system
            for (int j = 0; j < playgrounds.get(i).getTimeSlots().size(); j++) {
                if (playgrounds.get(i).getTimeSlots().get(j).isAvailable()
                        && playgrounds.get(i).getTimeSlots().get(j).equals(t)) {
                    pg.add(playgrounds.get(i));
                    break;
                }
            }
        }
        return pg; //returns the filtered playgrounds
    }

    /**
     * Books a playground in a specific time slot inputted by the player
     * @param playground the playground that is to be booked
     * @return boolean indicating that success of the booking procedure
     */
    public boolean bookPlayground(Playground playground) {
        int day, month, year, hour;
        System.out.println("\nEnter date in this format (day month year): ");
        day = in.nextInt();
        month = in.nextInt();
        year = in.nextInt();
        while (day < 0 || day > 31 || month < 0 || month > 12 || year < 2020) {// checks if the date is invalid
            System.out.println("Invalid date, please try again");
            System.out.println("Enter date in this format (day month year): ");
            day = in.nextInt();
            month = in.nextInt();
            year = in.nextInt();
        }
        System.out.println("Enter hour (in 24-hour format): ");
        hour = in.nextInt();
        while (hour < 0 || hour > 23) { // checks if the hour is invalid
            System.out.println("Please enter a valid hour between 0 and 23");
            hour = in.nextInt();
        }
        TimeSlot t = new TimeSlot(day, month, year, hour);
        boolean booked = playground.bookPlayground(t, getUsername());
        if (booked) {
            System.out.println("Playground is booked successfully");
        } else
            System.out.println("Time slot you entered is not available");
        return booked; //returns whether the playground is booked successfully or not
    }
}
