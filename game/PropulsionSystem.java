package game;

public class PropulsionSystem implements Item {
	
	//One of three necessary parts to complete the game
	
	private boolean possession;
	private String name;
	private String desc;
	
	public PropulsionSystem() {
		desc = "a missing part: propulsion system";
		name = "Propulsion System";
		possession = false;
	}
	
	public String description() {
		return desc;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public void pickedUp() {
		possession = true;

	}


	@Override
	public boolean getPossession() {
		return possession;
	}




}
