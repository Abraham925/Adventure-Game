package game;

public class Search implements Command {
	
	private Game game;
	private Room room;
	
	public Search(Game game) {
		this.game = game;
		this.room = game.getCurrentRoom();
	}

	public void run() {
		room = game.getCurrentRoom();
		
		if(room.getItems().size() != 0) {
			System.out.print("Around the room, you see ");
			for(int i = 0; i<room.getItems().size()-1; i+=1) {
				System.out.print(room.getItems().get(i).description() + ", ");
			}
			if(room.getItems().size() > 1) {
				System.out.print("and what appears to be ");
			}
			System.out.print(room.getItems().get(room.getItems().size()-1).description() + ". ");
		}
		if(room.getInter().size() != 0) {
			System.out.print("You spotted a ");
			for(int i = 0; i<room.getInter().size()-1; i+=1) {
				System.out.print(room.getInter().get(i).name() + ", ");
			}
			if(room.getInter().size() > 1) {
				System.out.print("and a ");
			}
			System.out.print(room.getInter().get(room.getInter().size()-1).name() + ". ");
		}else {
			System.out.print("no items or interesting features in the room.");
		}
		System.out.println();
	}
	
}
