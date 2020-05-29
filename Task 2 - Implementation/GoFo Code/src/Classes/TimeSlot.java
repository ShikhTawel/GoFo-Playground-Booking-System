package Classes;

import java.util.Objects;

public class TimeSlot {
    private int day;
    private int month;
    private int year;
    private int startingHour;
    private int endingHour;
    private boolean booked;
    private String bookedTo;

    public TimeSlot() {
        this.day = 1;
        this.month = 1;
        this.year = 2020;
        this.startingHour = 0;
        this.endingHour = 0;
        booked = false;
    }

    public TimeSlot(int day, int month, int year, int startingHour, int endingHour) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
        booked = false;
    }

    boolean isBooked() {
        return booked;
    }

    void book(String username) {
        booked = true;
        bookedTo = username;
    }

    void unbook() {
        booked = false;
        bookedTo = "";
    }

    public int getDay() {
        return day;
    }

    public boolean setDay(int day) {
        if (day < 1 || day > 31) return false;
        this.day = day;
        return true;
    }

    public int getMonth() {
        return month;
    }

    public boolean setMonth(int month) {
        if (month < 1 || month > 12) return false;
        this.month = month;
        return true;
    }

    public int getYear() {
        return year;
    }

    public boolean setYear(int year) {
        if (year < 2020) return false;
        this.year = year;
        return true;
    }

    public int getStartingHour() {
        return startingHour;
    }

    public boolean setStartingHour(int startingHour) {
        if (startingHour < 0 || startingHour > 23) return false;
        this.startingHour = startingHour;
        return true;
    }

    public int getEndingHour() {
        return endingHour;
    }


    @Override
    public String toString() {
        String res =
                "Date: " + day + "/" + month + "/" + year
                + "\nStarting Hour: " + startingHour
                + "\nEnding Hour: " + endingHour;
        if (isBooked()) {
            res += "\nBooked: Yes";
            res += "\nBooked to: " + bookedTo;
        } else {
            res += "\nBooked: No";
        }
        res += '\n';
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return day == timeSlot.day &&
                month == timeSlot.month &&
                year == timeSlot.year &&
                startingHour == timeSlot.startingHour &&
                endingHour == timeSlot.endingHour;
    }

    public boolean setEndingHour(int endingHour) {
        if (endingHour < 0 || endingHour > 23) return false;
        this.endingHour = endingHour;
        return true;
    }
}
