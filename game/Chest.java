package game;

public class Chest {
	private String item;
	private String key;
	private boolean opened;

	public Chest(String key, String item) {
		opened = false;
		
	}
	
	
    public String getItem() {
    	return item;
    }
    public String getKey() {
    	return key;
    }
    public void setOpened() {
    	opened = true;
    }
    public boolean getOpened() {
    	return opened;
    }
}



