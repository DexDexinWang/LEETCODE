
public class Solution348 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class TicTacToe {
	    
	    int[] rowOne;
	    int[] colOne;
	    int diaForwardOne;
	    int diaBackwardOne;
	    
	    int[] rowTwo;
	    int[] colTwo;
	    int diaForwardTwo;
	    int diaBackwardTwo;
	    int n;
	    /** Initialize your data structure here. */
	    public TicTacToe(int n) {
	        this.n = n;
	        rowOne = new int[n];
	        rowTwo = new int[n];
	        colOne = new int[n];
	        colTwo = new int[n];
	        diaForwardOne = 0;
	        diaBackwardOne = 0;
	        diaForwardTwo = 0;
	        diaBackwardTwo = 0;
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    public int move(int row, int col, int player) {
	        if(player == 1) {
	            rowOne[row]++;
	            colOne[col]++;
	            if(rowOne[row] == n||colOne[col] == n) return 1;
	            if(row == col) {
	                diaForwardOne++;
	                if(diaForwardOne == n) return 1;
	            } 
	            if (row + col == n - 1) {
	                diaBackwardOne++;
	                if(diaBackwardOne == n) return 1;
	            }
	        } else {
	            rowTwo[row]++;
	            colTwo[col]++;
	            if(rowTwo[row] == n||colTwo[col] == n) return 2;
	            if(row == col) {
	                diaForwardTwo++;
	                if(diaForwardTwo == n) return 2;
	            } 
	            if (row + col == n - 1) {
	                diaBackwardTwo++;
	                if(diaBackwardTwo == n) return 2;
	            }
	        }
	        return 0;
	    }
	}

}
