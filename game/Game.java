package game;

/**
 * Game.java
 * 
 * Class to model the game as a collection of rooms. The
 * rooms are organized as a graph, and the Room objects
 * are nodes in the graph.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */
public class Game {
    	/**
         * The current room the user is in. This serves to
         * purposes-- it is our only permanent connection to
         * the rooms in this game (the other rooms are reachable
         * by traversing this room's "doors"-- and it maintains
         * the state by representing the user's current location.
         */
        private Room currentRoom;

        /**
         * Keeps track of whether this game is over or not.
         */
        private boolean over;
        
        /**
         * Return the room in which the user is currently.
         */
        public Room getCurrentRoom() { return currentRoom; }
        
        
        
        /**
         * Constructor to set up the game.
         */
        public Game() { 
        	//starting world
        	System.out.println("You are a Galactic Federation Space TrooptroopTM on the star outpost"
        			+ "\n in Gamma Quadrant! Your commander has given you orders to explore the great unknow"
        			+ "\n and you have just bravely flown into an asteriod! You check your vital. You are not dead"
        			+ "\n However, you don't seem to know where in the great expanse of the universe you are...");
        	System.out.println("\nCOMPUTER: You may now enter a command");
        	Room startingRegion = new Room("You see the great expanse of space laid before you.");    	
        	Room asteriodRegion = new Room("The quadrant is filled with asteriod hurtling towards your ship");
            Room metalDebrisRegion = new Room("You see an object glinting in the light of the dying sun. There is"
            		+ "still a much larger metal object further away");
            Room warpRegion = new Room("");
            Room deathCountRegion = new Room("A bright light hits your eye. You can feel it moving to your forehead."
            		+ "\nA ship approaches. You must flee");
            Room emptyRegion = new Room("There is... nothing...");
            Room emptyRegion2 = new Room("There is... nothing...");
            Room emptyRegion3 = new Room("There is... nothing...");
            Room emptyRegion4 = new Room("There is... nothing...");
            Room emptyRegion5 = new Room("There is... nothing...");
        //starting world end

        Room swirlingMassEntrance = new Room("Bathroom");
        Room redSunEntrance = new Room("Basement");
        Room deathShipEntrance = new Room("Bedroom 1st Floor");
        Room blackHoleEntrance = new Room("Seems impossibly dark in that direction...");    
        TestItem test1 = new TestItem();
        test1.itemName("test1");
        TestItem test2 = new TestItem();
        test2.itemName("test2");
        TestItem test3 = new TestItem();
        test3.itemName("test3");
        blackHoleEntrance.addItem(test1);
        blackHoleEntrance.addItem(test2);
        blackHoleEntrance.addItem(test3);
        
        
        //black hole start
    	Room Blackhole = new Room("Center of the black hole. You feel your lungs compressing. You have 10 turns to find the wormhole.");
    	Room LightSource = new Room("Black holes don't have light. All you see is nothing.");
    	Room StarFragments = new Room("Surrounding you are fragments left behind by the collapse of an ancient giant star. You notice less fragments than when you first spotted them.");
    	Room SpaceTear = new Room("It appears to be a tear in space, I wouldn't want to go near that...");
    	Room WarpedDebris = new Room("The debris that was once here has been completely warped in size and color, emitting a somewhat dark shade of brown. From the outside, only sometimes is it visible.");
    	Room Wormhole = new Room("The only escape from the black hole. There is a bright neutron star in the distance with some accompanying asteroid fragments.");
    	Room NeutronStar = new Room("Known to be very hot but a beautiful blue, this star is older than the others by far. It is on the far side of a system by the name HP 50329Z. Planets ASCR407 and Vydol can be seen in the distance.");
    	
    	
    	RoomTie lever = new RoomTie("You feel the ground shake and hear a high pitched screech from far away.");
    	blackHoleEntrance.setDir("darkness", new LockedExit(this, Blackhole, null, lever, null));
    	blackHoleEntrance.addInteractable(lever);
    	Blackhole.setDir("light", new NormalExit(this, LightSource));
    	LightSource.setDir("back", new NormalExit(this, Blackhole));
    	Blackhole.setDir("distant fragments", new NormalExit(this, StarFragments));
    	StarFragments.setDir("blackhole", new NormalExit(this, Blackhole));
    	Blackhole.setDir("space tear", new NormalExit(this, SpaceTear));
    	SpaceTear.setDir("blackhole", new NormalExit(this, Blackhole));
    	SpaceTear.setDir("debris", new NormalExit(this, WarpedDebris));
    	WarpedDebris.setDir("space tear", new NormalExit(this, StarFragments));
    	WarpedDebris.setDir("distant fragments", new NormalExit(this, StarFragments));
    	
    	

    	StarFragments.setDir("wormhole", new NormalExit(this, Wormhole)); //room to be unlocked
    	    	
    	//Rooms to be connected to worm hole
    	Wormhole.setDir("star", new NormalExit(this, NeutronStar));
    	
    	
        
        
    	
        
        //black hole end
        
        /*
         
        //space station begin
        Room hangar = new Room("You find yourself in a large landing bay. Something seems off. To your left is a door that say MAINTINANCE. "
        		+ "In front of you is an open door");
        Room maintenance = new Room("You find yourself in a small room with scattered tools and parts. Something is sparking.");
        Room hallwayEntrance = new Room("You are in a hallway. In the darkness a light flickers off to your right.");
        //setting up hangar and maintenance
        hangar.setDir("left", maintenance);
        hangar.setDir("hallway", hallwayEntrance);
        maintenance.setDir("exit", hangar);
        //vents
        Room hallwaySouthWest = new Room("To your right is another hallway. Something is dripping from a vent above you.");
        Room ventSouthWest = new Room("Everything is dark. Whatever was dripping is covering the walls of the vent. It smells like iron.");
        Room ventNorthWest = new Room("Everything is dark. You see a pair of glowing eyes far to the right. You don't think it sees you... yet...");
        Room ventSouthEast = new Room("There is a light flickering outside the vent. You hear something in the vent ahead.");
        Room ventNorthEast = new Room("You see two massive green eyes looming over you. Blood drips from the creatures' mouth. "
        		+ "All of a sudden it screeches and lunges at you.");
        Room ventMonsterChase = new Room("You crawl as fast as you can. The banging and screeching behind you grows louder.");
        Room ventChaseEscape = new Room("The vent caves and you fall through the grate into a room with a flickering light.");
        hallwaySouthWest.setDir("vent", ventSouthWest);
        
        ventSouthWest.setDir("jump down", hallwaySouthWest);
        ventSouthWest.setDir("left", ventNorthWest);
        ventSouthWest.setDir("right", ventSouthEast);
        
        ventSouthEast.setDir("left", ventSouthWest);
        ventSouthEast.setDir("right", ventNorthEast);
        
        ventNorthWest.setDir("left", ventNorthEast);
        ventNorthWest.setDir("right", ventSouthWest);
        
        ventNorthEast.setDir("RUN.", ventMonsterChase);
        ventMonsterChase.setDir("RUN.", ventChaseEscape);
        ventMonsterChase.setDir("fall", hallwayEntrance);
        //first floor hallway
        Room hallwaySouth = new Room("You are in a dark hallway. You see the familiar light of the hangar to your left. "
        		+ "You hear a dull clang. There is a flickering light to your right."
        		+ "There is a room in front of labeled CARGO BAY");
        Room hallwaySouthEast = new Room("To your right is a hallway where you see a door that looks like it has been thrown off its hinges deeper."
        		+ "A light flickers through the gaping doorway. The noises grow louder.");
        Room hallwayEastSouth = new Room("A lone light in the otherwise dark room ahead of you flickers. You see blood."
        		+ "You can here a loud bang coming from a vent grate to your right.");
        Room hallwayNorthEast = new Room("The banging has stopped. There is a vent above you. You are being watched...");
        Room hallwayNorth = new Room("There is an elevator. By some miricale it seems to be working. There is a loud bang that came from a vent to your left.");
        Room hallwayNorthWest = new Room("There is what looks to be an elevator to your left. \nTo your right you see something dripping from the ceiling."
        		+ "Something echos through the vents.");
        Room hallwayWest = new Room("There is something dripping off to your right. There is a room in front of you. It is all black. You feel sick.");
        
        hallwayEntrance.setDir("hangar", hangar);
        hallwayEntrance.setDir("left", hallwaySouthWest);
        hallwayEntrance.setDir("right", hallwaySouth);
        
        hallwaySouth.setDir("left", hallwayEntrance);
        hallwaySouth.setDir("right", hallwaySouthEast);
        
        hallwaySouthEast.setDir("left", hallwaySouth);
        hallwaySouthEast.setDir("right", hallwayEastSouth);
        
        hallwayEastSouth.setDir("left", hallwaySouth);
        hallwayEastSouth.setDir("right", hallwayNorthEast);
        
        hallwayNorthEast.setDir("left", hallwayEastSouth);
        hallwayNorthEast.setDir("right", hallwayNorth);
        
        hallwayNorth.setDir("left", hallwayNorthEast);
        hallwayNorth.setDir("right", hallwayNorthWest);
        
        hallwayNorthWest.setDir("left", hallwayNorth);
        hallwayNorthWest.setDir("right", hallwayWest);
        
        hallwayWest.setDir("left", hallwayNorthWest);
        hallwayWest.setDir("right", hallwaySouthWest);
        
        hallwaySouthWest.setDir("left", hallwayWest);
        hallwaySouthWest.setDir("right", hallwaySouth);
        //first floor rooms and elevator
        Room elevatorFloor1 = new Room("Theres a panel with the numbers 1-4. There are scratch marks on the wall. "
        		+ "You feel the elevator shake a little when you step on.");
        Room elevatorFloor2 = new Room("It looks like the ceiling just outside the elevator has caved in."
        		+ " You try moving the rubble but it won't budge.");
        Room elevatorFloor3 = new Room("The floor just outside the elevator is all gone."
        		+ "You see a black form on the rubble below. You'll have to jump if you want to make it across.");
        Room elevatorFloor4= new Room("You see what looks like a command room. Out of the bay window you can see the stars.");
        Room cargoBay = new Room("You look around and see scattered boxes with belongings scattered across the ground. Can any of it be useful?");
        Room flickeringLight = new Room("You are in what seem to be baraks. Scratches mark the walls. You see a figure coughing.");
        
        elevatorFloor1.setDir("2", elevatorFloor2);
        elevatorFloor1.setDir("3", elevatorFloor3);
        elevatorFloor1.setDir("4", elevatorFloor4);
        
        elevatorFloor2.setDir("1", elevatorFloor1);
        elevatorFloor2.setDir("3", elevatorFloor3);
        elevatorFloor2.setDir("4", elevatorFloor4);
        
        elevatorFloor3.setDir("1", elevatorFloor1);
        elevatorFloor3.setDir("2", elevatorFloor2);
        elevatorFloor3.setDir("4", elevatorFloor4);
        
        elevatorFloor4.setDir("1", elevatorFloor1);
        elevatorFloor4.setDir("2", elevatorFloor2);
        elevatorFloor4.setDir("3", elevatorFloor3);
        
        hallwayNorth.setDir("elevator", elevatorFloor1);
        hallwaySouth.setDir("cargo", cargoBay);
        hallwayEastSouth.setDir("light", flickeringLight);
        
        //basement
        Room basementCollapse = new Room ("Around you is a labryth of pipes and machines, the inner workings of the ship. "
        		+ "The hallway above you is too far to get back up to.");
        		//add roomJoiner for button to open up stair for basementBottomLeft
        Room basementTopRight = new Room ("There is a flashing button labeled HANGAR on the wall."
        		+ "There is what looks like a boiler next to you.");
        		//add item for part of the ship
        Room basementBottomRight = new Room ("You find a massive machine reaching up into the center of the ship."
        		+ "All the pipes around you seem to be leading into it.");
        Room basementBottomLeft = new Room ("There are some slabs slightly protruding from the wall, just barely enough to see."
        		+ " They seem to lead to a trapdoor.");
        basementCollapse.setDir("left", basementBottomLeft);
        basementCollapse.setDir("right", basementTopRight);
        basementBottomLeft.setDir("left", basementBottomRight);
        basementBottomLeft.setDir("right", basementCollapse);
        basementBottomRight.setDir("left", basementTopRight);
        basementBottomRight.setDir("right", basementBottomLeft);
        basementTopRight.setDir("left", basementCollapse);
        basementTopRight.setDir("right", basementBottomRight);
        
        //floor 2
        Room floor2Entrance = new Room ("Ahead of you you see a large bay window and some equipment.");
        Room floor2SouthEast = new Room ("There's a sound almost like wind coming from a hall to your left.");
        Room floor2SouthWest = new Room ("You see a door in the hallway to your left with a yellow light coming out of it.");
        Room floor2West = new Room ("Through the blurry door of the door you see something green");
        Room floor2NorthWest = new Room ("You see a door in the hallway to your left with a yellow light coming out of it.");
        Room floor2NorthEast = new Room ("There's a sound almost like wind coming from a hall to your right.");
        Room floor2Hall = new Room ("Looking into the large room ahead of you, you see what looks like a turret."
        		+ "There is a hall to your left.");
        Room floor2Turret = new Room ("There's a large cannon you can see from the side of the bay window. There is"
        		+ " a chair surrounded by equitment that seems to be able to operate it.");
        Room floor2Bio = new Room ("You are surrounded by plants from all over the galaxy, and containers with some fruits"
        		+ " still left in them.");
        
        //floor 3
        Room elevatorExitF3 = new Room ("You see a hallway illuminated by a red light eminating from the end of the hall."
        		+ "You see the elevator on the other side of the gap in the floor.");
        Room hallway1F3 = new Room ("You can vaguely make out something standing next to the red light."
        		+ "There is a door next to you.");
        //ITEM
        Room hallway1DoorF3 = new Room ("Inside the room there are some strange looking plants growing in glass containers."
        		+ "Most of the containers are broken or shattered, but one is still intact.");
        Room hallway2F3 = new Room ("The red light seems to be coming from an panel in a room at the end of the hall."
        		+ "There is another hall next to you.");
        Room blackhall1 = new Room ("There are panels alongside the wall that seem to be measuring something.");
        Room blackhall2 = new Room ("There is a faint hum. Strangly, it seems to be coming from all around you.");
        Room blackhall3 = new Room ("In front of you is a large console and a pinkish swirling mass on the otherside of a very thick,"
        		+ "very broken piece of glass. Large pieces lie shattered on the ground. The hum is louder.");
        Room blackholeWarpdrive = new Room ("As you approach it the swirling mass, the hum grows louder and louder until"
        		+ "it begins to hurt. You feel the stange urge to reach your hand out...");
        Room hallway3F3 = new Room ("You see something flashing next to the red light on the panel. "
        		+ "The form isn't moving.");
        
        
        //space station end

         */
        
        currentRoom = blackHoleEntrance;
        
        over = false;
    }
    
    /**
     * Is this game over or not?
     */
    public boolean isOver() { return over; }

    /**
     * Move into a different current room.
     */
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    /**
     * Indicate that the game is now over.
     */
    public void finishGame() { over = true; }
    
}
