package game;

public interface Interactable {
	
	public String name();
	
	public String action();
	
	public String description();
	
	public void unlock();
	
	public boolean isUnlocked();
	
	public void interact();
	
}
