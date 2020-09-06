package src.Utilities;

import java.util.Scanner;

/**
 * An {@code Address} class is used to store the data of an address, dividing it into parts
 */
public class Address {
    /**
     * the street number
     */
    private int streetNumber;
    /**
     * the street name
     */
    private String streetName;
    /**
     * the neighborhood
     */
    private String neighborhood;
    /**
     * the city
     */
    private String city;

    /**
     * A constructor for the {@code Address} object
     * @param streetNumber the street number
     * @param streetName the street name
     * @param neighborhood the neighborhood
     * @param city the city
     */
    public Address(int streetNumber, String streetName, String neighborhood, String city) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    @Override
    public String toString() {
        return streetNumber + " " + streetName + ", " + neighborhood + ", " + city;
    }

    /**
     * Gets the street number of the address
     * @return the street number
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the street number of the address
     * @param streetNumber the new street number
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * Gets the street name of the address
     * @return the street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the street name of the address
     * @param streetName the new street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets the neighborhood of the address
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Sets the neighborhood of the address
     * @param neighborhood the new neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * Gets the city of the address
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the address
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }
}
