import java.util.LinkedList;
import java.util.List;

public class BlackJackAuto {

	private Deck deck;
	private BlackJackHand[] hands;
	public BlackJackAuto(int players, String[] names){
		hands = new BlackJackHand[players];
		for(int i = 0; i < players; i++) {
			hands[i] = new BlackJackHand(names[i]);
		}
		deck = new Deck();
	}
	
	public void Play() {
		shuffle();
		dealInit();
		List<BlackJackHand> winners = getBlackJack();
		if(winners.size() >= 1) {
			for(BlackJackHand hand : winners) {
				System.out.println("The winnner is:" + hand.name);
			}
		}
		System.out.println("There is no winner.");
	}
	
	public void shuffle() {
		deck.shuffle();
	}
	
	public boolean dealInit() {
		for(BlackJackHand bHand: hands) {
			List<Card> cards = deck.deal(2);
			if(cards == null) return false;
			bHand.addCards(cards);
		}
		return true;
	}
	
	public List<BlackJackHand> getBlackJack(){
		List<BlackJackHand> winners = new LinkedList<>();
		for(BlackJackHand hand: hands) {
			if(hand.isBackJack()) {
				winners.add(hand);
			}
		}
		return winners;
	}
}
