package game;

/**
 * PlayGame.java
 * 
 * Program to control the playing of this game.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class PlayGame {
    
    public static void main(String[] args) {
        System.out.println("welCoMe tO tHe gAme");
        Game game = new Game();   // reference to the game object
        Parser parser = new Parser(game);

        while (! game.isOver()) 
            parser.executeTurn();
        	
        System.out.println("Game over.");
    }
    
}
