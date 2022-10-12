public class RangedWeapon extends Weapon {
    //ladt våben (ammunition)

    protected int ammo;

    public RangedWeapon(String itemName, String description, int damage, int ammo){
        super(itemName, description, damage);
        this.ammo = ammo;
    }
    @Override
    public int getRemainingAmmo(){
        return ammo;
    }

    public void setAmmo(int ammo){
        this.ammo = ammo;
    }

    @Override
    public boolean usableWeapon(){
        if (ammo == 0){
        return false;
        }else{
            return false;
        }
    }



}
