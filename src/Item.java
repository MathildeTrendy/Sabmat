public class Item {

    //Field - term for multiple attributes
    private String itemName;
    private String description;

    public Item(String itemName, String description){
        this.description = description;
        this.itemName = itemName;
    }

    public String getItemName(){
        return itemName;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return itemName + "\n" + description;
    }

}
