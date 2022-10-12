public class Map {
    // Map Class builds the map and gives the starting room to the Adventure class

    private Room starterRoom;

    // Different Rooms with name and description, creating room objects
    // Rooms created
    public void createRooms() {
        Room room1 = new Room("Mushroom Kingdom","You are now in a realm called the Mushroom Kingdom, " +
                "a world orbited by a vast chain of small planetoids and the sweet Mushroom people.\n " +
                "In order to find King Koopa and save the princess you must go out in the world and explore the other 8 realms. " +
                "You have a long journey ahead of you. You must intrepid deep and hazardous waters, jump from tree to tree, " +
                "and visually examine your steps in the dark evil castles filled with fire balls and lava pits. " +
                "Be wise and collect everything necessary on your way to obtain maximum power to subjugate the evil King Koopa and rescue the Princess.\n");

        Room room2 = new Room("Yoshi's Island", "You have just entered Yoshi's Island which is a large, tropical and mountainous\nisland inhabited by the peace-loving Yoshis. " +
                "You are standing on the beach, next\nto you are some huge musa trees, by the foot of the trees there are some fallen\nbananas. " +
                "Further ahead is an old well, with lots of water. Laying on bricks there is a flash light.\n");

        Room room3 = new Room("Donut Plains", "You have just entered the realm called Donut Plains. " +
                "The name hints at the strange shape of the island (which looks indeed like a doughnut, when seen from above). " +
                "The island is full of trees, lakes and plants, some of them very deadly - so be careful. " +
                "There is a small key hidden in the grass. Off in the distance you can see something shining, it is a bottle.\n");

        Room room4 = new Room("Twin Bridges", "You are surrounded by a vast mass of black, dead trees, which howled in the wind like a wolf. In front of you, there is a fortress. " +
                "The fortress itself is a seemingly-elegant medieval castle that has a gothic, dark exterior. " +
                "This must be the Twin Bridges castle. \n" +
                "On your side there is a torch laying in the mudd.\n");

        Room room5 = new Room("Vanilla Dome", "It's all dark… you must have just entered the Vanilla Dome. " +
                "Vanilla Dome is a huge cave world inside a mountain. Beware of your steps, or you will fall down on the many bottomless pits.\n");

        Room room6 = new Room("Forest of Illusion", "Around you there are distinctive trees with faces, closely resemble coconut trees. Their faces lack cheeks. " +
                "This northerless must be the Forest of Illusion, which is something of a maze. " +
                "In the middle of the forest there is a huge red door with a small keyhole. \n");

        Room room7 = new Room("King Bowser Koopa land", "Finally, you have reached the terrifying land of King Bowser Koopa. " +
                "Bowser's land is gloomy, scary, dark and generally unpleasant. " +
                "Ahead of you is a long  dark path that leads to a huge old creepy castle. " +
                "The path is surrounded by fiery hot lava, which if you get too close will burn your skin.");

        Room room8 = new Room("Chocolate Island", "The smell of Chocolate surrounds your nose, this can not be anything else than the Chocolate island, a " +
                "mountainous island named after its chocolate-brown coloring and plants and huge chocolate river. " +
                "You´re standing beside the famous chocolate river that stretches all around the island. " +
                "By the side of the river there are gummy-bear-flowers in all kind of colors and flavors . ");

        Room room9 = new Room("Valley of Bowser", "You are now at the center of the valley of souls. You are surrounded by beautiful mountains. " +
                "The sun is at its peak and shines down on you, and warms your body. " +
                "There is no wind. To your left there is an overturned truck, there is scattered bread, apples and tomatoes everywhere. ");

        // Item list
        Item flashLight = new Item ("Flashlight", " ");
        Item smallKey = new Item ("Small key", " ");
        Item bottle = new Item ("Glass bottle", " ");
        Item torch = new Item ("Torch", " ");

        // Weapon item list
        RangedWeapon machineGun = new RangedWeapon ("Machine gun", " ",50,5);
        RangedWeapon rifle = new RangedWeapon ("Rifle", " ", 20, 5);
        MeleeWeapon knive = new MeleeWeapon ("Knive", " ", 5);
        RangedWeapon pistol = new RangedWeapon ("Pistol", " ", 40,5);

        // Food item list
        Food banana = new Food("banana", " ", 20);
        Food gummy_bear_flower = new Food("gummy_bear_flower", " ", -85);
        Food chocolate_liquid = new Food("liquid_chocolate"," ", -85);
        Food bread = new Food("bread"," ", 30);
        Food apple = new Food("apple"," ", 30);
        Food tomato = new Food("tomato"," ", 30);
        Food water = new Food("water"," ", 50);

        // Enemy list
        Enemy kingBowserKoopa = new Enemy("King Bowser Koopa", " ", 200, pistol);

        //Setting directions for each room
        //Inherited from room (that's why we use addItem)
        //Room 1
        room1.setEast(room2);
        room1.setSouth(room3);
        room1.addEnemy(kingBowserKoopa);

        //Room 2
        room2.setWest(room1);
        room2.setEast(room3);
        room2.addItem(banana);
        room2.addItem(water);
        room2.addItem(flashLight);

        //Room 3
        room3.setWest(room2);
        room3.setSouth(room6);
        room3.addItem(smallKey);
        room3.addItem(bottle);

        //Room 4
        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.addItem(torch);

        //Room 5
        room5.setSouth(room8);

        //Room 6
        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.addItem(machineGun);
        room6.addItem(rifle);
        room6.addItem(knive);
        room6.addItem(pistol);

        //Room 7
        room7.setNorth(room4);
        room7.setEast(room8);

        //Room 8
        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);
        room8.addItem(gummy_bear_flower);
        room8.addItem(chocolate_liquid);

        //Room 9
        room9.setNorth(room6);
        room9.setWest(room8);
        room9.addItem(bread);
        room9.addItem(apple);
        room9.addItem(tomato);

        //Setting starterRoom to room1 at the start
        starterRoom = room1;
    }

    public Room getStarterRoom(){
        return starterRoom;
    }

}
