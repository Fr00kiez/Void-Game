package sample;

public class Context {
    private final static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }

    private Player player = new Player();

    public Player getPlayer() {
        return player;
    }
}
