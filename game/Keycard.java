package game;

public class Keycard implements Item {
	
	private boolean possession;
	private String name;
	private String desc;
	
	public Keycard() {
		desc = "a keycard";
		name = "keycard";
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
