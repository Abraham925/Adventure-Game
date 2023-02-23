package game;

import java.util.HashMap;

/**
 * Room.java
 * 
 * Class to model a room in the game.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Room {
    HashMap<String, Room> directions = new HashMap<String, Room>();
    
    /**
     * A description of this room
     */
    private String description;
    
    private HashMap<String, Room> dir = new HashMap<String, Room>();

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description) { this.description = description; }
    	
    
    public Room getDir(String direction) {
		return dir.get(direction);
	}


	public void setDir(String direction, Room room) {
		dir.put(direction, room);
	}
	
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }    
	
}
