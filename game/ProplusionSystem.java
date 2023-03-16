package game;

public class ProplusionSystem implements item {
	
	private boolean possession;
	private String name;
	private String desc;
	
	public ProplusionSystem() {
		desc = "a missing part: propulsion system";
		name = "Proplusion System";
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
