package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Playground {
    private String playgroundName;
    private String description;
    private ArrayList<TimeSlot> booked;
    private int bookingNumber;
    private double pricePerHour;
    private String link;
    private boolean approved;
    private boolean activated;

    public Playground(){
        playgroundName="playground";
        description="";
        pricePerHour=0;
        bookingNumber=0;
        link ="";
        booked=new ArrayList<>();
        activated=false;
        approved=false;
    }

    public boolean bookPlayground(TimeSlot timeSlot){
        for(int i=0;i<booked.size();i++)
            if(booked.get(i)==timeSlot)
                return false;
        booked.add(timeSlot);
        bookingNumber++;
        return true;
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

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
