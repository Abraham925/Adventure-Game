package game;

public class ProplusionSystem implements item {
	
	private boolean possession;
	private String name;
	
	public ProplusionSystem() {
		possession = false;
		name = "Proplusion System";
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
