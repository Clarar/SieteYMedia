package StartGame;

public class TestStartGame {

	public static void main(String[] args) {
		ViewStartGame view = new ViewStartGame();
		ControllerStartGame controller = new ControllerStartGame(view);
		
		view.setController(controller);
		
		view.runGame();
	}

}
