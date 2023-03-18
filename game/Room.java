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
    
    private ArrayList<Item> items = new ArrayList<Item>(); //stores the item(s) in the room
    private ArrayList<Interactable> interactables = new ArrayList<Interactable>(); //stores the interactables in the room
    
    /**
     * adds an item to the room
     * @param item The item that is being added
     */
    public void addItem(Item item) {
    	items.add(item);
    }
    
    /**
     * adds an interactable to the room
     * @param inter The interactable that's being added to the room
     */
    public void addInteractable(Interactable inter) {
    	interactables.add(inter);
    }
    
    /**
     * Returns the list of items
     * @return The list of items
     */
    public ArrayList<Item> getItems(){
    	return items;
    }
    
    /**
     * Returns the list of interactables
     * @return The list of interactables
     */
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
    
    /**
     * Returns the directions map
     * @return The directions map
     */
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
	
	public void removeDir(String direction) {
		dir.remove(direction);
	}
	
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
    /**
     * Sets the descriptions to the description provided
     * @param description The new description for the room
     */
    public void setDescription(String description) { this.description = description; }
	
}
