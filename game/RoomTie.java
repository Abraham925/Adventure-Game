package game;

public class RoomTie implements Interactable {
	
	private String name; //the name of the interactable
	private String echo; //text shown when interaction is made
	private Room unlockedRoom;
	private String newDescription;
	private String desc;
	private String action;
	
	public RoomTie(String name, String action, String echo, Room unlockedRoom, String newDescription) {
		desc = "switch";
		this.name = name;
		this.action = action;
		this.echo = echo;
		this.unlockedRoom = unlockedRoom;
		this.newDescription = newDescription;
	}
	
	private boolean unlock = false;
	
	public void unlock() {
		unlock = true;
		if(newDescription != null)
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
	
	public String action() {
		return action + " ";
	}
	
	public void interact() {
		unlock();
		System.out.println(echo);
	}

}
