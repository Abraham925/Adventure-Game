package game;

public class ToggleCrouch implements Command {
	
	private boolean toggleCrouch = false;
	
	public void run() {
		toggleCrouch = !toggleCrouch;
		System.out.println("Toggle Crouch set to " + toggleCrouch);
	}

}
