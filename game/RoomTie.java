package game;

public class RoomTie implements Interactable {
	
	private String echo;
	
	public RoomTie(String echo) {
		this.echo = echo;
	}
	
	private boolean unlock = false;
	
	public void unlock() {
		unlock = true;
	}

	public boolean isUnlocked() {
		return unlock;
	}
	
	public void interact() {
		unlock();
		System.out.println(echo);
	}

}
