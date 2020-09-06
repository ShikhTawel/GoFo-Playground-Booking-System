package src.System;

import src.Utilities.Playground;
import src.Users.Administrator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * {@code AdminUI} class allows the admins to interact with the system using the console
 */
public class AdminUI {

    private Administrator admin;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Playground> playgrounds;

    /**
     * A constructor for the {@code AdminUI} object
     *
     * @param playgrounds a list of all playgrounds currently in the system
     * @param admin the current admin logged into the system
     */
    public AdminUI(ArrayList<Playground> playgrounds, Administrator admin) {
        this.playgrounds = playgrounds;
        this.admin = admin;
        mainMenu();
    }

    /**
     * A main menu that allows an admin to choose an operation
     */
    public void mainMenu() {
        while (true) {
            System.out.println("\n1-View all playgrounds");
            System.out.println("2-View un-activated playgrounds");
            System.out.println("3-Delete a playground");
            System.out.println("4-Logout");

            String option = scanner.nextLine();
            if (option.equals("1")) {
                viewPlaygrounds();
            } else if (option.equals("2")) {
                viewUnactivated();
            } else if (option.equals("3")) {
                deletePlayground();
            } else if (option.equals("4")) {
                break;
            } else {
                System.out.println("***Enter valid option***");
            }
        }
        System.out.println("Logging out ...");
    }

    /**
     * Outputs all the playgrounds currently in the system and their details
     */
    private void viewPlaygrounds() {
        for (Playground playground : playgrounds) {
            System.out.println(playground.toString());
        }
    }

    /**
     * Outputs all the playgrounds that are not activated in the system, and allows an admin to activate a playground
     */
    private void viewUnactivated() {
        for (Playground playground : playgrounds) {
            if (!playground.isActivated()) {
                System.out.println(playground.toString());
                System.out.println("Activate current playground? (Enter 'Y' for yes or any key to skip)");
                String option = scanner.nextLine();
                if (option.equalsIgnoreCase("Y")) {
                    admin.activatePlayground(playground);
                    System.out.println("\nPlayground activated successfully ✅");
                }
            }
        }
    }

    /**
     * Allows an admin to delete a playground by entering its booking number (ID)
     */
    private void deletePlayground() {
        System.out.println("Enter playground booking number: ");
        int bookingNumber = scanner.nextInt();
        scanner.skip("\n");
        Playground playground = null;
        for (int i = 0; i < playgrounds.size(); ++i) {
            if (playgrounds.get(i).getBookingNumber() == (bookingNumber)) {
                playground = playgrounds.get(i);
                break;
            }
        }
        if (playground == null) {
            System.out.println("***Playground not found***");
            return;
        }
        playgrounds.remove(playground);
        System.out.println("Playground removed successfully ✅");
    }
}
