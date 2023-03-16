package game;

public class PickUpItem implements Command {
	
	private item item;
	
	public PickUpItem(item item) {
		this.item = item;
	}

	public void run() {
		if(!item.getPossession()) {
			item.pickedUp();
			System.out.println("You picked up the " + item.name());
		}else {
			System.out.println("You already grabbed this item.");
		}
	}

}
