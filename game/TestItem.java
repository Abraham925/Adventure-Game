package game;

public class TestItem implements item {
	
	private String name = "item";

	@Override
	public String use() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void itemName(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public void pickedUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getPosession() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isUsed() {
		// TODO Auto-generated method stub
		return false;
	}

}
