package game;

public class Ladder implements item {
	
	private boolean possession;
	private String name;
	
	public Ladder() {
		possession = false;
		name = "Ladder";
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
