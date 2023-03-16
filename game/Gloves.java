package game;

public class Gloves implements item {
	
	private boolean possession;
	private String name;
	private String desc;
	
	public Gloves() {
		desc = "a pair of gloves";
		name = "gloves";
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
