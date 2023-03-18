package game;

public class UnstableExit implements Exit {
	
	private Game game;
	private Room room;
	private String reaction;
	private int security = 1;
	
	public UnstableExit(Game game, Room room, String reaction) {
		this.game = game;
		this.room = room;
		this.reaction = reaction;
	}

	public void travel() {
		
		if(security > 0) {
			security-=1;
			game.setCurrentRoom(room);
		}else {
			System.out.println(reaction);
		}
		
	}

}
