package game;

public class Backpack {
	private item hyperdrive;
	private item proplusionsystem;
	private item guidancesystem;
	private item gloves;
	private item crowbar;
	private item keycard;
	private item ladder;





	
	public Backpack() {
		this.hyperdrive = hyperdrive;
		this.proplusionsystem = proplusionsystem;
		this.guidancesystem = guidancesystem;
		this.gloves = gloves;
		this.crowbar = crowbar;
		this.keycard = keycard;
		this.ladder = ladder;
		
	}
	
	public void itemAcquired() {
		System.out.println("Items in your inventory:");
		if(hyperdrive.getPosession()) {
			System.out.println("Hyperdrive");
		}
		if(proplusionsystem.getPosession()) {
			System.out.println("Proplusion System");
		}
		if(guidancesystem.getPosession()) {
			System.out.println("Guidance System");
		}
		if(gloves.getPosession()) {
			System.out.println("Gloves");
		}
		if(crowbar.getPosession()) {
			System.out.println("Crowbar");
		}
		if(keycard.getPosession()) {
			System.out.println("Keycard");
		}
		if(ladder.getPosession()) {
			System.out.println("Ladder");
		}
		

	}
	public boolean allItemsAcquired() {
		if(hyperdrive.getPosession()&&proplusionsystem.getPosession()&&guidancesystem.getPosession()) {
			return true;
		}
		return false;
		
	}
	
}
