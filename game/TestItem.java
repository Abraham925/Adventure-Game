package game;

public class TestItem implements Item {
	
	private String name;
	private String desc;
	
	public void itemName(String name) {
		this.name = name;
	}
	
	public String description() {
		return desc;
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
	public boolean getPossession() {
		// TODO Auto-generated method stub
		return true;
	}

}
