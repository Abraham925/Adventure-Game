package game;

public class Ladder implements Item {
	
	private boolean possession;
	private String name;
	private String desc;
	private Room room; //used to change room description
	
	public Ladder() {
		desc = "a ladder";
		name = "ladder";
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
		room.setDescription("You are surrounded by plants from all over the galaxy, and containers with some fruits"
        		+ " still left in them.");
	}

	@Override
	public boolean getPossession() {
		return possession;
	}



}
