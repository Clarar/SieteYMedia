package halfPastSeven;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewHalfPastSeven extends JFrame {
	
	private ArrayList<JPanel> cards1;
	private ArrayList<JPanel> cardsRearward;
	private ArrayList<JPanel> cards2;
	private JPanel main_center;
	private JPanel main_south;
	private JButton jbtn_plantar;
	private JButton jbtn_dar;
	private Font myfont_20;
	private Font myfont;
	private JPanel played1_card;
	private JPanel played2_card;
	private JLabel point_played;
	private JLabel played_id;
	private JLabel played_label;
	private JLabel winner;
	
	public ViewHalfPastSeven(){
		
		newCardsPlayers();
		this.cardsRearward = new ArrayList<JPanel>();//reverso de las cartas
		
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout(5,5));
		main.setBackground(Color.decode("#0B6121"));
		
		myfont_20 = new Font("Comic Sans MS", Font.PLAIN, 20);
		myfont = new Font("Comic Sans MS", Font.PLAIN, 15);
		
		main_center = new JPanel();
		main_center.setBackground(Color.decode("#0B6121"));
		main_center.setLayout(new GridLayout(2,1));
		
		
		//Panel jugador 1
		JPanel played1 = new JPanel(new BorderLayout(20,20));
		played1.setBackground(Color.decode("#0B6121"));
		played1.setBorder(BorderFactory.createEtchedBorder());
		
		played1_card = new JPanel();
		played1_card.setBackground(Color.decode("#0B6121"));
		
		JLabel played1_name = new JLabel("Jugador 1");
		played1_name.setFont(myfont_20);
		played1_name.setForeground(Color.WHITE);
		
		played1.add(played1_name, BorderLayout.WEST);
		played1.add(played1_card, BorderLayout.CENTER);
		
		
		//Panel jugador 2
		JPanel played2 = new JPanel(new BorderLayout(20,20));
		played2.setBackground(Color.decode("#0B6121"));
		played2.setBorder(BorderFactory.createEtchedBorder());
		
		played2_card = new JPanel();
		played2_card.setBackground(Color.decode("#0B6121"));
		JLabel played2_name = new JLabel("Jugador 2");
		played2_name.setFont(myfont_20);
		played2_name.setForeground(Color.WHITE);
		
		played2.add(played2_name, BorderLayout.WEST);
		played2.add(played2_card, BorderLayout.CENTER);
		
		main_center.add(played1);
		main_center.add(played2);
		
				//Panel sur
		
		
		main_south = new JPanel();
		main_south.setLayout(new GridLayout(1, 3, 10,10));
		main_south.setBackground(Color.decode("#0B6121"));
		
				//panel de dar carta
		
		JPanel south_button_dar = new JPanel(new GridLayout(1,1,1,1));
		south_button_dar.setBackground(Color.decode("#0B6121"));

		jbtn_dar = new JButton(new ImageIcon("baraja/trasero.jpg"));
		jbtn_dar.setRolloverIcon(new ImageIcon("baraja/trasero2.jpg"));
		jbtn_dar.setName("dar");
		jbtn_dar.setBackground(Color.decode("#0B6121"));
		jbtn_dar.setBorderPainted(false);
		
		south_button_dar.add(jbtn_dar);
				
				//panel de plantarse
		
		JPanel south_button_plantar = new JPanel(new GridLayout(1,1,1,1));
		south_button_plantar.setBackground(Color.decode("#0B6121"));
		
		jbtn_plantar = new JButton();
		jbtn_plantar.setName("plantar");
		jbtn_plantar.setBackground(Color.decode("#0B6121"));
		jbtn_plantar.setIcon(new ImageIcon("baraja/red-button.jpg"));
		jbtn_plantar.setRolloverIcon(new ImageIcon("baraja/red-button2.jpg"));
		jbtn_plantar.setBorderPainted(false);
		
		
		south_button_plantar.add(jbtn_plantar);
		
				//Panel de detalles del jugador que esta jugando
		
		JPanel south_detail = new JPanel(new GridLayout(2,2,2,2));
		south_detail.setBackground(Color.decode("#0B6121"));
		south_detail.setBorder(BorderFactory.createEtchedBorder());
		
		played_id = new JLabel();
		played_id.setText("Jugador X");
		played_id.setFont(myfont_20);
		played_id.setForeground(Color.WHITE);
		played_label = new JLabel();
		played_label.setText("Puntos: ");
		played_label.setFont(myfont);
		played_label.setForeground(Color.WHITE);
		point_played = new JLabel();
		point_played.setText("--   ");
		point_played.setFont(myfont);
		point_played.setForeground(Color.WHITE);
		
		
		
				//muestra el nombre del ganador.
		
		
		winner = new JLabel();
		winner.setFont(myfont_20);
		winner.setForeground(Color.WHITE);
		
		south_detail.add(played_id);
		south_detail.add(winner);
		
		south_detail.add(played_label);
		south_detail.add(point_played);
		
		main_south.add(south_button_dar);
		main_south.add(south_detail);
		main_south.add(south_button_plantar);
		
		main.add(main_center, BorderLayout.CENTER);
		main.add(main_south, BorderLayout.SOUTH);
		
		add(main);
		
	}
	
	public void newCardsPlayers(){
		this.cards1 = new ArrayList<JPanel>();		//Cartas jugados 1
		this.cards2 = new ArrayList<JPanel>();		//cartas jugador 2
	}
	
	public void setPlantarEnabled(boolean enabled){
		this.jbtn_plantar.setEnabled(enabled);
	}
	
	public boolean isPlantarEnabled(){
		return jbtn_plantar.isEnabled();
	}
	
	public void setDarEnabled(boolean enabled){
		this.jbtn_dar.setEnabled(enabled);
	}
	
	public void addCardPlayed1(Image image,int row){
		
		played1_card.setLayout(new GridLayout(row, 5,5,5));
		played1_card.setBackground(Color.decode("#0B6121"));
		
		cards1.add(new ViewCard(image));
		played1_card.removeAll();
		int i;
		for (i = 0; i < cards1.size(); i++) {
			played1_card.add(cards1.get(i));
		}
		for (int j = i; j < 7; j++) {
			played1_card.add(new JLabel());
		}
	}
	
	public void showCardPlayed1(int row){
		
		played1_card.setLayout(new GridLayout(row, 5,5,5));
		played1_card.setBackground(Color.decode("#0B6121"));
		played1_card.removeAll();
		int i;
		for (i = 0; i < cards1.size(); i++) {
			played1_card.add(cards1.get(i));
		}
		for (int j = i; j < 7; j++) {
			played1_card.add(new JLabel());
		}
	}
	
	public void addCardReward(Image image,int row){
		
		played1_card.setLayout(new GridLayout(row, 5,5,5));
		played1_card.setBackground(Color.decode("#0B6121"));
		
		played1_card.removeAll();
		
		int i;
		for (i = 0; i < cards1.size(); i++) {
			cardsRearward.add(new ViewCard(image));
			played1_card.add(cardsRearward.get(i),i);
		}
		for (int j = i; j < 7; j++) {
			played1_card.add(new JLabel());
		}
	}
	
	public void addCardPlayed2(Image image,int row){
		
		played2_card.setLayout(new GridLayout(row, 5,5,5));
		played2_card.setBackground(Color.decode("#0B6121"));
		
		cards2.add(new ViewCard(image));
		played2_card.removeAll();
		
		int i;
		for (i = 0; i < cards2.size(); i++) {
			played2_card.add(cards2.get(i));
		}
		for (int j = i; j < 7; j++) {
			played2_card.add(new JLabel());
		}
	}
	
	public void setPoint(String point){
		point_played.setText(point);
	}
	
	public void setplayedLabel(String text){
		played_label.setText(text);
	}
	
	public double getPoint(){
		return Double.parseDouble(point_played.getText());
	}
	
	public void setPlayed(String played){
		played_id.setText(played);
	}
	
	public String getPlayed(){
		return played_id.getText();
	}
	
	public void setWinner(String played){
		winner.setText(played);
	}
	
	public int newGame(){
		int confirmar = JOptionPane.showConfirmDialog(null,
									"¿Desea Empezar una nueva partida?", "Siete y media", JOptionPane.YES_NO_OPTION);
		
		return confirmar;
	}

	public void setController(ControllerHalfPastSeven controller){
		jbtn_plantar.addActionListener(controller);
		jbtn_dar.addActionListener(controller);
	}
	
	public void runGame(){
		setSize(800, 600);
		setTitle("Siete y media");
	    setLocationRelativeTo(null);   
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}

	public JButton getJbtn_plantar() {
		return jbtn_plantar;
	}
	
	public JButton getJbtn_dar() {
		return jbtn_dar;
	}
	
	public void resetPlayed2Card(){
		played2_card.removeAll();
	}
	
	public void resetPlayed1Card(){
		played1_card.removeAll();
	}
}
