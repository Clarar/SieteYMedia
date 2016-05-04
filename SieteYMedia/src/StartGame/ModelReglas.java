package StartGame;
import halfPastSeven.ViewCard;

import javax.swing.ImageIcon;

public class ModelReglas {
	private String reglas;
	private String reglas1;
	private String reglas2;
	private String puntuacion;
	private String puntuacion1;
	private String puntuacion2;
	private ImageIcon uno;
	private ImageIcon siete;
	private ImageIcon diez;
	private ImageIcon once;
	private ImageIcon doce;
	
	public ModelReglas(){
		uno = new ImageIcon("baraja/31.jpg");
		siete = new ImageIcon("baraja/37.jpg");
		diez = new ImageIcon("baraja/38.jpg");
		once = new ImageIcon("baraja/39.jpg");
		doce = new ImageIcon("baraja/40.jpg");
		
		reglas = " Las reglas del juegos se basan en:";
		reglas1 = "  - Gana quien más se aproxime al 7.5.";
		reglas2 = "  - Si alguno de los dos jugadores se pasa del 7.5, gana su oponente.\n";
		
		puntuacion = "Los puntos se repartirán de la siguiente forma:";
		puntuacion1 = " = Darán los mismo puntos que numero tienen sus cartas.";
		puntuacion2 = " = Dán medio punto cada una.";
		
		
	}
	
	public String getReglas(){
		return reglas;
	}
	
	public String getReglas1(){
		return reglas1;
	}
	
	public String getReglas2(){
		return reglas2;
	}
	
	public String getPuntuacion(){
		return puntuacion;
	}
	
	public String getPuntuacion1(){
		return puntuacion1;
	}
	public String getPuntuacion2(){
		return puntuacion2;
	}
	
	public void setPuntuacion(String text){
		puntuacion = text;
	}
	
	public ImageIcon getUno() {
		return uno;
	}

	public ImageIcon getSiete() {
		return siete;
	}

	public ImageIcon getDiez() {
		return diez;
	}

	public ImageIcon getOnce() {
		return once;
	}

	public ImageIcon getDoce() {
		return doce;
	}
	
}
