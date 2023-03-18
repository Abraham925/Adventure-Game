package game;

public class Inventory implements Command {
	
	//prints out items in current inventory
	
	private Backpack inventory;
	
	public Inventory(Backpack inventory) {
		this.inventory = inventory;
	}

	public void run() {
		inventory.itemAcquired();
	}

}
