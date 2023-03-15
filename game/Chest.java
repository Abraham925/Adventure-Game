package game;

public class Chest implements Interactable{
	private boolean opened;
	private item key;
	private item item;

	public Chest(item key, item item) {
		opened = false;
		
	}
	
	
    public String getItem() {
    	return item.name();
    }
    public String getKey() {
    	return key.name();
    }
	@Override
	public void unlock() {
		opened = true;	
	}

	@Override
	public boolean isUnlocked() {
		return opened;
	}
}



