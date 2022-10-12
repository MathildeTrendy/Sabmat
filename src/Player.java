import java.util.ArrayList;

public class Player {
// Player Class knows the possion of the player
// Player Class will also be in control of the player's inventory

    private Room currentRoom;
    private ArrayList<Item> playerInventory = new ArrayList<>();
    private Weapon equippedWeapons;

    private double health;
    private final double maxHealth = 100;

    public Player(){
        this.health = health;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    public boolean move(String direction) {
        Room requestedRoom = null;

        if (direction.charAt(0) == 'n') {
            requestedRoom = currentRoom.getNorth();
        } else if (direction.charAt(0) == 's') {
            requestedRoom = currentRoom.getSouth();
        } else if (direction.charAt(0) == 'e') {
            requestedRoom = currentRoom.getEast();
        } else if (direction.charAt(0) == 'w') {
            requestedRoom = currentRoom.getWest();
        }

        if (requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    public Item takeItem (String itemName) {
        Item requestedItem = null;
        for (Item item : currentRoom.getItems()) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                requestedItem = item;
                playerInventory.add(item);
                currentRoom.getItems().remove(item);
                return requestedItem;
            }
        }
    return requestedItem;
    }

    public Item dropItem(String itemName){
        Item droppedItem = removeItem(itemName);
        currentRoom.getItem(String.valueOf(droppedItem));
        return droppedItem;

    }

    // Getter for health
    public double getHealth() {
        return health;
    }

    // Setter for health
    public void setHealth(double health){
        this.health = this.health+health;
    }

    // Method for removing item from player inventory, through the Inventory + method for finding item in room
    public Item removeItem(String name){
        Item found = currentRoom.findItem(name);
        for (Item item:playerInventory){
            if (item.getItemName().equals(name)){
                playerInventory.remove(item);
                return item;

            }
        }
        return null;
    }

    public EatReturnMessage eatFood(String itemName){
        Item item = takeInventory(itemName);
        if (item instanceof Food){
            health += ((Food) item).getHealthPoints();
            return EatReturnMessage.OK; // eatable
        }else {
            if (item!=null){
                return  EatReturnMessage.CANT; // not eatable/not a food
            }
            return EatReturnMessage.NOT_FOUND; // No food found
        }
    }

    public EquipReturnMessage equipWeapon(String itemName) {
        Item item = takeInventory((itemName));
        if (item != null) {
            if (item instanceof Weapon) {
                removeItem(itemName);
                equippedWeapons = ((Weapon) item);
                return EquipReturnMessage.IS_A_WEAPON;
            } else {
                    return EquipReturnMessage.NOT_A_WEAPON;
            }
        }
        return EquipReturnMessage.WEAPON_NOT_FOUND;
    }

    public Item takeInventory(String itemName) {
        for (Item item : playerInventory){
            if (item.getItemName().equalsIgnoreCase(itemName)){
                return item;
            }

        }
    return null;
    }

    // for player
    public void calHealth(int damage){
        health -= damage;
    }

    public AttackStatus attack(String enemyName){
        Enemy enemy = currentRoom.findEnemyByName(enemyName);
        if (enemy == null){
            return AttackStatus.NO_ENEMY;
        } else if (equippedWeapons == null) {
          return AttackStatus.NO_USABLE_WEAPON;
        }else{
            enemy.calHealth(equippedWeapons.damage);
            calHealth(enemy.getWeapon().damage);
            if (!enemy.isDead()) {
                return AttackStatus.ATTACKED;
            }else{
                currentRoom.removeEnemy(enemy);
            }
        }
       return AttackStatus.NO_SUCH_ENEMY;
    }

    public boolean isDead(){
        if (health <= 0){
            return true;
        }else{
            return false;
        }
    }

    /*
    // Method for having item
    public boolean haveTorch (){
        for (Item item : playerInventory){
            if (item.getItemName().contains("Torch")){
                torchInInventory = true;
            }else {
                torchInInventory = false;
            }
        }
        return torchInInventory;
    }
 /*
    // Method for turning on light
    public boolean torchLightOn(){
        boolean torchLightOn;
        if (torchLight == true){
            torchLightOn = true;
        }else {
            torchLightOn = false;
        }
        return torchLightOn;
    }

    public void toggleTorch (boolean toggleTorch) {
        if (toggleTorch = true){
            torchLight = true;
        }else {
            torchLight = false;
        }
    }
*/ // en del af når vi skal tænde lommelygten
}




