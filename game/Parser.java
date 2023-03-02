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

public class Parser {

    /**
     * For user input from the keyboard.
     */
    private Scanner keyboard;
    
    /**
     * Stores the list of usable commands
     */
    private String[] list = new String[6];

    /**
     * Plain constructor
     */
    public Parser() {
        keyboard = new Scanner(System.in);
    }
    

    /**
     * Let the user make one "turn" at this game.
     * Give the user a description of the room, prompt for
     * a command, and interpret the command.
     * @param game A reference to the object representing the game.
     */
    public void executeTurn(Game game) {
        // The room that the user is in.
        Room room = game.getCurrentRoom();

        System.out.println(room.getDescription());

        System.out.print("Enter command--> ");
        String command = keyboard.nextLine().toLowerCase();  // user's command
        
        //command list
        list[0] = "north";
        list[1] = "east";
        list[2] = "south";
        list[3] = "west";
        list[4] = "up";
        list[5] = "down";
        
        
        	if (room.getDir(command) == null) {
                System.out.println("Nothing else exists that way.");
            }else {
            	room = room.getDir(command);
            	game.setCurrentRoom(room);
            }

    }
    
    
    public void help() {
    	for(int i = 0; i<list.length; i+=2) {
        	if(i+1 == list.length)
        		System.out.println(list[i]);
        	else
        		System.out.println(list[i] + "\t" + list[i+1]);
    	}
    }

}
