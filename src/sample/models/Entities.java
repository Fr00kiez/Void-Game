package sample.models;

import java.io.ObjectInputFilter;

public class Entities {
    protected String nameEnemies;
    private ObjectInputFilter.Status status;
    private int health = 100;
    private int attackDamage = 0;
    private float guardPercentage = (float) 0.75;
    private boolean isGuarding = false;

    public Entities(int health, int attackDamage, float guardPercentage, String nameEnemies){
        this.nameEnemies = nameEnemies;
        this.health = health;
        this.attackDamage = attackDamage;
        this.guardPercentage = guardPercentage;
    }

    //Getter

    public String getnameEnemies() {
        return nameEnemies;
    }

    public int getHealth () {
        return health;
    }

    public float getGuardPercentage() {
        return guardPercentage;
    }

    public boolean getGuarding () {
        return isGuarding;
    }

    //Setter

    public void setnameEnemies(String nameEnemies) {
        this.nameEnemies = nameEnemies;
    }

    public boolean setGuarding (boolean status) {
        isGuarding = status;
        return isGuarding;
    }

    public int setHealth (int newHealth) {
        health = newHealth;
        return health;
    }


    //Attack Bot

    public void attack(Entities enemy) {
        if (!enemy.getGuarding()) {
            int newHealth = enemy.getHealth() - attackDamage;
            enemy.setHealth(newHealth);
            return;
        }

        float newHealth = enemy.getHealth() - (attackDamage * enemy.getGuardPercentage());
        enemy.setGuarding(false);
    }

    //Action

    //Enemies
   /* Enemies player = new Enemies(100, 35, 0.65);
    Enemies enemy = new Enemies(70, 20, 0.50);*/

}
