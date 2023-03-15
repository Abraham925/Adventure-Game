package game;

public class Help implements Command {
	
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
