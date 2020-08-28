import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
	private List<Card> cards;
	private int shuffleIndex;
	public Deck() {
		cards = new LinkedList<>();
		for(int i = 0 ; i < 13; i++) {
			CardValue value = CardValue.values()[i];
			for(int j = 0; j < 4; j++) {
				cards.add(new Card(value, Suit.values()[j]));
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
		shuffleIndex = 0;
	}
	
	public List<Card> deal(int num) {
		List<Card> cards = new LinkedList<>();
		for(int i = 0; i < num; i++) {
			Card card = deal();
			if(card == null) return null;
			cards.add(card);
		}
		return cards;
	}
	
	public Card deal() {
		return cards.size() > 1 ? cards.get(shuffleIndex++) : null;  
	}
}
