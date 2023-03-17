package game;

public class RoomTie implements Interactable {
	
	private String name;
	private String echo;
	private String desc;
	
	public RoomTie(String echo, String name) {
		desc = "switch";
		this.echo = echo;
		this.name = name;
	}
	
	private boolean unlock = false;
	
	public void unlock() {
		unlock = true;
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
