package src.Playground;
import src.Users.User;
import src.System.Address;

import java.util.ArrayList;

public class PlaygroundOwner extends User {
    public ArrayList<Playground> playgrounds;

    public PlaygroundOwner(String fn, String ln, String em, String pass, String un, String mn, Address ad) {
        super(fn, ln, em, pass, un, mn, ad);
        playgrounds = new ArrayList<>();
    }

    public void addPlayground(Playground temp) {
        playgrounds.add(temp);
    }

    public boolean updatePlayground(Playground prev, Playground neww) {
        for (int i = 0; i < playgrounds.size(); i++)
            if (playgrounds.get(i) == prev) {
                playgrounds.set(i, neww);
                return true;
            }
        return false;
    }

    public ArrayList<Playground> getPlaygrounds() {
        return playgrounds;
    }

    public String getBookings() {
        String res = "";
        for (int i = 0; i < playgrounds.size(); i++) {
            res += playgrounds.get(i).toString();
        }
        return res;
    }

}
