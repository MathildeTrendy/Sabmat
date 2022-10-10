public abstract class Weapons extends Item {

/*
    room 6
    Item machine_gun = new Item("Machine gun");
    Item rifles = new Item("Rifle");
    Item knifes = new Item("Knife");
    Item pistols = new Item("Pistol");
    Item ammunition = new Item("Ammunition")
    */
     protected int damage;
     protected double range;
     protected int maxDamage = 200;

    public Weapons(String itemName, String description, int damage, double range) {
        super(itemName, description);
        this.damage = damage;
        this.range = range;
    }

   // - skal vi lave getter til navn og description selvom det er gjort ovre i en anden klasse?

    public int getDamage(){
        return damage;
}

    public double getRange(){
        return damage;
}
}
