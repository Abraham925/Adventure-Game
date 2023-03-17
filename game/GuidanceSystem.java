package game;

public class GuidanceSystem implements Item {
	
	private boolean possession;
	private String name;
	private String desc;
	private Room room;
	
	public GuidanceSystem() {
		desc = "a missing part: guidance system";
		name = "Guidance System";
		possession = false;
	}
	
	public void setRoom(Room room) {
		this.room = room;
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
		room.setDescription("In front of you is a large, flat screen that seems to be showing the galaxy"
        		+ " the station is in.\n There's a flashing icon that says \"ANOMALY DETECTED\" next to a large red dot illuminated on the screen.");
	}


	@Override
	public boolean getPossession() {
		return possession;
	}







}
