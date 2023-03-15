package game;

public class Inventory implements Command {
	
	private Backpack inventory;
	
	public Inventory(Backpack inventory) {
		this.inventory = inventory;
	}

	public void run() {
		inventory.itemAcquired();
	}

}
