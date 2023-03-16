package game;

public class Backpack {
	private item hyperdrive;
	private item proplusionsystem;
	private item guidancesystem;
	private item gloves;
	private item crowbar;
	private item keycard;
	private item ladder;

	
	public void itemAcquired() {
		System.out.println("Items in your inventory:");
		if(hyperdrive.getPossession()) {
			System.out.println("Hyperdrive");
		}
		if(proplusionsystem.getPossession()) {
			System.out.println("Proplusion System");
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
		

	}
	public boolean allItemsAcquired() {
		if(hyperdrive.getPossession()&&proplusionsystem.getPossession()&&guidancesystem.getPossession()) {
			return true;
		}
		return false;
		
	}
	
}
