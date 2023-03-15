package game;

import java.util.ArrayList;
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
    
    private ArrayList<item> items = new ArrayList<item>();
    private ArrayList<Interactable> interactables = new ArrayList<Interactable>();
    
    public void addItem(item item) {
    	items.add(item);
    }
    
    public void addInteractable(Interactable inter) {
    	interactables.add(inter);
    }
    
    public ArrayList<item> getItems(){
    	return items;
    }
    
    public ArrayList<Interactable> getInter(){
    	return interactables;
    }
    
    /**
     * Holds the HashMap for a room, containing pairs of a direction and corresponding exit door
     */
    private HashMap<String, Exit> dir = new HashMap<String, Exit>();

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description) { 
    	this.description = description;
    }
    
    /**
     * @param the inputed direction
     * @return the exit in that direction
     */
    public Exit getDir(String direction) {
		return dir.get(direction);
	}
    
    public HashMap<String, Exit> getDirMap(){
    	return dir;
    }

    /**
     * @param the direction and the exit in that direction
     * @param an exit in that direction from the current room
     */
	public void setDir(String direction, Exit exit) {
		dir.put(direction, exit);
	}
	
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
	
}
