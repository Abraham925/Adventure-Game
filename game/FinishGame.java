package game;

public class FinishGame implements Command {
	
	private Game game;
	
	public FinishGame(Game game) {
		this.game = game;
	}

	public void run() {
		game.finishGame();
	}

}
