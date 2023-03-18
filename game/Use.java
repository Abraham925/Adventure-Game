package game;

public class Use implements Command {
	
	//completes the action of a given interactable
	
	private Interactable inter;
	
	public Use(Interactable inter) {
		this.inter = inter;
	}

	public void run() {
		inter.interact();
	}

}
