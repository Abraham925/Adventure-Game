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
        System.out.println("You wake up with your head pounding, and blood stinging your eyes."
        		+ " As you crawl out of your ship, you remember the collision you had with an asteroid when making "
        		+ "the castle run.\nYou seem to have found yourself in some space station. The question remains,"
        		+ " how'd you and your ship end up here?");
        Game game = new Game();   // reference to the game object
        Parser parser = new Parser(game);

        while (! game.isOver()) 
            parser.executeTurn();
        	if (game.getInventory().allItemsAcquired() && game.getCurrentRoom().getDescription().equals("You find yourself in a small room with scattered tools and parts. Something is sparking.")) {
        		game.finishGame();
        	}

        System.out.println("You quickly assemble all the parts and patch your broken ship. You hear the "
        		+ "familiar wrrrrr of your engine as you jet away from the blasted station. Maybe next time"
        		+ " you'll avoid those asteriod fields.." + "\n\nTHE END.");
        
    }
    
}
