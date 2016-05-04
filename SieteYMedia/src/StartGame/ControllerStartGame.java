package StartGame;
import halfPastSeven.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControllerStartGame implements ActionListener {
	private ViewStartGame view;
	public ControllerStartGame(ViewStartGame view){
		this.view = view;
		
	}
	public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getName() == "comenzar") {
			
			new TestHalfPastSeven().main(null);;
			
		}
		
		if (((JButton)e.getSource()).getName() == "regla") {
			ModelReglas modelRules = new ModelReglas();
			ViewReglas viewRules = new ViewReglas();
			
			viewRules.setTextRegla(modelRules.getReglas());
			viewRules.setTextRegla1(modelRules.getReglas1());
			viewRules.setTextRegla2(modelRules.getReglas2());
			viewRules.setTextPuntuacion(modelRules.getPuntuacion());
			viewRules.setTextPuntuacion1(modelRules.getPuntuacion1());
			viewRules.setTextPuntuacion2(modelRules.getPuntuacion2());
			
			viewRules.setAddPuntuacion1(new ViewCard(modelRules.getUno().getImage()), 
										new ViewCard(modelRules.getSiete().getImage()));
			
			viewRules.setAddPuntuacion2(new ViewCard(modelRules.getDiez().getImage()), 
										new ViewCard(modelRules.getOnce().getImage()),
										new ViewCard(modelRules.getDoce().getImage()));
			
			viewRules.runGame();
		}
	}
	
	
}
