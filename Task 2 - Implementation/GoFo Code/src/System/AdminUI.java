package src.System;

import src.Utilities.Playground;
import src.Users.Administrator;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminUI {

    private Administrator admin;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Playground> playgrounds;

    public AdminUI(ArrayList<Playground> playgrounds, Administrator admin) {
        this.playgrounds = playgrounds;
        this.admin = admin;
        mainMenu();
    }

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

    private void viewPlaygrounds() {
        for (Playground playground : playgrounds) {
            System.out.println(playground.toString());
        }
    }

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

    private void deletePlayground() {
        System.out.println("Enter playground name: ");
        String name = scanner.nextLine();
        Playground playground = null;
        for (int i = 0; i < playgrounds.size(); ++i) {
            if (playgrounds.get(i).getPlaygroundName().equalsIgnoreCase(name)) {
                playground = playgrounds.get(i);
                break;
            }
        }
        if (playground == null) {
            System.out.println("***Playground not found***");
            return;
        }
        playgrounds.remove(playground);
        System.out.println("Playground removed successfully");
    }
}
