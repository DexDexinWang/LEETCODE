import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BlackJackHand extends Hand {

	public BlackJackHand(String name) {
		super(name);
	}

	
	public List<Integer> calcualteScore() {
		List<Integer> scores = new LinkedList<>();
		Deque<Integer> que = new LinkedList<>();
		int index = 0;
		while (index < cards.size()) {
			List<Integer> possibleScores = getPossibleScores(cards.get(index++));
			int size = que.size();
			for(int currScore: possibleScores) {
				if(size == 0) {
					que.offerLast(currScore);
				} else {
					for(int i =0; i < size; i++) {
						que.offerLast(currScore + que.pollFirst());
					}
				}
				
			}
			
			
		}	
		return scores;
	}
	
	public List<Integer> getPossibleScores(Card card) {
		List<Integer> possibleScores = new LinkedList<>();
		possibleScores.add(card.value.getCardValue());
		if(card.value == CardValue.ACE) {
			possibleScores.add(10);
		}
		return possibleScores;
	}
	
	public boolean isBackJack() {
		List<Integer> scores =calcualteScore();
		for(int score : scores) {
			if (score == 21) return true;
		}
		return false;
	}
}
