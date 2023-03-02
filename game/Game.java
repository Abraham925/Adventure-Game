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
    	
    	
    	
    	Room Blackhole = new Room("You feel your lungs compressing. You have 15 seconds to find the wormhole.");
    	Room LightSource = new Room("Black holes don't have light. All you see is nothing.");
    	Room StarFragments = new Room("Surrounding you are fragments left behind by the collapse of an ancient giant star. You notice less fragments than when you first spotted them.");
    	Room Wormhole = new Room("The only escape from the black hole. There is a bright neutron star in the distance with some accompanying asteroid fragments.");
    	
    	Blackhole.setDir("light", LightSource);
    	LightSource.setDir("back", Blackhole);
    	Blackhole.setDir("distant fragments", StarFragments);
    	StarFragments.setDir("blackhole", Blackhole);
    	StarFragments.setDir("wormhole", Wormhole);
    	
    	//Rooms to be connected to worm hole
    	
    	
    	
    	/*
        Room frontRoom = new Room("Front Room");
        Room livingRoom = new Room("Living Room");
        Room kitchen = new Room("Kitchen");
        Room garage = new Room("Garage");
        Room secondFloor = new Room("Second Floor");
        Room bathroom = new Room("Bathroom");
        Room basement = new Room("Basement");
        Room bedroomOne = new Room("Bedroom 1st Floor");
        Room bedroomTwo = new Room("Bedroom 2nd Floor");
        
        frontRoom.setDir("north", kitchen);
        frontRoom.setDir("west", livingRoom);
        frontRoom.setDir("up", secondFloor);
        
        secondFloor.setDir("down", frontRoom);
        secondFloor.setDir("west", bathroom);
        secondFloor.setDir("east", bedroomTwo);
        
        bathroom.setDir("east", secondFloor);
        
        kitchen.setDir("south", frontRoom);
        kitchen.setDir("east", garage);
        
        garage.setDir("west", kitchen);
        
        livingRoom.setDir("down", basement);
        livingRoom.setDir("east", frontRoom);
        livingRoom.setDir("south", bedroomOne);
        
        basement.setDir("up", livingRoom);
        
        bedroomOne.setDir("north", livingRoom);
        bedroomTwo.setDir("west", secondFloor);
        
        //rooms[0].setNorth(rooms[1]);
        
        rooms[1].setSouth(rooms[0]);
        rooms[1].setEast(rooms[2]);
        rooms[2].setWest(rooms[1]);
        rooms[2].setSouth(rooms[3]);
        rooms[3].setNorth(rooms[2]);
        rooms[3].setWest(rooms[0]);
        rooms[0].setEast(rooms[3]);
        rooms[0].setAbove(rooms[4]);
        rooms[0].setBelow(rooms[5]);
        rooms[4].setBelow(rooms[0]);
        rooms[5].setAbove(rooms[0]);
        */
        
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
