package sample.models;

public class Context {
    private final static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }

    //Getter
    private final Player player = new Player(100, 20, (float) 0.6, "Player");

    public Player getPlayer() {
        return player;
    }
}
