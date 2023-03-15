package game;

public class Keycard extends Backpack implements item {
	
	private boolean posession;
	private String name;
	
	public Keycard() {
		posession = false;
		name = "Keycard";
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
