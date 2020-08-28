import java.util.LinkedList;
import java.util.List;

public class Hand {
	protected List<Card> cards = new LinkedList<>();
	public String name;
	
	public Hand(String name) {
		this.name = name;
	}
	
	public void init() {
		cards = new LinkedList<>();
	}
	
	public void addCards(List<Card> cards) {
		for(Card card: cards) {
			this.cards.add(card);
		}
	}
	
}
