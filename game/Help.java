package game;

public class Help implements Command {
	
	//prints out list of available commands in the room
	
	private Parser parser;
	
	public Help(Parser parser) {
		this.parser = parser;
	}

	public void run() {
		for(String key : parser.getMap().keySet()){
    		System.out.println(key);
    	}
    	System.out.println();
	}

}
