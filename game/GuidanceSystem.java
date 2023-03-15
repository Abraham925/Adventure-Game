package game;

public class GuidanceSystem extends Backpack implements item {
	
	private boolean posession;
	private String name;
	
	public GuidanceSystem() {
		posession = false;
		name = "Guidance System";
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
