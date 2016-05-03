package halfPastSeven;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ModelCard {
	private int numero;
	private String suit;
	private Image card;
	private int num_card;
	
	public ModelCard(int num){
		this.numero = num;
		this.card = new ImageIcon("baraja/"+numero+".jpg").getImage();
		this.suit = returnSuit();
		this.num_card = returnNumCard();
	}
	public ModelCard(){
		this.card = new ImageIcon("baraja/trasero.jpg").getImage();
	}

	private String returnSuit() {
		switch (this.numero/11) {
		case 0:
			return "Basto";
		case 1:
			return "Copa";	
		case 2:
			return "Espada";
		case 3:
			return "Oro";
		}
		return "";
	}
	
	private int returnNumCard() {
		int entero = numero%10;
		
		switch (entero) {
		case 8:
			entero = 10;
			break;
		case 9:
			entero = 11;
			break;
		case 0:
			entero = 12;
			break;
		}
		return entero;
	}
	
	public Image getImageCard(){
		return card;
	}
	
	public int getNumCard(){
		return num_card;
	}
	
	public int getNumero(){
		return numero;
	}
	
	public void setNumCard(int num_card){
		this.num_card = num_card;
	}
	
	public String getSuit(){
		return suit;
	}
}
