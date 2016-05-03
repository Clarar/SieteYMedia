package halfPastSeven;

public class TestHalfPastSeven {

	public static void main(String[] args) {
		ViewHalfPastSeven vista = new ViewHalfPastSeven();
		ControllerHalfPastSeven controller = new ControllerHalfPastSeven(vista);
		
		vista.setController(controller);
		vista.runGame();
	}

}
