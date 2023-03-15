package game;

public class ItemContainer implements Interactable {
	
	private String name;
	
	private boolean unlock = false;

	public void unlock() {
		unlock = true;
	}
	
	public boolean isUnlocked() {
		return unlock;
	}
	
	public void interName(String text) {
		name = text;
	}
	
	public String name() {
		return name;
	}
	
	public void interact() {
		
	}

}
