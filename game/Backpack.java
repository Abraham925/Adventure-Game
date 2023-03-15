package game;

public class Backpack {
	private boolean hyperdrive;
	private boolean proplusionsystem;
	private boolean guidancesystem;
	private boolean gloves;
	private boolean crowbar;
	private boolean keycard;
	private boolean ladder;




	
	public Backpack() {
		hyperdrive = false;
		proplusionsystem = false;
		guidancesystem = false;
		gloves = false;
		crowbar = false;
		keycard = false;
		ladder = false;
	}
	
	public void itemAcquired(String x) {
		switch(x) {
			case("Hyperdive"): hyperdrive = true; break;
			case("Proplusion System"): proplusionsystem = true; break;
			case("Guidance System"): guidancesystem = true; break;
			case("gloves"): gloves = true; break;
			case("crowbar"): gloves = true; break;
			case("keycard"): gloves = true; break;
			case("ladder"): gloves = true; break;
			
		}

	}
	public boolean allItemsAcquired() {
		if(hyperdrive&&proplusionsystem&&guidancesystem) {
			return true;
		}
		return false;
		
	}
	
}
