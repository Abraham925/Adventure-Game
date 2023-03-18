package game;

public class Chest implements Interactable{
	
	private String name;
	private boolean opened;
	private Item key;
	private Item item;
	private String interaction;
	private String desc;
	

	public Chest(Item key, Item item, String name, String interaction) {		
		opened = false;
		desc = "chest";
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
	
	public String description() {
		return desc;
	}
	
	public String name() {
		return name;
	}
	
	public String action() {
		return "search ";
	}
	
	@Override
	public void interact() {
		if(item == null) {
			System.out.println(interaction);
		}else {
			if(key == null || key.getPossession()) {
				if(!opened) {
					item.pickedUp();
					unlock();
					System.out.println(interaction);
					System.out.println("You discovered a " + item.name() + ". ");
				}else {
					System.out.println("There's nothing interesting about the empty chest");
				}
			}else {
				System.out.println("A lock prevents it from being opened up. Maybe you should look around for it.");
			}
		}
	}
	
}



