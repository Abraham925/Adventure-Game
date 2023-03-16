package game;

public class Crowbar implements item {
	
	private boolean possession;
	private String name;
	
	public Crowbar() {
		possession = false;
		name = "crowbar";
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
