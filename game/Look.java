package game;

public class Look implements Command {
	
	//prints the available locations to go to from current room
	
	private Game game;
	
	public Look(Game game){
		this.game = game;
	}
	
	public void help() {
    	System.out.println("Available locations:");
    	for(String key : game.getCurrentRoom().getDirMap().keySet()){
    		System.out.println(key);
    	}
    	System.out.println();
    }
	
	public void run() {
		help();
	}

}
