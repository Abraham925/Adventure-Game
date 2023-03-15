package game;

public class Search implements Command {
	
	private Game game;
	private Room room;
	
	public Search(Game game) {
		this.game = game;
		this.room = game.getCurrentRoom();
	}

	public void run() {
		if(room.getItems().size() != 0) {
			System.out.print("Around the room, you see ");
			for(int i = 0; i<room.getItems().size()-1; i+=1) {
				System.out.print(room.getItems().get(i).name() + ", ");
			}
			System.out.print("and " + room.getItems().get(room.getItems().size()-1).name() + ".");
		}else {
			System.out.print("There are no items in the room.");
		}
		System.out.println();
	}
	
}
