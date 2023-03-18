package game;

public class LockedExit implements Exit {
	
	private Game game;
	private Room two; //the room to be set to
	private Item item; //required item to open an exit
	private Interactable inter; //required interactable interaction to open an exit
	private String reaction; //text displayed when going through the exit
	
	public LockedExit(Game game, Room two, Item item, Interactable inter, String reaction) {
		this.game = game;
		this.two = two;
		this.item = item;
		this.inter = inter;
		this.reaction = reaction;
	}

	public void travel() {
		if(item != null) { //requires an item to pass
			if(item.getPossession()) {
				game.setCurrentRoom(two);
				if(reaction != null) { //reaction is set
					System.out.println(reaction);
				}
			}else { //player doesn't have required item
				System.out.println("This route is not viable currently.");
			}
		}else if(inter != null) { //interactable is required
			if(inter.isUnlocked()) {
				game.setCurrentRoom(two);
			}else { //player has not interacted with interactable
				System.out.println("It looks like something is missing; it needs to fall into place...");
			}
		}else { //no item and no interactable, cannot pass
			System.out.println("There is no return route. Face what's ahead!");
		}
	}

}
