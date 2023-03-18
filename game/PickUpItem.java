package game;

public class PickUpItem implements Command {
	
	//used for picking up an item
	
	private Item item;
	
	public PickUpItem(Item item) {
		this.item = item;
	}

	public void run() {
		if(!item.getPossession()) { //player doesn't have item
			item.pickedUp();
			System.out.println("You picked up the " + item.name());
		}else { //player already has item
			System.out.println("You already grabbed this item.");
		}
	}

}
