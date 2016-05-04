package StartGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewStartGame extends JFrame {
	
	private int controller;
	private JButton jbtn_comenzar;
	private JButton jbtn_regla;
	
	public ViewStartGame(){
		setLayout(new GridLayout(1,1,10,10));
		
				// Panel contenedor.
		
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout(10,10));
		main.setBackground(Color.decode("#0B6121"));
		
				// Panel norte.
		
		JPanel main_north = new JPanel();
		main_north.setLayout(new GridLayout(1, 1));
		main_north.setBackground(Color.decode("#0B6121"));
		
		JLabel tittle = new JLabel(new ImageIcon("baraja/cartas.gif"));
		tittle.setText("7 y Media");
		tittle.setFont(new Font("Eras Light ITC", Font.HANGING_BASELINE, 50));
		tittle.setForeground(Color.decode("#F2F5A9"));
		tittle.setVerticalTextPosition(JLabel.BOTTOM);
		tittle.setHorizontalTextPosition(JLabel.CENTER);
		tittle.setLocation(-1, -1);
		
		main_north.add(tittle);
		
				//JPanel Central
		
		JPanel main_center = new JPanel();
		main_center.setBackground(Color.decode("#0B6121"));
		main_center.setLayout(new GridLayout(4, 3));
		
		jbtn_comenzar = new JButton("Comenzar Partida");
		jbtn_comenzar.setName("comenzar");
		jbtn_comenzar.setBackground(Color.decode("#F2F5A9"));
		
		jbtn_regla = new JButton("Reglas del juego");
		jbtn_regla.setName("regla");
		jbtn_regla.setBackground(Color.decode("#F2F5A9"));
		
		main_center.add(new JLabel());
		main_center.add(new JLabel());
		main_center.add(new JLabel());
		main_center.add(new JLabel());
		main_center.add(jbtn_comenzar);
		main_center.add(new JLabel());
		main_center.add(new JLabel());
		main_center.add(jbtn_regla);
		main_center.add(new JLabel());
		main_center.add(new JLabel());
		main_center.add(new JLabel());
		main_center.add(new JLabel());
		main.add(main_north, BorderLayout.NORTH);
		main.add(main_center, BorderLayout.CENTER);
		
		add(main);
		
	}
	
	public void setController(ControllerStartGame controller){
		jbtn_comenzar.addActionListener(controller);
		jbtn_regla.addActionListener(controller);
	}
	
	public void runGame(){
		setSize(430, 600);
		setTitle("Siete y media");
	    setLocationRelativeTo(null);   
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
}
