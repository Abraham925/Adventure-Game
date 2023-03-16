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
		this.interaction = interaction;
	}
	
    public String getItem() { //name of item
    	return item.name();

    }
    
    public String getKey() { //name of key to open
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
		if(key == null || key.getPossession()) {
			if(!opened) {
				item.pickedUp();
				unlock();
				System.out.println(interaction);
				System.out.println("You scavenged the chest and discovered a " + item.name());
			}else {
				System.out.println("There's nothing interesting about the empty chest");
			}
		}else {
			System.out.println("A lock prevents it from being opened up. Maybe you should look around for it.");
		}
	}
	
}



