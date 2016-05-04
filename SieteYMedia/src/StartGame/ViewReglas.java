package StartGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewReglas extends JDialog {
	
	private JLabel puntuacion;
	private JLabel puntuacion1;
	private JLabel puntuacion2;
	private JLabel regla;
	private JLabel regla1;
	private JLabel regla2;
	private JPanel jpl_regla;
	private JPanel jpl_puntuacion;
	private JPanel jpl_puntuacion1;
	private JPanel jpl_puntuacion2;
	
	public ViewReglas(){
		setModal(true);
		setLayout(new GridLayout(1, 1));
		
		Font myFont20 = new Font("Eras Light ITC", Font.HANGING_BASELINE, 20);
		Font myFont30 = new Font("Eras Light ITC", Font.HANGING_BASELINE, 30);
		Color colorLetter = Color.decode("#F2F5A9");
		
			// Panel contenedor
		
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout(10,10));
		main.setBackground(Color.decode("#0B6121"));
		
		jpl_regla = new JPanel();
		jpl_regla.setLayout(new GridLayout(3, 1, 50, 10));
		jpl_regla.setBorder(BorderFactory.createEtchedBorder());
		jpl_regla.setBackground(Color.decode("#0B6121"));
		
		regla = new JLabel();
		regla.setForeground(colorLetter);
		regla.setFont(myFont30);
		
		regla1 = new JLabel();
		regla1.setForeground(colorLetter);
		regla1.setFont(myFont20);
		
		regla2 = new JLabel();
		regla2.setForeground(colorLetter);
		regla2.setFont(myFont20);
		
		jpl_regla.add(regla);
		jpl_regla.add(regla1);
		jpl_regla.add(regla2);
		
		jpl_puntuacion = new JPanel();
		jpl_puntuacion.setLayout(new GridLayout(3, 1));
		jpl_puntuacion.setBorder(BorderFactory.createEtchedBorder());
		jpl_puntuacion.setBackground(Color.decode("#0B6121"));
		
		jpl_puntuacion1 = new JPanel();
		jpl_puntuacion1.setBackground(Color.decode("#0B6121"));
		//jpl_puntuacion1.setBorder(BorderFactory.createEtchedBorder());
		jpl_puntuacion1.setLayout(new GridLayout(1, 2));
		
		jpl_puntuacion2 = new JPanel();
		jpl_puntuacion2.setBackground(Color.decode("#0B6121"));
		//jpl_puntuacion2.setBorder(BorderFactory.createEtchedBorder());
		jpl_puntuacion2.setLayout(new GridLayout(1, 2));
				//new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		puntuacion = new JLabel();
		puntuacion.setForeground(colorLetter);
		puntuacion.setFont(myFont30);
		
		puntuacion1 = new JLabel();
		puntuacion1.setForeground(colorLetter);
		puntuacion1.setFont(myFont20);
		
		puntuacion2 = new JLabel();
		puntuacion2.setForeground(colorLetter);
		puntuacion2.setFont(myFont20);
		
		jpl_puntuacion.add(puntuacion);
		jpl_puntuacion.add(jpl_puntuacion1);
		jpl_puntuacion.add(jpl_puntuacion2);
		
		main.add(jpl_regla, BorderLayout.NORTH);
		main.add(jpl_puntuacion, BorderLayout.CENTER);
		
		add(main);
	}
	
	public void setTextRegla(String rules){
		regla.setText(rules);
		
	}
	
	public void setTextRegla1(String rules){
		regla1.setText(rules);
		
	}
	
	public void setTextRegla2(String rules){
		regla2.setText(rules);
		
	}
	
	public void setTextPuntuacion(String rules){
		puntuacion.setText(rules);
	}
	
	public void setTextPuntuacion1(String rules){
		puntuacion1.setText(rules);
	}
	
	public void setTextPuntuacion2(String rules){
		puntuacion2.setText(rules);
	}
	
	public void setAddPuntuacion1(JPanel imagen, JPanel imagen1){
		JLabel puntos = new JLabel(" ... ");
		puntos.setForeground(Color.decode("#F2F5A9"));
		
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(1, 3));
		grid.setBackground(Color.decode("#0B6121"));
		
		JPanel jpl_imagen = new JPanel(new GridLayout(1, 1));
		jpl_imagen.add(imagen);
		jpl_imagen.setBackground(Color.decode("#0B6121"));
		
		JPanel jpl_imagen1 = new JPanel(new GridLayout(1, 1));
		jpl_imagen1.add(imagen1);
		jpl_imagen1.setBackground(Color.decode("#0B6121"));
		
		grid.add(jpl_imagen);
		grid.add(puntos);
		grid.add(jpl_imagen1);
		
		jpl_puntuacion1.add(grid);
		jpl_puntuacion1.add(puntuacion1);
	}
	
	public void setAddPuntuacion2(JPanel imagen, JPanel imagen1, JPanel imagen2){
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(1, 3));
		grid.setBackground(Color.decode("#0B6121"));
		
		JPanel jpl_imagen = new JPanel(new GridLayout(1, 1));
		jpl_imagen.add(imagen);
		jpl_imagen.setBackground(Color.decode("#0B6121"));
		
		JPanel jpl_imagen1 = new JPanel(new GridLayout(1, 1));
		jpl_imagen1.add(imagen1);
		jpl_imagen1.setBackground(Color.decode("#0B6121"));
		
		JPanel jpl_imagen2 = new JPanel(new GridLayout(1, 1));
		jpl_imagen2.add(imagen2);
		jpl_imagen2.setBackground(Color.decode("#0B6121"));
		
		grid.add(jpl_imagen);
		grid.add(jpl_imagen1);
		grid.add(jpl_imagen2);
		
		jpl_puntuacion2.add(grid);
		jpl_puntuacion2.add(puntuacion2);
	}
	
	public void runGame(){
		//pack();
		setSize(1000, 600);
		setTitle("Siete y media: Reglas del juego");
	    setLocationRelativeTo(null);   
	    setVisible(true);
	}
}
