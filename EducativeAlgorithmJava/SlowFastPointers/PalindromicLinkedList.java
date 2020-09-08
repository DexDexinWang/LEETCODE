class PalindromicLinkedList {

  public static boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) return true;
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode newHeader = Reverse(slow.next);
    while(newHeader != null) {
      if(head.value != newHeader.value) {
        return false;
      }
      head = head.next;
      newHeader = newHeader.next;
    }
    return true;
  }

  public static ListNode Reverse(ListNode head) {
    ListNode dummy = new ListNode(-1);
    while(head != null) {
      ListNode next = head.next;
      head.next = dummy.next;
      dummy.next = head;
      head = next;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    //System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    //2 4 6 4 2 2 
  }
}