package game;

public class Use implements Command {
	
	private Interactable inter;
	
	public Use(Interactable inter) {
		this.inter = inter;
	}

	public void run() {
		inter.interact();
	}

}
