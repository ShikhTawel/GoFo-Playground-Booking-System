package src.Utilities;

/**
 * A {@code TimeSlot} class is used to store a date and a starting hour and and ending hour to a specific time slot
 */
public class TimeSlot {
    /**
     * a day of the month
     */
    private int day;
    /**
     * a month of the year
     */
    private int month;
    /**
     * the year
     */
    private int year;
    /**
     * the starting hour of the time slot
     */
    private int startingHour;
    /**
     * the ending hour of the time slot
     */
    private int endingHour;
    /**
     * a boolean that specifies whether the time slot is booked or not
     */
    private boolean booked;
    /**
     * the username of the player that the time slot is booked to, if any
     */
    private String bookedTo;

    /**
     * A default constructor for the {@code TimeSlot} object
     */
    public TimeSlot() {
        this.day = 1;
        this.month = 1;
        this.year = 2020;
        this.startingHour = 0;
        this.endingHour = 0;
        booked = false;
    }

    /**
     * A constructor for the {@code TimeSlot} object
     * @param day day of the month
     * @param month month of the year
     * @param year year of the time slot
     * @param startingHour starting hour of the time slot
     * @param endingHour ending hour of the time slot
     */
    public TimeSlot(int day, int month, int year, int startingHour, int endingHour) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
        booked = false;
    }

    /**
     * Books the time slot to a specific player and stores his username
     * @param username username of the player
     */
    public void book(String username) {
        booked = true;
        bookedTo = username;
    }

    /**
     * Unbooks the time slot
     */
    public void unbook() {
        booked = false;
        bookedTo = "";
    }

    /**
     * Checks whether the time slot is booked
     * @return booked or not
     */
    public boolean isBooked() {
        return booked;
    }

    @Override
    public String toString() {
        String res = "--------------------------------------\n" +
                "Date: " + day + "/" + month + "/" + year
                + "\nStarting Hour: " + startingHour
                + "\nEnding Hour: " + endingHour;
        if (isBooked()) {
            res += "\nBooked: Yes";
            res += "\nBooked to: " + bookedTo;
        } else {
            res += "\nBooked: No";
        }
        res += "\n------------------------------------";
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

    /**
     * Gets the day of the month
     * @return day of the month
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the day of the month
     * @param day the new day
     * @return whether day is valid or not
     */
    public boolean setDay(int day) {
        if (day < 1 || day > 31) return false;
        this.day = day;
        return true;
    }

    /**
     * Gets the month of the year
     * @return month of the year
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the month of the year
     * @param month the new month
     * @return whether the month is valid or not
     */
    public boolean setMonth(int month) {
        if (month < 1 || month > 12) return false;
        this.month = month;
        return true;
    }

    /**
     * Gets the year of the time slot
     * @return year of the time slot
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the time slot
     * @param year the new year
     * @return whether the year is valid or not
     */
    public boolean setYear(int year) {
        if (year < 2020) return false;
        this.year = year;
        return true;
    }

    /**
     * Gets the starting hour of the time slot
     * @return startingHour of the time slot
     */
    public int getStartingHour() {
        return startingHour;
    }

    /**
     * Sets the starting hour of the time slot
     * @param startingHour the new starting hour
     * @return whether the starting hour is valid or not
     */
    public boolean setStartingHour(int startingHour) {
        if (startingHour < 0 || startingHour > 23) return false;
        this.startingHour = startingHour;
        return true;
    }

    /**
     * Gets the ending hour of the time slot
     * @return endingHour of the time slot
     */
    public int getEndingHour() {
        return endingHour;
    }

    /**
     * Sets the ending hour of the time slot
     * @param endingHour the new ending hour of the time slot
     * @return whether the ending hour is valid or not
     */
    public boolean setEndingHour(int endingHour) {
        if (endingHour < 0 || endingHour > 23) return false;
        this.endingHour = endingHour;
        return true;
    }

    /**
     * Gets the username of the player the time slot is booked to
     * @return the username of the player the time slot is booked to
     */
    public String getBookedTo() {
        return bookedTo;
    }

}
