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
	
    /**
     * A description of this room
     */
    private String description;
    
    /**
     * Holds the HashMap for a room, containing pairs of a direction and corresponding room
     */
    private HashMap<String, Room> dir = new HashMap<String, Room>();

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description) { 
    	this.description = description;
    }
    
    /**
     * @param the inputed direction
     * @return the room in that direction
     */
    public Room getDir(String direction) {
		return dir.get(direction);
	}

    /**
     * @param the direction and the room in that direction
     * @param a new room in that direction from the current room
     */
	public void setDir(String direction, Room room) {
		dir.put(direction, room);
	}
	
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
	
}
