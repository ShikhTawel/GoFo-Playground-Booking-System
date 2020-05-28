package Classes;

import java.util.ArrayList;

public class PlaygroundOwner extends User {
    public ArrayList<Playground> playgrounds;
    public PlaygroundOwner(){
        playgrounds=new ArrayList<>();
    }

    public void addPlayground(Playground temp){
        playgrounds.add(temp);
    }
    public boolean updatePlayground(Playground prev,Playground neww){
        for(int i=0;i<playgrounds.size();i++)
            if(playgrounds.get(i)==prev)
            {
                playgrounds.set(i,neww);
                return true;
            }
        return false;
    }

}
