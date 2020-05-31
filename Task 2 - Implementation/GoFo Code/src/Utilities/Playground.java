package src.Utilities;

import src.Users.PlaygroundOwner;
import src.Users.Player;

import java.util.ArrayList;

public class Playground {
    private PlaygroundOwner owner;
    private String playgroundName;
    private String description;
    private Address address;
    private ArrayList<TimeSlot> availability;
    private int bookingNumber;
    private double pricePerHour;
    private String link;
    private int reports;
    private boolean activated;
    private static int cnt = 0;

    public Playground(PlaygroundOwner owner) {
        this.owner = owner;
        playgroundName = "playground";
        description = "";
        pricePerHour = 0;
        bookingNumber = ++cnt;
        link = "";
        availability = new ArrayList<>();
        activated = false;
        reports = 0;
    }

    public boolean bookPlayground(TimeSlot timeSlot, Player player) {
        if (!this.isActivated()) {
            return false;
        }
        double totalPrice;
        if (timeSlot.getStartingHour() < timeSlot.getEndingHour())
            totalPrice = pricePerHour * (timeSlot.getEndingHour() - timeSlot.getStartingHour());
        else
            totalPrice = pricePerHour * ((timeSlot.getEndingHour() + 24) - timeSlot.getStartingHour());
        if (player.getEwallet().getBalance() <= totalPrice) {
            return false;
        }
        for (int i = 0; i < availability.size(); i++)
            if (availability.get(i).equals(timeSlot)) {
                if (availability.get(i).isBooked())
                    return false;
                else {
                    availability.get(i).book(player.getUsername());
                    player.getEwallet().transfer(totalPrice, owner);
                    return true;
                }
            }
        return false;
    }

    public void setAvailability(ArrayList<TimeSlot> ts) {
        availability.clear();
        availability.addAll(ts);
    }

    public ArrayList<TimeSlot> getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        String res =
                "=============================================\n" +
                "playgroundName: " + playgroundName + '\n' +
                        "description: " + description + '\n' +
                        "bookingNumber: " + bookingNumber + '\n' +
                        "pricePerHour: " + pricePerHour + '\n' +
                        "link: " + link + '\n' +
                        "activated: " + activated + '\n' +
                        "Address: " + address.toString() + '\n' +
                        "Availability: " + '\n';
        for (int i = 0; i < availability.size(); i++) {
            res += availability.get(i).toString();
            res += '\n';
        }
        res += "\n========================================";
        return res;
    }

    public void reportPlayground() {
        reports++;
    }

    public String getPlaygroundName() {
        return playgroundName;
    }

    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address add) {
        address = add;
    }

    public int getReports() {
        return reports;
    }
}
