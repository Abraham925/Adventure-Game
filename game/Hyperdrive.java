package game;

public class Hyperdrive extends Backpack implements item{
	
	private boolean posession;
	private String name;
	
	public Hyperdrive() {
		posession = false;
		name = "Hyperdrive";
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
