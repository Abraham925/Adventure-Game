package game;

public class Chest implements Interactable{
	
	private String name;
	private boolean opened;
	private item key;
	private item item;
	private String interaction;
	

	public Chest(item key, item item, String name, String interaction) {		
		opened = false;
		this.key = key;
		this.item = item;
		this.name = name;
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
	public void interName(String text) {
		name = text;
	}
	public String name() {
		return name;
	}
	@Override
	public void interact() {
		System.out.println(interaction);
	}


}



