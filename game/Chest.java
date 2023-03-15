package game;

public class Chest implements Interactable{
	
	private String name;
	private boolean opened;
	private item key;
	private item item;

	public Chest(item key, item item) {
		opened = false;
	}
	
    public String getItem() { //name of item
    	return item.name();
    }
    
    public String getKey() { //name of key to open
    	return key.name();
    }
    
    public
    
	@Override
	public void unlock() {
		opened = true;	
	}

	@Override
	public boolean isUnlocked() {
		return opened;
	}
	
	public void interact() {
		
	}
}



