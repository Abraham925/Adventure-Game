package game;

public class RoomTie implements Interactable {
	
	private String name; //the name of the interactable
	private String echo; //text shown when interaction is made
	private Room unlockedRoom;
	private String newDescription;
	private String desc;
	
	public RoomTie(String echo, String name, Room unlockedRoom, String newDescription) {
		desc = "switch";
		this.echo = echo;
		this.name = name;
		this.unlockedRoom = unlockedRoom;
		this.newDescription = newDescription;
	}
	
	private boolean unlock = false;
	
	public void unlock() {
		unlock = true;
		unlockedRoom.setDescription(newDescription);
	}

	public boolean isUnlocked() {
		return unlock;
	}
	
	public String description() {
		return desc;
	}
	
	public String name() {
		return name;
	}
	
	public void interact() {
		unlock();
		System.out.println(echo);
	}

}
