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
     * Rooms adjacent to this one, to which there is a door.
     */
    //private Room north, south, east, west, above, below;

    /**
     * A description of this room
     */
    private String description;
    
    private HashMap<String, Room> dir = new HashMap<String, Room>();

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description) { 
    		this.description = description;
    	}
    
    
    /**
     * Methods for added "doors"-- directional connections to other rooms.
     */
    //public void setNorth(Room north) { this.north = north; }
    //public void setSouth(Room south) { this.south = south; }
    //public void setEast(Room east) { this.east = east; }
    //public void setWest(Room west) { this.west = west; }
    
    public Room getDir(String direction) {
		return dir.get(direction);
	}


	public void setDir(String direction, Room room) {
		dir.put(direction, room);
	}


	/**
     * Methods for added means if getting into above or below rooms.
     */
    //public void setAbove(Room above) { this.above = above; }
    //public void setBelow(Room below) { this.below = below; }
	
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
    /**
     * Methods to determine the rooms to which various
     * doors-- if they exist-- lead.
     */
    //public Room getNorth() { return north; }
    //public Room getSouth() { return south; }
    //public Room getEast() { return east; }
    //public Room getWest() { return west; }
    
    /**
     * Adds the ability to retrieve the above and below room, if there is any
     */
    //public Room getAbove() { return above; }
    //public Room getBelow() { return below; }
    

	
}
