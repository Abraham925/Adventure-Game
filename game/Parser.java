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

        System.out.println("You are in " + room.getDescription());

        System.out.print("Enter command--> ");
        String command = keyboard.nextLine().toLowerCase();  // user's command
        
        list[0] = "north";
        list[1] = "east";
        list[2] = "south";
        list[3] = "west";
        list[4] = "up";
        list[5] = "down";
        
        if (command.equals("north") || command.equals("south") 
            || command.equals("west") || command.equals("east") 
        	|| command.equals("up") || command.equals("down")) {
        	if (room.getDir(command) == null) {
                System.out.println("There is no room in that direction.");
            }
            if (command.equals("north")) {
            	if(room.getDir("north") != null) {
            		room = room.getDir("north");
            	}
            	game.setCurrentRoom(room);
            }
            else if (command.equals("south")) {
            	if(room.getDir("south") != null) {
            		room = room.getDir("south");
            	}
            	game.setCurrentRoom(room);
            }
            else if (command.equals("west")) {
            	if(room.getDir("west") != null) {
            		room = room.getDir("west");
            	}
            	game.setCurrentRoom(room);
            }
            else if (command.equals("east")) {
            	if(room.getDir("east") != null) {
            		room = room.getDir("east");
            	}
            	game.setCurrentRoom(room);
            }
            else if (command.equals("up")) { //added
            	if(room.getDir("up") != null) {
                	room = room.getDir("up");
            		System.out.println("You went up the stairs");
            	}
            	game.setCurrentRoom(room);
            }
            else if (command.equals("down")) { //added
            	if(room.getDir("down") != null) {
                	room = room.getDir("down");
            		System.out.println("You went down the stairs");
            	}
            	game.setCurrentRoom(room);
            }
            
            
            
            
        }else if(command.equals("help")) {
        	help();
        }
        else
            System.out.println("I do not know how to " + command + ".");

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
