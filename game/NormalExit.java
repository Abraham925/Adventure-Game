package game;

public class NormalExit implements Exit {
	
	private Game game;
	private Room two;
	
	public NormalExit(Game game, Room two) {
		this.game = game;
		this.two = two;
	}
	
	public void travel() {
		game.setCurrentRoom(two);
	}

}
