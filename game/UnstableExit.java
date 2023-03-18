package game;

public class UnstableExit implements Exit {
	
	//used for removing a connection between two rooms entirely after one use of the exit
	
	private Game game;
	private Room room;
	private String reaction;
	private Room roomConnection1;
	private Room roomConnection2;
	private String connection1;
	private String connection2;
	private String newConnection1;
	private String newConnection2;
	private Room newRoom;
	

	public UnstableExit(Game game, Room room, Room roomConnection1, Room roomConnection2, 
			String connection1, String connection2, String newConnection1, String newConnection2, 
			Room newRoom, String reaction) {
		this.game = game;
		this.room = room;
		this.reaction = reaction;
		this.roomConnection1 = roomConnection1;
		this.roomConnection2 = roomConnection2;
		this.connection1 = connection1;
		this.connection2 = connection2;
		this.newConnection1 = newConnection1;
		this.newConnection2 = newConnection2;
		this.newRoom = newRoom;
	}

	public void travel() {		
			game.setCurrentRoom(room);
			System.out.println(reaction);
			//removes the old connections
			roomConnection1.removeDir(connection1);
			roomConnection2.removeDir(connection2);
			//makes new connections if they are provided for the unstableExit
			if (roomConnection1 != null) {
				roomConnection1.setDir(newConnection1, new NormalExit(game, newRoom));
			}
			if (roomConnection2 != null) {
				roomConnection2.setDir(newConnection2, new NormalExit(game, newRoom));
			}
		}
		
	}


