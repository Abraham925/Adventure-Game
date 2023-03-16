package game;

public class GuidanceSystem implements item {
	
	private boolean possession;
	private String name;
	
	public GuidanceSystem() {
		possession = false;
		name = "Guidance System";
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
