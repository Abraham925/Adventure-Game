package game;

public class GuidanceSystem implements Item {
	
	private boolean possession;
	private String name;
	private String desc;
	
	public GuidanceSystem() {
		desc = "a missing part: guidance system";
		name = "Guidance System";
		possession = false;
	}
	
	public String description() {
		return desc;
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
