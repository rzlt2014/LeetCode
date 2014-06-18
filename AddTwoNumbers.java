package leetcodeDetail;
/*
 * Add Two Numbers
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	     if (l1 == null) return l2;
	     if (l2 == null) return l1;
	        
	     ListNode head = new ListNode(0);
	     ListNode cur = head;
	     int carray = 0;
	        
	     while (l1 != null || l2 != null) {
	         int v1 = l1 == null ? 0 : l1.val;
	         int v2 = l2 == null ? 0 : l2.val;
	         int t = v1 + v2 + carray;
	         cur.next = new ListNode(t % 10);
	         carray = t / 10;
	            
	         l1 = l1 == null ? null : l1.next;
	         l2 = l2 == null ? null : l2.next;
	         cur = cur.next;
	        }
	        
	        if (carray != 0)
	            cur.next = new ListNode(carray);
	       
	        return head.next;
	 }

	public static void main(String[] args) {
		AddTwoNumbers r = new AddTwoNumbers();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		l2.next  = new ListNode(9);
		ListNode l = r.addTwoNumbers(l1, l2);
		while (l != null) {
			System.out.print(l.val + " ");
			l = l.next;
		}
	}
}
