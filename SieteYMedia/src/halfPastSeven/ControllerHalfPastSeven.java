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
		
		newGame(); 	
	}
	
	public void newGame(){
		
		this.modelo = new ModelDeckOfCards();
		
		played1 = new ModelPlayed(1);
		played2 = new ModelPlayed(2);
		
		modelo.setTop(0);
		modelo.shuffleDeck();
		
		vista.setPlayed(played1.getName());
		vista.setPoint(""+played1.getSumPoint());
		
		vista.newCardsPlayers();
		vista.setWinner(" ");
		vista.setplayedLabel("Puntos:");
		
		vista.getJbtn_dar().setEnabled(true);
		vista.getJbtn_plantar().setEnabled(false);
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
					// En caso de dar el jugador uno al botón,
					// se añaden los datos del jugador dos a la vista.
			if (played2.getSumPoint() == 0) {
				vista.setPlayed(played2.getName());
				vista.setPoint(""+played2.getSumPoint());
				vista.setPlantarEnabled(false);
				int row = (played1.getSizeCard()/10)+1;
				vista.addCardReward(modelo.getCardRearward().getImageCard(), row);
			}else{
					// En caso de ser el jugador dos quien pulse el botón,
					// se comprueba el ganador
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
				vista.paintAll(vista.getGraphics());
				
				if(vista.newGame() == 0 ){ 		// si el usuario quiere iniciar la partida.
					newGame();					// inicia el juego.
					vista.resetPlayed1Card();	// reinicia los arrais de cartas de cada jugador.
					vista.resetPlayed2Card();
				}else{
					System.exit(0);				//si el usuario no quiere iniciar sesion cierra la ventana.
				}
			}
		}
		
		if (((JButton)e.getSource()).getName() == "dar") {
			
			if (vista.getPlayed() == played1.getName()) {
				int row; 
				
				played1.setPoint(getPointCard());			// Añade los puntos obtenidos.
				
				if (played1.getSumPoint() > 5.0) {			// Valida que la puntuación sea sea mayor a 5.5
					vista.setPlantarEnabled(true);			// y habilita el botón de plantarse.
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
			
			modelo.incrementTop(); 								// Incrementa el top de la baraja.
		}
		
		vista.paintAll(vista.getGraphics());
	}
	
}
