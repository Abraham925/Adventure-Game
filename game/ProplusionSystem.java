package game;

public class ProplusionSystem extends Backpack implements item {
	
	private boolean posession;
	private String name;
	
	public ProplusionSystem() {
		posession = false;
		name = "Proplusion System";
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
