package halfPastSeven;

import java.util.ArrayList;
import java.util.Collections;

public class ModelDeckOfCards {
	
	private ArrayList<ModelCard> deck;
	private ArrayList<ModelCard> deck_rearward;
	
	private int top;
	
	public ModelDeckOfCards(){
		this.deck = new ArrayList<ModelCard>();
		this.deck_rearward = new ArrayList<ModelCard>();
		this.top = 0;
		for (int i = 1; i <= 40; i++) {
			deck.add(new ModelCard(i));
			deck_rearward.add(new ModelCard());
		}
	}
	
	public void shuffleDeck(){
		Collections.shuffle(deck);
	}
	
	public ModelCard getCard(){
		return deck.get(top);
	}
	
	public ModelCard getCardRearward(){
		return deck_rearward.get(0);
	}
	
	public void incrementTop(){
		top++;
	}
}
