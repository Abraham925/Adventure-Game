package game;

public class FinalPart implements item {
	
	private String name;
	private String use;
	private boolean posession;
	private boolean isUsed;
	public FinalPart() {
		name = "Final Piece";
		use = "Part 4/4";
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
