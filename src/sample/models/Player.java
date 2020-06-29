package sample.models;

public class Player extends Entity {
    private String name;

    public Player() {
        super(100, 20, (float) 0.6, "Player");
    }

    //Getter

    public String getName() {
        return name;
    }
    //Setter
    public void setName(String name) {

        this.name = name;
    }
}
