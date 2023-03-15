package game;

public class Ladder extends Backpack implements item {
	
	private boolean posession;
	private String name;
	
	public Ladder() {
		posession = false;
		name = "Ladder";
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public void pickedUp() {
		posession = true;
		itemAcquired(name);

	}



	@Override
	public boolean getPosession() {
		return posession;
	}



}
