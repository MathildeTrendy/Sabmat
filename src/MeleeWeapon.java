public class MeleeWeapon extends Weapon {

    //nærkamp

   public MeleeWeapon(String itemName, String description, int damage){
       super(itemName, description, damage);
    }

    @Override
    public int getRemainingAmmo(){
       return 0;
    }

}
