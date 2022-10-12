import java.util.Locale;
import java.util.Scanner;

public class UserInterface {

    private Scanner keyb = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private Adventure adventure;
    //private Adventure game;

    public UserInterface(Adventure c) {
        this.adventure = c;
    }

    public void start() {
        //introduction to the game
        adventure = new Adventure();
        System.out.println("Welcome to Mario World\n" + "You have just arrived in an outlandish realm called the Mushroom Kingdom. It was ruled by Princess Toadstool and her faithful Mushroom people. \n" +
                "But one day, evil cast a shadow over the land and the evil King Bowser Koopa emerged with his army of Goombas, Spinies, Flying Koopas, and other malignant creatures. \n" +
                "King Koopa abducted Princess Toadstool and trapped her. So It's now up to you, to save the princess and defeat King Koopa and his minions\n");
        System.out.println("Type 'go', followed by the direction you want to go.\nYou can go north, south, east or west.");

        boolean isRunning = true;
        do {
            Scanner sc = new Scanner(System.in);

            //Method for handling all input from user
            String playerInput = sc.nextLine();
            playerInput = playerInput.toLowerCase();
            String[] playerInputs = playerInput.split(" ");
            String command = playerInputs[0];
            String playerChoice = getPlayerChoice(playerInputs);


            switch (command) {
                case "go":
                    boolean b = adventure.go(playerChoice);
                    if (b) {
                        System.out.println("Going " + playerChoice + " - take a look around, by typing in 'look'");
                    } else {
                        System.out.println("You cannot go that way.");
                    }
                    break;


                case "look around", "look":
                    System.out.println("location: " + adventure.getCurrentRoom().getNameOfRoom());
                    System.out.println(adventure.getCurrentRoom().getDescriptionOfRoom());
                    System.out.println("Grab an item, by typing 'take' or for help type 'help' ");
                    break;

                case "exit", "ex":
                    System.out.println("exiting the game...");
                    isRunning = false;
                    System.exit(1);
                    break;

                case "help":
                    System.out.println("Here is a list of commands:\n" +
                            "type (n)orth to go north \n" +
                            "type (s)outh to go south \n" +
                            "type (e)ast to go east \n" +
                            "type (w)est to go west \n" +
                            "type (l)ook to look around in your current location \n" +
                            "type (e)eat 'food' to eat" +
                            "type (d)rink 'beverage' to drink" +
                            "type (h)ealth to view your healthpoints" +
                            "type (A)ttack 'enemy' to attack" +
                            "type (ex)it to exit game");

                    break;

                case "take":
                    Item itemPickedUp = adventure.getPlayer().takeItem(playerChoice);
                    if (itemPickedUp == null) {
                        System.out.println("no such item exists in this room");
                    } else {
                        System.out.println("You just picked up " + itemPickedUp.getItemName());
                    }
                    break;
                case "drop":
                    Item itemDropped = adventure.getPlayer().removeItem(playerChoice);
                    if (itemDropped == null) {
                        System.out.println("no such item...");
                    } else {
                        System.out.println("You have just dropped " + itemDropped);
                        adventure.getPlayer().getCurrentRoom().addItem(itemDropped);
                    }
                    break;
                case "inventory", "inv":
                    if (adventure.getPlayer().getPlayerInventory().isEmpty()) {
                        System.out.println("You are currently holding nothing...");
                    } else {
                        System.out.println("You are now in the posession of :\n " + adventure.getPlayer().getPlayerInventory());
                    }
                    if (adventure.getPlayer().getPlayerInventory().isEmpty()) {
                        System.out.println("You have no equipped weapons");
                    }
                    break;
                case "health", "h":
                    System.out.println("You currently have: " + adventure.getPlayer().getHealth() + " health points");
                    break;

                case "eat", "e", "drink", "d":
                    EatReturnMessage eatResult = adventure.playerEat(playerChoice);
                    switch (eatResult) {
                        case NOT_FOUND:
                            System.out.println("there is no such thing as a " + playerChoice + " - eat anywhere nearby");
                            break;
                        case CANT:
                            System.out.println("You can´t eat " + playerChoice + " - it isn`t food!!");
                            break;
                        case OK:
                            System.out.println("You have eaten the " + playerChoice + " - your health is now: " + " " + adventure.getPlayer().getHealth());
                            break;
                    }
break;
                case "equip": {
                    EquipReturnMessage equipResult = adventure.equipWeapon(playerChoice);
                    switch (equipResult) {
                        case WEAPON_NOT_FOUND:
                            System.out.println("there is no such thing as a " + playerChoice + "nearby");
                            break;
                        case IS_A_WEAPON:
                            System.out.println("You just equipped " + playerChoice + " - whats your next move?");
                            break;
                        case NOT_A_WEAPON:
                            System.out.println("You can't use " + playerChoice + "as a weapon, you fucking idiot");
                            break;

                    }
                }
                break;
                case "attack":
                    AttackStatus attackStatus = adventure.attack(playerChoice);
                    switch (attackStatus) {
                        case NO_ENEMY:
                            System.out.println("There is no enemies in this room");
                        case NO_SUCH_ENEMY:
                            System.out.println("There is no enemy by the name of " + playerChoice);
                        case NO_WEAPON:
                            System.out.println("You are not in prosession of " + playerChoice + " - try another weapon or look in your inventory");
                        case NO_USABLE_WEAPON:
                            System.out.println("There is no usable weapon by the name of " + playerChoice);
                        case ATTACKED:
                            System.out.println("You just attacked the enemy with a " + playerChoice + " - the enemy is now down at: " + adventure.getEnemyHealth());
                    }

break;
                default:
                    System.out.println("Unknown command");
                    break;
            }

        }
        while (isRunning);
    }

    // Method for scanner can take more than one ord in as an input
    private String getPlayerChoice(String[] playerInputs) {
        String playerChoice = "";
        for (int i = 1; i < playerInputs.length; i++) {
            playerChoice += " " + playerInputs[i];
        }
        playerChoice = playerChoice.trim();
        return playerChoice;
    }
}





