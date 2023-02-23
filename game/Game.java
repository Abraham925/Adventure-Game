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
        
        over = false;
        currentRoom = frontRoom;
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
