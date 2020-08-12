
public class AmazonFreshPromotion {

	public static void main(String[] args) {
		String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7 = { { "apple", "apple","banana" }  };
        String[] shoppingCart7 = {"apple", "apple","apple", "banana"};

        System.out.println(solve(codeList1, shoppingCart1));
        System.out.println(solve(codeList2, shoppingCart2));
        System.out.println(solve(codeList3, shoppingCart3));
        System.out.println(solve(codeList4, shoppingCart4));
        System.out.println(solve(codeList5, shoppingCart5));
        System.out.println(solve(codeList6, shoppingCart6));
        System.out.println(solve(codeList7, shoppingCart7));
	}
	
	//The question is considerting the order of each shoppingCard, hence it will consider below situations:
	//For each codeList with N lenght, if cannot find consecutive mahching products from i to N, it will go to i+1 to check from i+1 to N+1
	//Otherwise, it will check next codeList until all coList is traversed or maching products is not enough. 
	private static int solve(String[][] codeList, String[] shoppingCart) {
		if(shoppingCart == null || shoppingCart.length == 0) return 0;
		if(codeList == null || codeList.length == 0) return 1;
		int listId = 0;
		int totalChecked =0;
		while(listId < codeList.length && totalChecked + codeList[listId].length <= shoppingCart.length) {
			boolean isMatch = true;
			for(int i = 0; i < codeList[listId].length; i++) {
				if(codeList[listId][i]!=shoppingCart[totalChecked + i] && !codeList[listId][i].equals("anything")) {
					isMatch = false;
					break;
				}
			}
			if(isMatch) {
				totalChecked+=codeList[listId].length;
				listId++;
			} else {
				totalChecked++;
			}
		}
		return listId == codeList.length ? 1: 0;
	}
}
