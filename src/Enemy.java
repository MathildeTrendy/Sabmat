public class Enemy {
    private String name, description;
    private int healthPoints;
    private Weapon weapon;

    public Enemy(String name, String description, int healthPoints, Weapon weapons){
        this.name = name;
        this.description = description;
        this.healthPoints = healthPoints;
        this.weapon = weapons;
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

    public Weapon getWeapon() {
        return weapon;
    }

    //for monster
    public void calHealth(int damage){
        healthPoints -= damage;
    }



    public boolean isDead(){
        if (healthPoints<=0){
            return true;
        }else{
            return false;
        }
    }


}
