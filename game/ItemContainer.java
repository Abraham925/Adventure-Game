package game;

public class ItemContainer implements Interactable {
	
	private boolean unlock = false;

	public void unlock() {
		unlock = true;
	}
	
	public boolean isUnlocked() {
		return unlock;
	}

}
