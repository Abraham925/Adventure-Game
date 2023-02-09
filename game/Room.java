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
    
    //utilize get(key) and put(key, value)
    HashMap<String, Room> directions = new HashMap<String, Room>();
    
    
    public void setDirection(String directionName, Room leadingTo) {
    	directions.put(directionName, leadingTo);
    }
    
    public Room getDirection(String directionName) {
    	return directions.get(directionName);
    }
       
    /**
     * A description of this room
     */
    private String description;

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description) { this.description = description; }
    	
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }

    
    
    

	
}
