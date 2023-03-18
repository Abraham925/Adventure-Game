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
        
        //All the items to be found in the game, created at the start so
        //that inventory can have all the items with their possession booleans
        //set to false
    	private Hyperdrive hyperdrive = new Hyperdrive();
    	private PropulsionSystem propulsionsystem = new PropulsionSystem();
    	private GuidanceSystem guidancesystem = new GuidanceSystem();
    	private Gloves gloves = new Gloves();
    	private Crowbar crowbar = new Crowbar();
    	private Keycard keycard = new Keycard(); 
    	private Ladder ladder = new Ladder();
    	
    	//private Chest blackholeChest = new Chest(null, crowbar, "chest", "The abscence of sound is the most shocking.");
    	
    	//inventory starts with every item, however their possession booleans are
    	//set to false meaning inventory starts empty
        private Backpack inventory = new Backpack(hyperdrive, propulsionsystem, guidancesystem, gloves, crowbar, keycard, ladder);
        
        /**
         * Return the room in which the user is currently.
         */
        public Room getCurrentRoom() { return currentRoom; }
        
        /**
         * @return the user's current inventory
         */
        public Backpack getInventory() { return inventory; }
        
        
        /**
         * Constructor to set up the game.Y
         */
        public Game() {        
        Room blackHoleEntrance = new Room("Seems impossibly dark in that direction...");
        //blackHoleEntrance.addItem(gloves);
        Chest blackholeChest = new Chest(null, crowbar, "chest", "The abscence of sound is the most shocking.");
        blackHoleEntrance.addItem(crowbar);
        blackHoleEntrance.addItem(ladder);
        blackHoleEntrance.addInteractable(blackholeChest);
        
        //RoomTie lever = new RoomTie("You feel the ground shake and hear a high pitched screech from far away.", "lever");
    	
    	//RoomTie button = new RoomTie("Doorway Unlocked.", "button");
        
        //blackHoleEntrance.addInteractable(lever);
        //blackHoleEntrance.addInteractable(button);
        
        //black hole start
    	Room Blackhole = new Room("Center of the black hole. You feel your lungs compressing. You have 10 turns to find the wormhole.");
    	Room LightSource = new Room("Black holes don't have light. All you see is nothing.");
    	Room StarFragments = new Room("Surrounding you are fragments left behind by the collapse of an ancient giant star. You notice less fragments than when you first spotted them.");
    	
    	Room SpaceTear = new Room("It appears to be a tear in space, I wouldn't want to go near that...");
    	RoomTie debris = new RoomTie("debris", "move", "The debris was pushed to the sides, making a clear opening in that direction. ", null, null);
    	SpaceTear.addInteractable(debris);
    	
    	Room WarpedDebris = new Room("The debris that was once here has been completely warped in size and color, emitting a somewhat dark shade of brown. From the outside, only sometimes is it visible.");
    	Chest smallDebris = new Chest(null, null, "small debris", "These rocks are too small to be anything useful.");
    	WarpedDebris.addInteractable(smallDebris);
    	Chest coloredDebris = new Chest(null, propulsionsystem, "colored debris", "One of the colored rocks turned out to be a device of some sort.");
    	WarpedDebris.addInteractable(coloredDebris);
    	Chest hiddenDebris = new Chest(null, null, "hidden debris", "Some debris hidden behind the large debris didn't satisfy your search.");
    	WarpedDebris.addInteractable(hiddenDebris);
    	Chest largeDebris = new Chest(null, null, "large debris", "Though very large, there exists nothings within the gaps.");
    	WarpedDebris.addInteractable(largeDebris);
    	
    	Room Wormhole = new Room("The only escape from the black hole. There is a bright neutron star in the distance with some accompanying asteroid fragments.");
    	Room NeutronStar = new Room("Known to be very hot but a beautiful blue, this star is older than the others by far. It is on the far side of a system by the name HP 50329Z. Planets ASCR407 and Vydol can be seen in the distance.");
    	
    	
    	
    	blackHoleEntrance.setDir("darkness", new NormalExit(this, Blackhole));
    	Blackhole.setDir("light", new UnstableExit(this, LightSource, "This route seemed to only work once before fading away, what a shame."));
    	LightSource.setDir("back", new NormalExit(this, Blackhole));
    	Blackhole.setDir("distant fragments", new NormalExit(this, StarFragments));
    	StarFragments.setDir("blackhole", new NormalExit(this, Blackhole));
    	Blackhole.setDir("space tear", new NormalExit(this, SpaceTear));
    	SpaceTear.setDir("blackhole", new NormalExit(this, Blackhole));
    	SpaceTear.setDir("debris", new LockedExit(this, WarpedDebris, null, debris, "Through the debris you find a seemingly scientifically impossible event. "));
    	WarpedDebris.setDir("space tear", new NormalExit(this, SpaceTear));
    	WarpedDebris.setDir("distant fragments", new NormalExit(this, StarFragments));
    	
    	

    	StarFragments.setDir("wormhole", new NormalExit(this, Wormhole)); //room to be unlocked
    	    	
    	//Rooms to be connected to worm hole
    	Wormhole.setDir("star", new NormalExit(this, NeutronStar));
    	
    	
        
        
    	
        
        //black hole end
        
         
        //space station begin
        Room hangar = new Room("You find yourself in a large landing bay. Something seems off. To your left is a door that say MAINTINANCE."
        		+ " In front of you is an open door");
        Room maintenance = new Room("You find yourself in a small room with scattered tools and parts. Something is sparking.");
        
        Room hallwayEntrance = new Room("You are in a hallway. In the darkness a light flickers off to your right.");
        //setting up hangar and maintenance
        hangar.setDir("room", new LockedExit(this, maintenance, keycard, null, "The door slowly grinds open"));
        hangar.setDir("hallway", new NormalExit(this, hallwayEntrance));
        maintenance.setDir("exit", new NormalExit(this, hangar));
        //vents
        Room hallwaySouthWest = new Room("To your right is another hallway. Something is dripping from a vent above you. You can't reach it; you're short.");
        Room ventSouthWest = new Room("Everything is dark. Whatever was dripping is covering the walls of the vent. It smells like iron.");
        Room ventNorthWest = new Room("Everything is dark. You see a pair of glowing eyes far to the right. You don't think it sees you... yet...");
        Room ventSouthEast = new Room("There is a light flickering outside the vent. You hear something in the vent ahead.");
        Room ventNorthEast = new Room("You see two massive green eyes looming over you. Blood drips from the creatures' mouth."
        		+ " All of a sudden it screeches and lunges at you.");
        Room ventMonsterChase = new Room("You crawl as fast as you can. The banging and screeching behind you grows louder.");
        Room ventChaseEscape = new Room(" The vent caves and you fall through the grate into a room with a flickering light.");
        hallwaySouthWest.setDir("vent", new LockedExit(this, ventSouthWest, ladder, null, "You got up there! You're still short."));
        
        ventSouthWest.setDir("jump down", new NormalExit(this, hallwaySouthWest));
        ventSouthWest.setDir("left", new NormalExit(this, ventNorthWest));
        ventSouthWest.setDir("right", new NormalExit(this, ventSouthEast));
        
        ventSouthEast.setDir("left", new NormalExit(this, ventSouthWest));
        ventSouthEast.setDir("right", new NormalExit(this, ventNorthEast));
        
        ventNorthWest.setDir("left", new NormalExit(this, ventNorthEast));
        ventNorthWest.setDir("right", new NormalExit(this, ventSouthWest));
        
        ventNorthEast.setDir("RUN", new NormalExit(this, ventMonsterChase));
        ventMonsterChase.setDir("RUN", new NormalExit(this, ventChaseEscape));
        ventMonsterChase.setDir("fall", new NormalExit(this, hallwayEntrance));
        //first floor hallway
        Room hallwaySouth = new Room("You are in a dark hallway. You see the familiar light of the hangar to your left."
        		+ " You hear a dull clang. There is a flickering light to your right."
        		+ " There is a room in front of labeled CARGO BAY");
        Room hallwaySouthEast = new Room("To your right is a hallway where you see a door that looks like it has been thrown off its hinges deeper."
        		+ " A light flickers through the gaping doorway. The noises grow louder.");
        Room hallwayEastSouth = new Room("A lone light in the otherwise dark room ahead of you flickers. You see blood."
        		+ " You can here a loud bang coming from a vent grate to your right.");
        Room hallwayNorthEast = new Room("The banging has stopped. There is a vent above you. You are being watched...");
        Room hallwayNorth = new Room("There is an elevator. By some miricale it seems to be working. There is a loud bang that came from a vent to your left.");
        Room hallwayNorthWest = new Room("There is what looks to be an elevator to your left. To your right you see something dripping from the ceiling."
        		+ " Something echos through the vents.");
        Room hallwayWest = new Room("There is something dripping off to your right. There is a room in front of you. It is all black. You feel sick.");
        
        hallwayEntrance.setDir("hangar", new NormalExit(this, hangar));
        hallwayEntrance.setDir("left", new NormalExit(this, hallwaySouthWest));
        hallwayEntrance.setDir("right", new NormalExit(this, hallwaySouth));
        
        hallwaySouth.setDir("left", new NormalExit(this, hallwayEntrance));
        hallwaySouth.setDir("right", new NormalExit(this, hallwaySouthEast));
        
        hallwaySouthEast.setDir("left", new NormalExit(this, hallwaySouth));
        hallwaySouthEast.setDir("right", new NormalExit(this, hallwayEastSouth));
        
        hallwayEastSouth.setDir("left", new NormalExit(this, hallwaySouth));
        hallwayEastSouth.setDir("right", new NormalExit(this, hallwayNorthEast));
        
        hallwayNorthEast.setDir("left", new NormalExit(this, hallwayEastSouth));
        hallwayNorthEast.setDir("right", new NormalExit(this, hallwayNorth));
        
        hallwayNorth.setDir("left", new NormalExit(this, hallwayNorthEast));
        hallwayNorth.setDir("right", new NormalExit(this, hallwayNorthWest));
        
        hallwayNorthWest.setDir("left", new NormalExit(this, hallwayNorth));
        hallwayNorthWest.setDir("right", new NormalExit(this, hallwayWest));
        hallwayNorthWest.addItem(gloves);
        
        hallwaySouthWest.setDir("left", new NormalExit(this, hallwayWest));
        hallwaySouthWest.setDir("right", new NormalExit(this, hallwaySouth));
        //first floor rooms and elevator
        Room elevatorFloor1 = new Room("Theres a panel with the numbers 1-4. There are scratch marks on the wall."
        		+ " You feel the elevator shake a little when you step on.");
        Room elevatorFloor2 = new Room("You see a bay window in the distance. Compared to the destruction bellow, this floor seems eerily calm...");
        Room elevatorFloor3 = new Room("The floor just outside the elevator is all gone."
        		+ " You see a black form on the rubble below. You'll have to jump if you want to make it across.");
        Room elevatorFloor4= new Room("You see what looks like a command room. Out of the bay window you can see the stars.");
        
        Room cargoBay = new Room("You look around and see scattered boxes with belongings scattered across the ground. Can any of it be useful?");
        Chest cargo = new Chest(crowbar, hyperdrive, "Cargo Chest", "The lid of the cargo box rips open. The nails scatter across the floor."
        		+ "\n You found the HYPERDRIVE! This will be useful in reassembling the spaceship.");
        cargoBay.addInteractable(cargo);
        
        Room flickeringLight = new Room("You are in what seem to be baraks. Scratches mark the walls. You see a figure coughing.");
        
        elevatorFloor1.setDir("back", new NormalExit(this, hallwayNorth));
        elevatorFloor1.setDir("2", new NormalExit(this, elevatorFloor2));
        elevatorFloor1.setDir("3", new NormalExit(this, elevatorFloor3));
        elevatorFloor1.setDir("4", new NormalExit(this, elevatorFloor4));
        
        elevatorFloor2.setDir("1", new NormalExit(this, elevatorFloor1));
        elevatorFloor2.setDir("3", new NormalExit(this, elevatorFloor3));
        elevatorFloor2.setDir("4", new NormalExit(this, elevatorFloor4));
        
        elevatorFloor3.setDir("1", new NormalExit(this, elevatorFloor1));
        elevatorFloor3.setDir("2", new NormalExit(this, elevatorFloor2));
        elevatorFloor3.setDir("4", new NormalExit(this, elevatorFloor4));
        
        elevatorFloor4.setDir("1", new NormalExit(this, elevatorFloor1));
        elevatorFloor4.setDir("2", new NormalExit(this, elevatorFloor2));
        elevatorFloor4.setDir("3", new NormalExit(this, elevatorFloor3));
        
        hallwayNorth.setDir("elevator", new NormalExit(this, elevatorFloor1));
        hallwaySouth.setDir("cargo", new NormalExit(this, cargoBay));
        hallwayEastSouth.setDir("light", new NormalExit(this, flickeringLight));
        cargoBay.setDir("back", new NormalExit(this, hallwaySouth));
        flickeringLight.setDir("back", new NormalExit(this, hallwayEastSouth));
        
        //basement
        Room basementCollapse = new Room ("Around you is a labryth of pipes and machines, the inner workings of the ship."
        		+ " The hallway above you is too far to get back up to.");
        hallwayWest.setDir("left", new UnstableExit(this, hallwayNorthWest, hallwayNorthWest, hallwaySouthWest, "left",
        		"right", "jump", "jump", basementCollapse, "You here a creaking sound then suddenly the hall to your right"
        				+ " collapses into a pile of rubble. You peer down and see some pipes by the rubble, "
        				+ "maybe a part of another floor on the ship..."));
        hallwayWest.setDir("right", new UnstableExit(this, hallwaySouthWest, hallwayNorthWest, hallwaySouthWest, "left",
        		"right", "jump", "jump", basementCollapse, "You here a creaking sound then suddenly the hall to your left"
        				+ " collapses into a pile of rubble. You peer down and see some pipes by the rubble, "
        				+ "maybe a part of another floor on the ship..."));
        Room basementTopRight = new Room ("There is a flashing button labeled HANGAR on the wall."
        		+ "There is what looks like a boiler next to you.");
        		//add item for part of the ship
        Room basementBottomRight = new Room ("You find a massive machine reaching up into the center of the ship."
        		+ " All the pipes around you seem to be leading into it.");
        Room basementBottomLeft = new Room ("There are some slabs slightly protruding from the wall, just barely enough to see."
        		+ " They seem to lead to a trapdoor.");
        
        RoomTie hangarButton = new RoomTie("button", "push", "You hear something rumbling to your left...", basementBottomLeft, 
        		"You see the slabs jutting out of the wall, with an open door at the top of the stair.");
        basementTopRight.addInteractable(hangarButton);
        //basementBottomRight.addItem(propulsionsystem);

        
        basementCollapse.setDir("left", new NormalExit(this, basementBottomLeft));
        basementCollapse.setDir("right", new NormalExit(this, basementTopRight));
        
        basementBottomLeft.setDir("left", new NormalExit(this, basementBottomRight));
        basementBottomLeft.setDir("right", new NormalExit(this, basementCollapse));
        basementBottomLeft.setDir("up", new LockedExit(this, hangar, null, hangarButton, null));
        basementBottomLeft.addItem(crowbar);

        
        basementBottomRight.setDir("left", new NormalExit(this, basementTopRight));
        basementBottomRight.setDir("right", new NormalExit(this, basementBottomLeft));
        
        basementTopRight.setDir("left", new NormalExit(this, basementCollapse));
        basementTopRight.setDir("right", new NormalExit(this, basementBottomRight));
        
        //floor 2
        Room floor2Entrance = new Room ("Ahead of you you see a large bay window and some equipment.");
        Room floor2SouthEast = new Room ("There's a sound almost like wind coming from a hall to your left.");
        Room floor2SouthWest = new Room ("You see a door in the hallway to your left with a yellow light coming out of it.");
        Room floor2West = new Room ("Through the blurry door of the door you see something green");
        Room floor2NorthWest = new Room ("You see a door in the hallway to your left with a yellow light coming out of it.");
        Room floor2NorthEast = new Room ("There's a sound almost like wind coming from a hall to your right.");
        Room floor2Hall = new Room ("Looking into the large room ahead of you, you see what looks like a turret."
        		+ " There is a hall to your left.");
        Room floor2Turret = new Room ("There's a large cannon you can see from the side of the bay window. There is"
        		+ " a chair surrounded by equitment that seems to be able to operate it.");
        Room floor2Bio = new Room ("You are surrounded by plants from all over the galaxy, and containers with some fruits"
        		+ " still left in them. Theres a ladder sitting in a corner.");
        
        elevatorFloor2.setDir("forward", new NormalExit(this, floor2Entrance));
        
        floor2Entrance.setDir("forward", new NormalExit(this, floor2SouthEast));
        floor2Entrance.setDir("back", new NormalExit(this, elevatorFloor2));
        
        floor2SouthEast.setDir("forward", new NormalExit(this, floor2NorthEast));
        floor2SouthEast.setDir("left", new NormalExit(this, floor2SouthWest));
        floor2SouthEast.setDir("back", new NormalExit(this, floor2Entrance));
        
        floor2NorthEast.setDir("forward", new NormalExit(this, floor2Hall));
        floor2NorthEast.setDir("left", new NormalExit(this, floor2NorthWest));
        floor2NorthEast.setDir("back", new NormalExit(this, floor2SouthEast));
        
        floor2Hall.setDir("forward", new NormalExit(this, floor2Turret));
        floor2Hall.setDir("back", new NormalExit(this, floor2NorthEast));
        	//MAKE INTERACTABLE OR MAYBE ITEM
        floor2Turret.setDir("back", new NormalExit(this, floor2Hall));
        
        floor2SouthWest.setDir("forward", new NormalExit(this, floor2West));
        floor2SouthWest.setDir("right", new NormalExit(this, floor2SouthEast));
        
        floor2West.setDir("forward", new NormalExit(this, floor2NorthWest));
        floor2West.setDir("door", new NormalExit(this, floor2Bio));
        floor2West.setDir("back", new NormalExit(this, floor2SouthWest));
        
        floor2Bio.setDir("back", new NormalExit(this, floor2West));    
        ladder.setRoom(floor2Bio);
        floor2Bio.addItem(ladder);
        
        floor2NorthWest.setDir("right", new NormalExit(this, floor2NorthEast));
        floor2NorthWest.setDir("back", new NormalExit(this, floor2West));
        
        //floor 3
        Room elevatorExitF3 = new Room ("You see a hallway illuminated by a red light eminating from the end of the hall."
        		+ "You see the elevator on the other side of the gap in the floor.");
        Room hallway1F3 = new Room ("You can vaguely make out something standing next to the red light."
        		+ "There is a door next to you.");
        	//ITEM
        Room hallway1DoorF3 = new Room ("Inside the room there are some strange looking plants growing in glass containers."
        		+ " Most of the containers are broken or shattered, but one is still intact.");
        Room hallway2F3 = new Room ("The red light seems to be coming from an panel in a room at the end of the hall."
        		+ " There is another hall next to you.");
        Room blackhall1 = new Room ("There are panels alongside the wall that seem to be measuring something.");
        Room blackhall2 = new Room ("There is a faint hum. Strangly, it seems to be coming from all around you.");
        Room blackhall3 = new Room ("In front of you is a large console and a pinkish swirling mass on the otherside of a very thick,"
        		+ " very broken piece of glass. Large pieces lie shattered on the ground. The hum is louder.");
        Room blackholeWarpdrive = new Room ("As you approach it the swirling mass, the hum grows louder and louder until"
        		+ " it begins to hurt. You feel the stange urge to reach your hand out...");
        Room hallway3F3 = new Room ("You see something flashing next to the red light on the panel."
        		+ " The form isn't moving.");
        Room maproomF3 = new Room ("In front of you is a large, flat screen that seems to be showing the galaxy"
        		+ " the station is in.\n There's a flashing icon that says \"ANOMALY DETECTED\" next to a large red dot illuminated on the screen."
        		+ "There is a console that looks like some sort of guidance system...");
        maproomF3.addItem(guidancesystem);
        elevatorFloor3.setDir("forward", new NormalExit(this, elevatorExitF3));
        
        elevatorExitF3.setDir("forward", new NormalExit(this, hallway1F3));
        elevatorExitF3.setDir("back", new NormalExit(this, elevatorFloor3));
        
        hallway1F3.setDir("forward", new NormalExit(this, hallway2F3));	
        hallway1F3.setDir("back", new NormalExit(this, elevatorExitF3));	
        hallway1F3.setDir("door", new NormalExit(this, hallway1DoorF3));
        hallway1DoorF3.setDir("back", new NormalExit(this, hallway1F3));
        
        hallway2F3.setDir("forward", new NormalExit(this, hallway3F3));
        hallway2F3.setDir("back", new NormalExit(this, hallway1F3));	
        hallway2F3.setDir("right", new NormalExit(this, blackhall1));	
        
        hallway3F3.setDir("forward", new NormalExit(this, maproomF3));
        hallway3F3.setDir("back", new NormalExit(this, hallway2F3));

        
        	//MAKE INTERACTION WITH MAP!!
        maproomF3.setDir("back", new NormalExit(this, hallway3F3));
        
        blackhall1.setDir("right", new NormalExit(this, blackhall2));	
        blackhall1.setDir("left", new NormalExit(this, hallway2F3));	
        
        blackhall2.setDir("right", new NormalExit(this, blackhall3));	
        blackhall2.setDir("left", new NormalExit(this, blackhall1));
        
        blackhall3.setDir("one", new NormalExit(this, blackholeWarpdrive));	
        blackhall3.setDir("two", new NormalExit(this, blackhall2));
        
        blackholeWarpdrive.setDir("forward", new NormalExit(this, Blackhole));
        blackholeWarpdrive.setDir("backward", new LockedExit(this, Blackhole, null, null, null));
        	//do I make there be no option to turn back??
        //blackholeWarpdrive.setDir("back", new NormalExit(this, blackhall3));
        
        //floor 4
        	//INTERACTION WITH CAPTAIN AND ITEM (INTERACTION WITH OTHER EQUITMENT IN ROOM?)
        Room commandCenter = new Room ("You see a large window looking into the vast depth of space. There is someone "
        		+ "on the ground in a white uniform bleeding with his hand over his heart.\n You look at the many consoles"
        		+ " and equitment and assess you are in the command center.");

        Chest captain = new Chest(keycard, gloves, "Captain", "You search the captain, his blood stains the gloves."
        		+ "\nYou found a Keycard. Seems like it opens a room of some sort.");
        commandCenter.addInteractable(captain);
        
        elevatorFloor4.setDir("forward", new NormalExit(this, commandCenter));
        commandCenter.setDir("back", new NormalExit(this, elevatorFloor4));
        //space station end

        
        //currentRoom = blackHoleEntrance;
        currentRoom = hangar;

        
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
