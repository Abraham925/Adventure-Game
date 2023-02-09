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


        if (command.equals("north") || command.equals("south") 
            || command.equals("west") || command.equals("east") 
        	|| command.equals("leap") || command.equals("groundpound")) {
            Room nextRoom = null;   // the room we're moving to
            
            if (command.equals("north")) {
                nextRoom = room.getDirection("north");
            }else if (command.equals("south")) {
                nextRoom = room.getDirection("south");
            }else if (command.equals("west")) {
                nextRoom = room.getDirection("west");
            }else if (command.equals("east")) {
                nextRoom = room.getDirection("east");
            }else if (command.equals("leap")) {//added
            	nextRoom = room.getDirection("leap");
            }else if (command.equals("groundpound")) {//added
            	nextRoom = room.getDirection("groundpound");
            }
            
            if (nextRoom == null) { 
                System.out.println("There is no door in that direction.");
            }else {
                game.setCurrentRoom(nextRoom);
        	}
        } else {
            System.out.println("I do not know how to " + command + ".");
        }

    }


}
