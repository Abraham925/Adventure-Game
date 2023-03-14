package game;

public class Telescope  extends Backpack implements item {

	private String name;
	private String use;
	private boolean posession;
	private boolean isUsed;
	public Telescope() {
		name = "Telecope";
		use = "Search planet";
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
			return use;
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
		// TODO Auto-generated method stub
		return isUsed;
	}
}
