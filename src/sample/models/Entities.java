package sample.models;

import java.io.ObjectInputFilter;

public class Entities {
    protected String name;
    private int health = 100;
    private int attackDamage = 0;
    private float guardPercentage = (float) 0.75;
    private boolean isGuarding = false;

    public Entities(int health, int attackDamage, float guardPercentage, String name){
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.guardPercentage = guardPercentage;
    }

    //Getter

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public String setGuarding (boolean status) {
        isGuarding = status;

        return getName() + " melakukan pertahanan.";
    }

    public int setHealth (int newHealth) {
        health = newHealth;
        return health;
    }


    //Attack Bot

    public String[] attack(Entities enemy) {
        if (isGuarding) {
            setGuarding(false);
        }

        int newHealth;
        if (!enemy.getGuarding()) {
            newHealth = enemy.getHealth() - attackDamage;
        } else {
            newHealth = (int) (enemy.getHealth() - (attackDamage * (1 - enemy.getGuardPercentage())));
            enemy.setGuarding(false);
        }

        if (newHealth < 0) {
            newHealth = 0;
        }

        String[] messages = {
                getName() + " menyerang " + enemy.getName() + " dengan damage " + attackDamage + ".",
                "Health " + enemy.getName() + " berkurang dari " + enemy.getHealth() + " menjadi " + newHealth + ".",
        };

        enemy.setHealth(newHealth);

        return messages;
    }

    //Action

    //Enemies
   /*Entities player = new Entities(100, 35, 0.65);
    Entities enemy = new Entities(70, 20, 0.50);*/

}
