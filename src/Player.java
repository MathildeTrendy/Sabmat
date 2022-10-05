import java.util.ArrayList;

public class Player {
// Player Class knows the possion of the player
// Player Class will also be in control of the player's inventory

    private Room currentRoom;
    private ArrayList<Item> playerInventory = new ArrayList<>();
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

    public void addItem (Item item){
        playerInventory.add(item);
    }

    /*
    public Item removeItem(String itemName){
        for (Item item : playerInventory) {
            if (item.getItemName().equals(itemName)){
                playerInventory.remove(item);
                return item;
            }

        }
        return null;
    }
*/ // remove item

    public Item takeItem (String itemName) {
        Item requestedItem = null;
        for (Item item : currentRoom.getItems()) {
            if (item.getItemName().equals(itemName)) {
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

    public Item getItem(String itemName){
        for (Item item : playerInventory){
            if (item.getItemName().equals(itemName)){
                return item;
            }
        }
        return null;
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

}



