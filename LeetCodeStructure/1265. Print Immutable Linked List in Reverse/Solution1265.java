
public class Solution1265 {
	interface ImmutableListNode {
		public void printValue(); // print the value of this node.

		public ImmutableListNode getNext(); // return the next node.
	};

	class Solution {
		public void printLinkedListInReverse(ImmutableListNode head) {
			DFSPrint(head);
		}

		private void DFSPrint(ImmutableListNode head) {
			if (head == null)
				return;
			DFSPrint(head.getNext());
			head.printValue();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
