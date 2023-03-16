package game;

public class Ladder implements item {
	
	private boolean possession;
	private String name;
	private String desc;
	
	public Ladder() {
		desc = "a ladder";
		name = "ladder";
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
