public abstract class Weapons extends Item {


    protected int damage;


    public Weapons(String itemName, String description, int damage) {
        super(itemName, description);
        this.damage = damage;

    }

    public int getDamage() {
        return damage;
    }

    public abstract int getRemainingAmmo();

    public boolean usableWeapon() {
        return true;
    }
}

