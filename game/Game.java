package game;

import java.util.HashMap;

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
    	
    	Room Blackhole = new Room("Center of the black hole. You feel your lungs compressing. You have 30 seconds to find the wormhole.");
    	Room LightSource = new Room("Black holes don't have light. All you see is nothing.");
    	Room StarFragments = new Room("Surrounding you are fragments left behind by the collapse of an ancient giant star. You notice less fragments than when you first spotted them.");
    	Room SpaceTear = new Room("It appears to be a tear in space, I wouldn't want to go near that...");
    	Room WarpedDebris = new Room("The debris that was once here has been completely warped in size and color, emitting a somewhat dark shade of brown. From the outside, only sometimes is it visible.");
    	Room Wormhole = new Room("The only escape from the black hole. There is a bright neutron star in the distance with some accompanying asteroid fragments.");
    	Room NeutronStar = new Room("Known to be very hot but a beautiful blue, this star is older than the others by far. It is on the far side of a system by the name HP 50329Z. Planets ASCR407 and Vydol can be seen in the distance.");
    	
    	Blackhole.setDir("light", LightSource);
    	LightSource.setDir("back", Blackhole);
    	Blackhole.setDir("distant fragments", StarFragments);
    	StarFragments.setDir("blackhole", Blackhole);
    	Blackhole.setDir("space tear", SpaceTear);
    	SpaceTear.setDir("blackhole", Blackhole);
    	SpaceTear.setDir("debris", WarpedDebris);
    	WarpedDebris.setDir("space tear", SpaceTear);
    	WarpedDebris.setDir("distant fragments", StarFragments);
    	

    	StarFragments.setDir("wormhole", Wormhole); //room to be unlocked
    	    	
    	//Rooms to be connected to worm hole
    	Wormhole.setDir("star", NeutronStar);
    	

        
        over = false;
        currentRoom = Blackhole;
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
