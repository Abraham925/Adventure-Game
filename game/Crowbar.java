package game;

public class Crowbar extends Backpack implements item {
	
	private boolean posession;
	private String name;
	
	public Crowbar() {
		posession = false;
		name = "Crowbar";
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
