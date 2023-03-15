package game;

public class Gloves extends Backpack implements item {
	
	private boolean posession;
	private String name;
	
	public Gloves() {
		posession = false;
		name = "Gloves";
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
