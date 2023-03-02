package game;

/**
 * Parser.java
 * 
 * Class to interpret the user's commands
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

import java.util.Scanner;
import java.util.HashMap;

public class Parser {

    /**
     * For user input from the keyboard.
     */
    private Scanner keyboard;
    
    private Room room;
    
    private Game game;
    
    private HashMap<String, Command> map = new HashMap<String, Command>();

    /**
     * Plain constructor
     */
    public Parser(Game game) {
    	this.game = game;
        map.put("look", new Look(game));
        map.put("ls", new Look(game));
        map.put("crouch", new Crouch());
        keyboard = new Scanner(System.in);
    }
    
    /**
     * User input
     */
    private String command = "";

    /**
     * Let the user make one "turn" at this game.
     * Give the user a description of the room, prompt for
     * a command, and interpret the command.
     * @param game A reference to the object representing the game.
     */
    public void executeTurn() {
    	
        // The room that the user is in.
        room = game.getCurrentRoom();
        
        if(command.equals("")) {//game just started, shows room description
        	System.out.println(room.getDescription());
        }

        System.out.print("Enter command--> ");
        command = keyboard.nextLine().toLowerCase();  // user's command
        
        
        if (room.getDir(command) == null) { //command is not a direction
        	if(getCommand(command) != null) { //command was typed in, must be an action
        		getCommand(command).run();
        	}else { //not a direction or an action
        		System.out.println("Nothing else exists that way.");
        	}
        }else { //command is a direction
        	room = room.getDir(command);
        	game.setCurrentRoom(room);
        	System.out.println(room.getDescription());
        }
    }
    
    public Command getCommand(String com) {
    	return map.get(com);
    }
}
