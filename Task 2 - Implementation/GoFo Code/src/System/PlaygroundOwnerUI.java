package src.System;

import src.Playground.Playground;
import src.Playground.PlaygroundOwner;

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

        System.out.println("Playground added successfully, waiting for activation.");
    }

    private boolean updatePlayground() {

        boolean foundPlayground = false;

        // find Playground and update it
        // make foundPlayground true

        return foundPlayground;
    }

    private void viewBookings() {
    }
}
