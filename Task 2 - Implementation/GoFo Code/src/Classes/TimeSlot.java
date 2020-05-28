package Classes;

public class TimeSlot {
    private int day;
    private int month;
    private int year;
    private int startingHour;
    private int endingHour;

    public TimeSlot() {
        this.day = 1;
        this.month = 1;
        this.year = 2020;
        this.startingHour = 0;
        this.endingHour = 0;
    }

    public TimeSlot(int day, int month, int year, int startingHour, int endingHour) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(int startingHour) {
        this.startingHour = startingHour;
    }

    public int getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(int endingHour) {
        this.endingHour = endingHour;
    }
}
