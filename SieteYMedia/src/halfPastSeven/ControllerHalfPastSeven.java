package halfPastSeven;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControllerHalfPastSeven implements ActionListener {
	
	private ViewHalfPastSeven vista; 
	private ModelDeckOfCards modelo;
	private ModelPlayed played1;
	private ModelPlayed played2;
	
	public ControllerHalfPastSeven( ViewHalfPastSeven vista){
		this.vista = vista;
		this.modelo = new ModelDeckOfCards();
		
		played1 = new ModelPlayed(1);
		played2 = new ModelPlayed(2);
		
		modelo.shuffleDeck();
		
		vista.setPlayed(played1.getName());
		vista.setPoint(""+played1.getSumPoint());
	}
	
	private double getPointCard(){
		double point = modelo.getCard().getNumCard();
		
		switch ((int)point) {
		case 10:
			point = 0.5;
			break;
		case 11:
			point = 0.5;
			break;
		case 12:
			point = 0.5;		
			break;
		}
		
		JOptionPane.showMessageDialog(null, "point: "+point);
		return point;
	}
	
	private ModelPlayed winnerPlayed(){
		double played_one = played1.getSumPoint()-7.5;
		double played_two = played2.getSumPoint()-7.5;
		
		if (played_one == 0) {
			return played1;
		}else if(played_two == 0){
			return played2;
		}else if(played_one == played_two){
			return null;
		}else if(played_one < 0 && played_two < 0){
			if (played_one > played_two) {
				return played1;
			}else{
				return played2;
			}
		}else if (played_one > 0 && played_two > 0) {
			if (played_one < played_two) {
				return played1;
			}else{
				return played2;
			}
		}else if (played_one < 0 && played_two > 0) {
			return played1;
		}else{
			return played2;
		}
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getName() == "plantar") {
			if (played2.getSumPoint() == 0) {
				vista.setPlayed(played2.getName());
				vista.setPoint(""+played2.getSumPoint());
				vista.setPlantarEnabled(false);
				int row = (played1.getSizeCard()/10)+1;
				vista.addCardReward(modelo.getCardRearward().getImageCard(), row);
			}else{
				if (winnerPlayed() == null) {
					vista.setPlayed("Empate!!!");
					vista.setplayedLabel("Jugador1: " +played1.getSumPoint()+" puntos.");
					vista.setPoint("Jugador2: " +played2.getSumPoint());
				}else{
					vista.setPlayed("GANADOR ");
					vista.setWinner(winnerPlayed().getName());
					vista.setPoint(""+winnerPlayed().getSumPoint());
				}
				vista.setDarEnabled(false);
				vista.showCardPlayed1((played1.getSizeCard()/10)+1);
			}
		}
		
		if (((JButton)e.getSource()).getName() == "dar") {
			
			if (vista.getPlayed() == played1.getName()) {
				int row; 
				
				played1.setPoint(getPointCard());
				
				if (played1.getSumPoint() > 5.0) {
					vista.setPlantarEnabled(true);
				}
				row = (played1.getSizeCard()/10)+1;
				vista.addCardPlayed1(modelo.getCard().getImageCard(), row);
				vista.setPoint(""+played1.getSumPoint());
				
			}else{
				
				int row; 
				
				played2.setPoint(getPointCard());
				
				if (played2.getSumPoint() > 5.0) {
					vista.setPlantarEnabled(true);
				}
				
				row = (played2.getSizeCard()/10)+1;
				vista.addCardPlayed2(modelo.getCard().getImageCard(), row);
				vista.setPoint(""+played2.getSumPoint());
			}
			
			modelo.incrementTop();
		}
		
		vista.paintAll(vista.getGraphics());
	}
	
}
