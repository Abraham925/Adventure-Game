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
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {

    /**
     * For user input from the keyboard.
     */
    private Scanner keyboard;
    
    private Room room;
    
    private Game game;
    
    //private boolean toggleCrouch = false;
    
    private HashMap<String, Command> map = new HashMap<String, Command>();

    /**
     * Plain constructor
     */
    public Parser(Game game) {
    	this.game = game;
        map.put("look", new Look(game));
        map.put("ls", new Look(game));
        map.put("search", new Search(game));
        map.put("help", new Help(this));
        map.put("inventory", new Inventory(game.getInventory()));
        map.put("i", new Inventory(game.getInventory()));
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
        
        for(int i = 0; i<room.getInter().size(); i+=1) {
        //if(room.getInter().size() == 1) {
        	if(room.getInter().get(0).description().equals("chest")) {
        		map.put("open " + room.getInter().get(i).name(), new OpenChest(room.getInter().get(i)));
        	}else {
        		map.put("use " + room.getInter().get(i).name(), new Use(room.getInter().get(i)));
        	}
        }
        
        //System.out.println("ITEMS SIZE: " + room.getItems().size());
        
        for(int i = 0; i<room.getItems().size(); i+=1) {
        	map.put("pick up " + room.getItems().get(i).name(), new PickUpItem(room.getItems().get(i)));
        }
        
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
        	for(int i = 0; i<room.getInter().size(); i+=1) {
        	//if(room.getInter().size() == 1) {
        		if(room.getInter().get(0).name().equals("chest")) {
            		map.remove("open " + room.getInter().get(i).name());
            	}else {
            		map.remove("use " + room.getInter().get(i).name()); //removes mapping before switching rooms
            	}
            }
        	for(int i = 0; i<room.getItems().size(); i+=1) {
            	map.remove("pick up " + room.getItems().get(i).name());
            }
        	room.getDir(command).travel(); //calls travel on door
        	System.out.println(game.getCurrentRoom().getDescription());
        }
    }
    
    public Command getCommand(String com) {
    	return map.get(com);
    }
    
    public HashMap<String, Command> getMap(){
    	return map;
    }
    
}
