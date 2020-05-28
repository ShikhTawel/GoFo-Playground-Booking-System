package Classes;

public class Administrator {
    private String name;
    public Administrator(){
        name = "Admin";
    }
    public void approvePlayground(Playground playground)
    {
        playground.setApproved(true);
    }
    public void activatePlayground(Playground playground){
        playground.setActivated(true);
    }
    public void suspendPlayground(Playground playground){
        playground.setActivated(false);
    }
    public void deletePlayground(Playground playground){
        playground.setApproved(false);
    }
}
