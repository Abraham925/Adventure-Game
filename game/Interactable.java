package game;

public interface Interactable {
	
	public void interName(String text);
	
	public String name();
	
	public String description();
	
	public void unlock();
	
	public boolean isUnlocked();
	
	public void interact();
	
}
