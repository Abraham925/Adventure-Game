package game;

public interface Interactable {
	
	public String name();
	
	public String description();
	
	public void unlock();
	
	public boolean isUnlocked();
	
	public void interact();
	
}
