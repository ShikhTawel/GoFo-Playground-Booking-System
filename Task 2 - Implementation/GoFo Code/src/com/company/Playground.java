package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A {@code Playground} object contains information and methods to be applied to playgrounds and relate them to their owners.
 * A Playground has a name, description, timeSlots, bookingNumber, pricePerHour and ownerUsername
 */
public class Playground {
    private String name;
    private String description;
    private ArrayList<TimeSlot> timeSlots;
    private int bookingNumber;
    private double pricePerHour;
    private String ownerUsername;
    private Scanner in = new Scanner(System.in);

    /**
     * A Constructor that sets the Playground data
     * @param nm name of the playground
     * @param desc description of the playground
     * @param bn a unique booking number for the playground
     * @param prh price per hour of the playground
     * @param username username of the owner of the playground
     */
    public Playground(String nm, String desc, int bn, double prh, String username) {
        name = nm;
        description = desc;
        bookingNumber = bn;
        pricePerHour = prh;
        ownerUsername = username;
        timeSlots = new ArrayList<TimeSlot>();
        setAvailability();
    }

    /**
     * A method to set the available time slots to this playgrounds using dates and hours
     */
    public void setAvailability() {
        System.out.println("\nEnter the available time slots: ");
        while (true) {
            System.out.println("Enter date in this format (day month year): ");
            int day, month, year;
            day = in.nextInt();
            month = in.nextInt();
            year = in.nextInt();
            while (day < 0 || day > 31 || month < 0 || month > 12 || year < 2020) { //checks if the date is invalid
                System.out.println("Invalid date, please try again");
                System.out.println("Enter date in this format (day month year): ");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
            }
            int hour;
            System.out.println("Enter hour (in 24-hour format)(ex: 15): ");
            hour = in.nextInt();
            while (hour < 0 || hour > 23) { // checks if the hour is invalid
                System.out.println("Please enter a valid hour between 0 and 23");
                hour = in.nextInt();
            }
            timeSlots.add(new TimeSlot(day, month, year, hour));
            System.out.print("Do you want to add another time slot? (y for yes): ");
            String another;
            another = in.next();
            if (!another.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    /**
     * A method to book this playground to a certain Player object using his username and a specific time slot
     * @param ts time slot to book the playground in
     * @param player the username of the Player that is to book the playground
     * @return a boolean indicating the success of the booking procedure
     */
    boolean bookPlayground(TimeSlot ts, String player) {
        for (int i = 0; i < timeSlots.size(); i++) {
            if (timeSlots.get(i).equals(ts) && timeSlots.get(i).isAvailable()) {
                timeSlots.get(i).book(player);
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder("=============================" +
                "\nPlayground name: " + name
                + "\nDescription: " + description
                + "\nPrice Per Hour: " + pricePerHour
                + "\nBooking Number: " + bookingNumber
                + "\nOwner username: " + ownerUsername
                + "\nAvailable time slots: \n\n");
        for (int i = 0; i < timeSlots.size(); i++) {
            msg.append(timeSlots.get(i).toString()).append("\nStatus: ").append((timeSlots.get(i).isAvailable()) ? "Available" : "Booked to: " + timeSlots.get(i).getBookedTo()).append("\n-----------------\n");
        }
        msg.append("=============================");
        return msg.toString();
    }

    /**
     * Gets the name of the playground
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the playground
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the playground
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the playground
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the time slots of the playground, whether they're booked or available
     * @return ArrayList of time slots of the playgrounds
     */
    public ArrayList<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    /**
     * Sets the time slots of the playground
     * @param timeSlots ArrayList
     */
    public void setTimeSlots(ArrayList<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    /**
     * gets the booking number of the playground
     * @return booking number int
     */
    public int getBookingNumber() {
        return bookingNumber;
    }

    /**
     * Sets the booking number of the playground
     * @param bookingNumber int
     */
    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    /**
     * Gets the price per hour of the playground
     * @return price per hour double
     */
    public double getPricePerHour() {
        return pricePerHour;
    }

    /**
     * Sets the price per hour of the playground
     * @param pricePerHour double
     */
    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
