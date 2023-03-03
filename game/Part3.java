package game;

public class Part3 extends Backpack implements item {
	
	private String name;
	private String use;
	private boolean posession;
	private boolean isUsed;
	public Part3() {
		name = "Piece 3";
		use = "Part 3/3";
		posession = false;
	}
	public void pickedUp() {
		posession = true;
		
	}
	public String use() {
		if(getPosession()){
			isUsed = true;
			return use;
		}
		else {
			return "";
		}
	}
	public String name() {
		return name;
	}
	@Override
	public void setDown() {
		posession = false;
		
	}
	@Override
	public boolean getPosession() {
		return posession;
	}
	@Override
	public boolean isUsed() {
		return isUsed;
	}

}
