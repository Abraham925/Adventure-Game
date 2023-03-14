package game;

public class Crouch implements Command {
	
	private boolean cr;

	public void run() {
		cr = !cr;
		if(cr)
			System.out.println("You lowered to a squat to appear shorter.");
		else
			System.out.println("You stood straight up and are now visible.");
	}

}
