package com.company;

/**
 * A {@code TimeSlot} object hold the information and methods of a time slot using the date (day, month, year) and hour.
 * it also specifies whether the time slot is booked or not, and the Player it's booked to
 */
public class TimeSlot {
    private int day;
    private int month;
    private int year;
    private int hour;
    boolean available;
    String bookedTo;

    /**
     * A Constructor to set the data of the time slot
     * @param d day of the month
     * @param m month of the year
     * @param y year
     * @param h hour (in 24-hour format)
     */
    TimeSlot(int d, int m, int y, int h) {
        day = d;
        hour = h;
        month = m;
        year = y;
        available = true;
        bookedTo = "";
    }

    /**
     * Indicates whether the playground is available at this time slot
     * @return boolean indicatingwhether the playground is available at this time slot
     */
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Date: " + day + "/" + month + "/" + year + " , hour: " + hour + ":00";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return day == timeSlot.day &&
                month == timeSlot.month &&
                year == timeSlot.year &&
                hour == timeSlot.hour;
    }

    /**
     * Gets day of the month
     * @return day int
     */
    public int getDay() {
        return day;
    }

    /**
     * Gets the month of the year
     * @return month int
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets year
     * @return year int
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets hour of the day (in 24-hour format)
     * @return hour int
     */
    public int getHour() {
        return hour;
    }

    /**
     * Sets month of the year
     * @param month int
     */
    public void setMonth(int month) {
        if (month >= 1 && month <= 12)
            this.month = month;
    }

    /**
     * Sets year
     * @param year int
     */
    public void setYear(int year) {
        if (year >= 2020)
            this.year = year;
    }

    /**
     * Sets day of the month
     * @param day int
     */
    public void setDay(int day) {
        if (day >= 1 && day <= 31)
            this.day = day;
    }

    /**
     * Sets hour of the day (in 24-hour format)
     * @param hour int
     */
    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23)
            this.hour = hour;
    }

    /**
     * Gets the username of the Player this time slot is booked to (if any)
     * @return bookedTo String
     */
    public String getBookedTo() {
        return bookedTo;
    }

    /**
     * Books the time slot to a certain player
     * @param player username String of the player
     */
    public void book(String player) {
        available = false;
        bookedTo = player;
    }

    /**
     * Makes the time slot available and removes booking
     */
    public void makeAvailable() {
        available = true;
        bookedTo = "";
    }
}
