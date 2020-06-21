package sample.models;

public class Player /*extends Entities*/ {
    private String name;

   /* public player (int health, int attackDamage, float guardPercentage, String nameEnemies){
        super(health,attackDamage,guardPercentage,nameEnemies);
    }*/

    //Getter

    public String getName() {

        return name;
    }
    //Setter
    public void setName(String name) {

        this.name = name;
    }
}
