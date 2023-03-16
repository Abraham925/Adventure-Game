package game;

public class Crowbar implements item {
	
	private boolean possession;
	private String name;
	private String desc;
	
	public Crowbar() {
		desc = "a crowbar";
		name = "crowbar";
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
