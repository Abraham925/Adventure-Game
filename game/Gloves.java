package game;

public class Gloves implements item {
	
	private boolean possession;
	private String name;
	
	public Gloves() {
		possession = true;
		name = "gloves";
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
