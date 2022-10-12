import java.util.ArrayList;

    public class Room {

    //Field - term for multiple attributes
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String nameOfRoom;
    private String descriptionOfRoom;

    //The Room Class constructs the attributes for the rooms
    //list of items in a room
    private ArrayList <Item> roomItems = new ArrayList<>();
    private ArrayList<Enemy>enemies = new ArrayList<>();

    // List of Items
    public ArrayList<Item>getItems(){
        return roomItems;
    }

    // List of enemies (gætter)
    public ArrayList<Enemy>getEnemies(){
        return enemies;
    }

    public Room(String nameOfRoom, String descriptionOfRoom){
        this.nameOfRoom = nameOfRoom;
        this.descriptionOfRoom = descriptionOfRoom;
    }

    //method for adding af item to a room
    public void addItem(Item item){
        roomItems.add(item);
    }

    //method for adding af enemy to a room
    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    // Getter
    public Room(String name) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.nameOfRoom = name;
        this.descriptionOfRoom = descriptionOfRoom;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public String getNameOfRoom(){
        return nameOfRoom;
    }

    public String getDescriptionOfRoom(){
        return descriptionOfRoom;
    }

    //Setter
    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast (Room east){
         this.east=east;
    }

    public void setWest (Room west){
         this.west=west;
    }

    public void removeEnemy(Enemy enemy){
        enemies.remove(enemy);
    }

    // Method for get/take the item
    public Item getItem (String itemName){
        for (Item item : roomItems){
            if (item.getItemName().equals(itemName)){
                return item;
            }
        }
        return null;
    }

    // Finds applicable item
    public Item findItem (String itemName){
        for (Item item:roomItems) {
            if (itemName.equals(item.getItemName()))
                return item;
        }
        return null;
    }

    // Method for removing item from inventory, looping through the room items
    public Item removeItem(String name){
        for (Item item: getItems()){
            if (item.getItemName().equals(name)){
                getItems().remove(item);
                return item;
            }
        }
        return null;
    }

    /*
    public void createMeleeWeapon(String itemName, String description, int damage){
        MeleeWeapon meleeWeapon = new MeleeWeapon(itemName, description, damage);
        addItem(meleeWeapon);
    }

    public void createRangeWeapon(String itemName, String description, int damage, int ammo){
        RangedWeapon rangedWeapon = new RangedWeapon(itemName, description, damage, ammo);
        addItem(rangedWeapon);
    }

     */

    public void createEnemies(String name, String description, int healthPoints, Weapon weapon){
        Enemy enemy = new Enemy(name, description, healthPoints,weapon);
        addEnemy(enemy);

    }

    public Enemy findEnemyByName (String enemyName){
        for (Enemy enemy : enemies){
            if (enemy.getName().equals(enemyName)){
            return enemy;
            }
        }
        return null;
    }

}







