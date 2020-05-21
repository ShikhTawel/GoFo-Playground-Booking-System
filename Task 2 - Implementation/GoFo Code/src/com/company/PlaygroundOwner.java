package com.company;

import java.util.ArrayList;

/**
 * A {@code PlaygroundOwner} object is a User that can own Playgrounds and show their current bookings
 */
public class PlaygroundOwner extends User {

    /**
     * An ArrayList of playgrounds in the system that this PlaygroundOwner owns
     */
    private ArrayList<Playground> ownedPlaygrounds = new ArrayList<Playground>();

    /**
     * A Constructor that sets the PlaygroundOwner data using User constructor
     * @param fn the first name of the PlaygroundOwner
     * @param ln the last name of the PlaygroundOwner
     * @param mail the email of the PlaygroundOwner
     * @param un the username of the PlaygroundOwner
     * @param pw the password of the PlaygroundOwner
     */
    public PlaygroundOwner(String fn, String ln, String mail, String un, String pw) {
        super(fn, ln, mail, un, pw, "PlaygroundOnwer");
    }

    /**
     * A method to display a list of operations available to the {@code PlaygroundOwner} object
     * @param playgrounds playgrounds available in the system
     */
    @Override
    public void operations(ArrayList<Playground> playgrounds) {
        while (true) {
            System.out.println("\n-----------------------Welcome " + firstName + " " + lastName + "---------------------------");
            System.out.println("1- Add a playground" +
                    "\n2- View My playgrounds and Bookings" +
                    "\n3- Log out");
            int option = in.nextInt();
            if (option == 1) {
                addPlayground(playgrounds);
            } else if (option == 2) {
                viewBookings();
            } else if (option == 3) {
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    /**
     * Adds a playground using information inputted by the PlaygroundOwner
     * @param playgrounds playgrounds available in the system
     */
    public void addPlayground(ArrayList<Playground> playgrounds) {
        in.skip("\n");
        System.out.print("\nEnter playground name: ");
        String name = in.nextLine();
        System.out.print("Enter playground description: ");
        String desc = in.nextLine();
        System.out.print("Enter a unique playground booking number: ");
        int bn;
        bn = in.nextInt();
        for (int i = 0; i < playgrounds.size(); i++) { //checks if this booking number is already taken
            if (playgrounds.get(i).getBookingNumber() == bn) {
                System.out.println("This booking number is already taken");
                System.out.print("Enter a unique playground booking number: ");
                bn = in.nextInt();
                i = -1;
            }
        }
        System.out.print("Enter price per hour: ");
        double prh;
        prh = in.nextDouble();
        while (prh < 0) { //checks if the price is invalid
            System.out.println("Invalid price per hour, try again");
            System.out.print("Enter price per hour: ");
            prh = in.nextDouble();
        }
        //create a new Playground object owned by this PlaygrounOwner, and reference it in the system's playgrounds list
        ownedPlaygrounds.add(new Playground(name, desc, bn, prh, getUsername()));
        playgrounds.add(ownedPlaygrounds.get(ownedPlaygrounds.size() - 1));
    }

    /**
     * shows the current Playgrounds owned by this PlaygroundOwner and their current status
     */
    public void viewBookings() {
        for (int i = 0; i < ownedPlaygrounds.size(); i++) {
            System.out.println(ownedPlaygrounds.get(i).toString());
        }
    }
}
