package game;

public class LockedExit implements Exit {
	
	private Game game;
	private Room two;
	private Item item;
	private Interactable inter;
	private String reaction;
	
	public LockedExit(Game game, Room two, Item item, Interactable inter, String reaction) {
		this.game = game;
		this.two = two;
		this.item = item;
		this.inter = inter;
		this.reaction = reaction;
	}

	public void travel() {
		if(item != null) {
			if(item.getPossession()) {
				game.setCurrentRoom(two);
				if(reaction != null) {
					System.out.println(reaction);
				}
			}else {
				System.out.println("This route is not viable currently.");
			}
		}else if(inter != null) {
			if(inter.isUnlocked()) {
				game.setCurrentRoom(two);
				
			}else {
				System.out.println("It looks like something is missing; it needs to fall into place...");
			}
		}
	}

}
