package src.Users;
import src.Users.User;
import src.Utilities.Address;
import src.Utilities.Playground;

import java.util.ArrayList;

/**
 * A {@code PlaygroundOwner} class is an extension of the {@code User} class, adding the properties and methods of the owner
 */
public class PlaygroundOwner extends User {
    /**
     * A list of playgrounds that the owner owns
     */
    public ArrayList<Playground> playgrounds;

    /**
     * A constructor for the {@code PlaygroundOwner} object
     * @param fn first name of the owner
     * @param ln last name of the owner
     * @param em email of the owner
     * @param pass password of the owner
     * @param un username of the owner
     * @param mn mobile number of the owner
     * @param ad address of the owner
     */
    public PlaygroundOwner(String fn, String ln, String em, String pass, String un, String mn, Address ad) {
        super(fn, ln, em, pass, un, mn, ad);
        playgrounds = new ArrayList<>();
    }

    /**
     * Adds a new playground to the owner's list
     * @param temp the playground to be added
     */
    public void addPlayground(Playground temp) {
        playgrounds.add(temp);
    }

    /**
     * Updates a playground's data from the owner's list of playgrounds
     * @param prev the previous playground data
     * @param neww the new playground data
     * @return whether the playground is successfully updated
     */
    public boolean updatePlayground(Playground prev, Playground neww) {
        for (int i = 0; i < playgrounds.size(); i++)
            if (playgrounds.get(i) == prev) {
                playgrounds.set(i, neww);
                return true;
            }
        return false;
    }

    /**
     * Gets the list of playgrounds the owner owns
     * @return the list of playgrounds
     */
    public ArrayList<Playground> getPlaygrounds() {
        return playgrounds;
    }

    /**
     * Gets the data of all the owner's playgrounds as a String
     * @return a String containing the details of the playgrounds
     */
    public String getBookings() {
        String res = "";
        for (int i = 0; i < playgrounds.size(); i++) {
            res += playgrounds.get(i).toString();
        }
        return res;
    }

    public void showBookings()
    {
        if (playgrounds.size()==0)
        {
            System.out.println("There is no Bookings now");
            return;
        }
        for (int i = 0 ; i<playgrounds.size();i++)
            System.out.println(playgrounds.get(i).toString());
    }

}
