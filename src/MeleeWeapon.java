public class MeleeWeapon extends Weapons {

   public MeleeWeapon(String itemName, String description, int damage){
       super(itemName, description, damage);
    }

    @Override
    public int getRemainingAmmo(){
       return 0;
    }

}
