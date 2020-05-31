package src.System;

import src.Users.*;
import src.Utilities.Address;
import src.Utilities.Playground;

import java.util.*;

/**
 * {@code GoFoSystem} class is used as the basis of the system, it stores all the users and admins' data and accesses the UI
 */
public class GoFoSystem {
    /**
     * A list of all players in the system
     */
    private ArrayList<Player> players;
    /**
     * A list of all playground owners in the system
     */
    private ArrayList<PlaygroundOwner> owners;
    /**
     * A list of all playgrounds in the system
     */
    private ArrayList<Playground> playgrounds;
    /**
     * A list of admins in the system
     */
    private ArrayList<Administrator> admins;
    /**
     * A UI to enable users to interact with the system
     */
    private UI ui;

    /**
     * A constructor for the system, which initializes the lists and and starts the UI
     */
    public GoFoSystem() {
        players = new ArrayList<>();
        owners = new ArrayList<>();
        playgrounds = new ArrayList<>();
        admins = new ArrayList<>();
        players.add(new Player("", "", "player@example.com", "player", "player", "", new Address(3, "", "", "")));
        owners.add(new PlaygroundOwner("", "", "owner@example.com", "owner", "owner", "", new Address(3, "", "", "")));
        admins.add(new Administrator("admin", "admin"));
        ui = new UI(players, owners, playgrounds, admins);
    }
}
