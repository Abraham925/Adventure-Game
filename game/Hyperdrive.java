package game;

public class Hyperdrive implements item{
	
	private boolean possession;
	private String name;
	
	public Hyperdrive() {
		possession = false;
		name = "Hyperdrive";
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
