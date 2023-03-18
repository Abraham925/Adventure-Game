package game;

public interface Item {
	
	//interface for all items
	
	public String name(); //returns printable name of item
	
	public void pickedUp(); //sets possession boolean to true when called
	
	public boolean getPossession(); //returns possession state
	
	public String description(); //returns item description for proper grammar
	
}



