package src.System;

import src.Users.*;
import src.Utilities.Address;
import src.Utilities.Playground;

import java.util.*;

public class GoFoSystem {
    private ArrayList<Player> players;
    private ArrayList<PlaygroundOwner> owners;
    private ArrayList<Playground> playgrounds;
    private ArrayList<Administrator> admins;
    private UI ui;

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
