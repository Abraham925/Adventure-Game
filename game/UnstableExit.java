package game;

public class UnstableExit implements Exit {
	
	private Game game;
	private Room room;
	private int security = 2;
	
	public UnstableExit(Game game, Room room) {
		this.game = game;
		this.room = room;
	}

	public void travel() {
		
		if(security > 0) {
			security-=1;
			game.setCurrentRoom(room);
		}else {
			System.out.println("This route seemed to only work a few times before fading away, what a shame.");
		}
		
	}

}
