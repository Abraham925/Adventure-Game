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
        list[4] = "leap";
        list[5] = "groundpound";
        
        if (command.equals("north") || command.equals("south") 
            || command.equals("west") || command.equals("east") 
        	|| command.equals("leap") || command.equals("groundpound")) {
            Room nextRoom = null;   // the room we're moving to
            if (command.equals("north"))
                nextRoom = room.getNorth();
            else if (command.equals("south"))
                nextRoom = room.getSouth();
            else if (command.equals("west"))
                nextRoom = room.getWest();
            else if (command.equals("east"))
                nextRoom = room.getEast();
            else if (command.equals("leap")) //added
            	nextRoom = room.getAbove();
            else if (command.equals("groundpound")) { //added
            	nextRoom = room.getBelow();
            	System.out.println("You crashed through the floor.");
            }
            if (nextRoom == null) {
                System.out.println("There is no door in that direction.");
                nextRoom = room;
                game.setCurrentRoom(nextRoom);
            }
            else
                game.setCurrentRoom(nextRoom);
            
            
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
