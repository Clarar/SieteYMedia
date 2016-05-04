package halfPastSeven;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;

public class ViewCard extends JPanel {
	
	private Image card;
	private int y;
	private int x;
	
	public ViewCard(Image card){
		this(card,75,115);
	}
	
	public ViewCard(Image card, int x, int y){

		setLayout(new GridLayout(1, 1,5,5));	
		this.card = card;
		setBackground(Color.decode("#0B6121"));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    
	    g.drawImage(card,0,0,75, 115, null);
	}
	
}
