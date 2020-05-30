package src.System;

import src.Playground.Playground;
import src.Users.Administrator;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminUI implements MainMenu{

    static private Administrator admin = new Administrator();
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Playground> playgrounds;

    public AdminUI(ArrayList<Playground> playgrounds) {
        this.playgrounds = playgrounds;
    }

    @Override
    public void mainMenu() {
        boolean control = true;
        while (control) {
            System.out.println("1-View all playgrounds");
            System.out.println("2-View un-activated playgrounds");
            System.out.println("3-Delete a playground");
            System.out.println("4-Return");

            while (control) {
                String option = scanner.nextLine();
                if (option.equals("1")) {
                    viewPlaygrounds();
                    break;
                } else if (option.equals("2")) {
                    viewUnactivated();
                    break;
                } else if (option.equals("3")) {
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
                    if (deletePlayground(playground)) {
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("Cannot delete");
                    }

                } else if (option.equals("4")) {
                    control = false;
                } else {
                    System.out.println("***Enter valid option***");
                }
            }
        }
    }

    private boolean deletePlayground(Playground playground) {
        int playgroundIndex = playgrounds.indexOf(playground);
        if (playgroundIndex != -1) {
            playgrounds.remove(playgroundIndex);
            return true;
        }
        return false;
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
                System.out.println("Activate current playground? (Enter 'Y' or any key to skip)");
                String option = scanner.nextLine();
                if (option.equalsIgnoreCase("Y")) {
                    admin.activatePlayground(playground);
                }
            }
        }
    }
}
