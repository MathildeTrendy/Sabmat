public class RangedWeapon extends Weapons{
    //ladt våben (ammunition)

    protected int ammunition;

    public RangedWeapon(String itemName, String description, int damage, double range, int ammunition){
        super(itemName, description, damage, range);
        this.ammunition = ammunition;
    }

    public int getAmmunition(){
        return ammunition;
    }

    public void ammoUse(){
        ammunition--;
    }

}
