package game;

public class Keycard implements item {
	
	private boolean possession;
	private String name;
	
	public Keycard() {
		possession = false;
		name = "Keycard";
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
