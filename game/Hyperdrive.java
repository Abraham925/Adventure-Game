package game;

public class Hyperdrive implements item{
	
	private boolean possession;
	private String name;
	private String desc;
	
	public Hyperdrive() {
		desc = "a missing part: hyperdrive";
		name = "Hyperdrive";
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
