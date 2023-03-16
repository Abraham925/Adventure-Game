package game;

public class OpenChest implements Command {
	
	private Interactable chest;
	
	public OpenChest(Interactable chest) {
		this.chest = chest;
	}

	public void run() {
		chest.interact();
	}

}
