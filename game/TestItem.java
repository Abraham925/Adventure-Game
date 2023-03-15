package game;

public class TestItem implements item {
	
	private String name;
	
	public void itemName(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public void pickedUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getPosession() {
		// TODO Auto-generated method stub
		return true;
	}

}
