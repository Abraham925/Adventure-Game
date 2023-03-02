package game;

import java.util.HashMap;
import java.util.Random;

public class Chest {
	private String item;
	private boolean opened;
    /**
     * HashMap of items
     */
    private HashMap<String, String> itemList;
	
	public Chest() {
    	Part3 x = new Part3();
    	Telescope y = new Telescope();
    	Part2 z = new Part2();
    	itemList.put(z.name(), z.use());
    	itemList.put(y.name(), y.use());
    	itemList.put(x.name(), x.use());

		opened = false;
	}
	
	
    public String getItem() {

    	if(opened == false) {
	    	Random generator = new Random();
	    	String[] values = (String[]) itemList.values().toArray();
	    	String randomValue = values[generator.nextInt(values.length)];
	    	
	    	item = itemList.get(randomValue);
	    	return item;
    	}
    	return "This chest has already been opened";
	    	
    }
    public void setOpened() {
    	opened = true;
    }
    public boolean getOpened() {
    	return opened;
    }
	
	
}
