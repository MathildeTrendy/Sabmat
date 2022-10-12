public class Enemy {
    private String name, description;
    private int healthPoints, damage;
    private Weapons weapons;

    public Enemy(String name, String description, int healthPoints, int damage, Weapons weapons){
        this.name = name;
        this.description = description;
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.weapons = weapons;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getHealthPoints(){
        return healthPoints;
    }
    public int getDamage(){
        return damage;
    }

    public Weapons getWeapons() {
        return weapons;
    }
}
