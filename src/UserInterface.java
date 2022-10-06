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
        System.out.println("\n" + "You have just arrived in an outlandish realm called the Mushroom Kingdom. It was ruled by Princess Toadstool and her faithful Mushroom people. \n" +
                "But one day, evil cast a shadow over the land and the evil King Bowser Koopa emerged with his army of Goombas, Spinies, Flying Koopas, and other malignant creatures. \n" +
                "King Koopa abducted Princess Toadstool and trapped her. So It's now up to you, to save the princess and defeat King Koopa and his minions\n");
        System.out.println("Welcome to Adventure time - choose a direction to go. \n" + "Type in, if you want to go north, south, east or west.");

        boolean isRunning = true;
        do {Scanner sc = new Scanner(System.in);

            //Method for handling all input from user
            String playerInput = sc.nextLine();
            playerInput = playerInput.toLowerCase();
            String[] playerInputs = playerInput.split(" ");
            String command = playerInputs[0];
            String playerChoice = "";
            if (playerInputs.length > 1) {
                playerChoice = playerInputs[1];
            }

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

                case "exit":
                    System.out.println("exiting the game...");
                    isRunning = false;
                    System.exit(1);
                    break;

                case "help", "i need help":
                    System.out.println("Do you need help?"); //TODO inkludere help setting - gør evt af brugeren kan svare ja eller nej på af få hjælp og ja eller nej til af få et ledetråd
                    break;

                case "take":
                    Item itemPickedUp = adventure.takeItem(playerChoice);
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
                    } if (adventure.getPlayer().getCurrentWeapon().isEmpty()) {
                    System.out.println("You have no equipped weapons");
                }else{
                    System.out.println("You are in posession of :\n" + adventure.getPlayer().getCurrentWeapon());
                }
                    break;
                case "health", "hp":
                    System.out.println("You currently have: " + adventure.getPlayer().getHealth() + " health points");
                    break;

                case "eat", "drink":
                    ReturnMessage result = adventure.playerEat(playerChoice);
                    switch (result) {
                        case NOT_FOUND:
                            System.out.println("there is no such thing as a " + playerChoice + " - et eat anywhere nearby");
                            break;
                        case CANT:
                            System.out.println("You can´t eat " + playerChoice + " - it isn`t food!!");
                        case OK:
                            System.out.println("You have eaten the " + playerChoice + " - your health is now: " + " " + adventure.getPlayer().getHealth() + " " + adventure.getPlayer().removeItem(playerChoice));
                    }

                    case "equip" -> {
                        TryEquipWeapon equipWeapon = adventure.equipWeapon(playerChoice);
                        if (equipWeapon == TryEquipWeapon.ITEM_NOT_FOUND) {
                            System.out.println(playerChoice+" is not in inventory");
                        } else if (equipWeapon == TryEquipWeapon.NOT_WEAPON){
                            System.out.println(playerChoice + " is not a weapon");
                        } else if (equipWeapon == TryEquipWeapon.IS_WEAPON){
                            System.out.println("You have equipped " + playerChoice);
                        } else if (equipWeapon == TryEquipWeapon.ALREADY_TWO_WEAPONS){
                            System.out.println("You already have two weapons, unequip one weapon");
                        }
                    }

                case "attack":
                    break;

                default:
                    System.out.println("Unknown command");
                    break;
            }

        } while (isRunning);
    }

}



