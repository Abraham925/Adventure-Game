package game;

public class LockedExit implements Exit {
	
	private Game game;
	private Room two;
	private item item;
	private Interactable inter;
	
	public LockedExit(Game game, Room two, item item, Interactable inter) {
		this.game = game;
		this.two = two;
		this.item = item;
		this.inter = inter;
	}

	public void travel() {
		if(item != null) {
			if(item.getPosession()) {
				game.setCurrentRoom(two);
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
