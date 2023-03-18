package game;

public class Backpack {
	private Item hyperdrive;
	private Item propulsionsystem;
	private Item guidancesystem;
	private Item gloves;
	private Item crowbar;
	private Item keycard;
	private Item ladder;
	
	public Backpack(Item hyperdrive, Item propulsionsystem, Item guidancesystem, Item gloves, Item crowbar, Item keycard, Item ladder) {
		this.hyperdrive = hyperdrive;
		this.propulsionsystem = propulsionsystem;
		this.guidancesystem = guidancesystem;
		this.gloves = gloves;
		this.crowbar = crowbar;
		this.keycard = keycard;
		this.ladder = ladder;
	}

	
	public void itemAcquired() { //Prints out all items in the current inventory
		System.out.println("Items in your inventory:");
		if(hyperdrive.getPossession()) {
			System.out.println("Hyperdrive");
		}
		if(propulsionsystem.getPossession()) {
			System.out.println("Propulsion System");
		}
		if(guidancesystem.getPossession()) {
			System.out.println("Guidance System");
		}
		if(gloves.getPossession()) {
			System.out.println("Gloves");
		}
		if(crowbar.getPossession()) {
			System.out.println("Crowbar");
		}
		if(keycard.getPossession()) {
			System.out.println("Keycard");
		}
		if(ladder.getPossession()) {
			System.out.println("Ladder");
		}
		System.out.println();

	}
	public boolean allItemsAcquired() {
		if(hyperdrive.getPossession()&&propulsionsystem.getPossession()&&guidancesystem.getPossession()) {
			return true;
		}
		return false;
		
	}
	
}
