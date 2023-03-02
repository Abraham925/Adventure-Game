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
    	//starting world drop
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
        
        Room swirlingMassEntrance = new Room("Bathroom");
        Room redSunEntrance = new Room("Basement");
        Room deathShipEntrance = new Room("Bedroom 1st Floor");
        Room blackHoleEntrance = new Room("Bedroom 2nd Floor");
    	//starting world end
        
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
        
        hallwayEntrance.setDir("HANGAR", hangar);
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
        
        
        //space station end
        currentRoom = hangar;
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
