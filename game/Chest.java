package game;

public class Chest implements Interactable{
	
	private String name; //printable name
	private boolean opened; //open or unopened
	private Item key; //necessary item to open chest
	private Item item; //item inside chest
	private String interaction; //statement after chest opens
	private String desc; //used to separate chests from other interactables when setting map
	

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
	
	public String description() {
		return desc;
	}
	
	public String name() {
		return name;
	}
	
	public String action() { //added in front of chest name to make a command
		return "search ";
	}
	
	@Override
	public void interact() {
		if(item == null) { //no item in chest
			System.out.println(interaction);
		}else { //item in chest
			if(key == null || key.getPossession()) { //either there is no key or you need to have the existing one
				if(!opened) {
					item.pickedUp(); //changes possession boolean of item
					unlock(); //chest is open
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



