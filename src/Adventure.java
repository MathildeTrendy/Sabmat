public class Adventure {
// This class is the controller for the whole game, but does not control the player

    //Field - term for multiple attributes
    private Map map;
    private Player player;

    // Adventure constructor, creating the map, player, and setting players currentRoom to starterRoom
    public Adventure(){
        map = new Map();
        map.createRooms();
        player = new Player();
        player.setCurrentRoom(map.getStarterRoom());
    }

    public Player getPlayer(){
        return player;
    }

    // Getter for players current room
    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }

    // Calling move method from the class Player
    public boolean go(String direction){
        return player.move(direction);
    }

    public Item takeInventory(String itemName){
        return player.takeInventory(itemName);
    }

    public EatReturnMessage playerEat(String itemName){
        return player.eatFood(itemName);
    }

    public EquipReturnMessage equipWeapon(String itemName) {
        return player.equipWeapon(itemName);
    }

    public AttackStatus attack(String enemyName){
        return player.attack(enemyName);
    }

    public int getEnemyHealth(){
        return getCurrentRoom().getEnemies().get(0).getHealthPoints();
    }


}

