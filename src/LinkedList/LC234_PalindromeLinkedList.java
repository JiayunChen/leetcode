package LinkedList;
/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * Tag: Linked-list (Easy)
 * 
 * 4ms, beats 15.72%
 * n time, n space
 * 
 */
public class LC234_PalindromeLinkedList {
	 public boolean isPalindrome(ListNode head) {
	        if (head == null || head.next == null){
	            return true;
	        }
	        
	        // use slow and fast to reverse only half of the list
	        ListNode slow = head, fast = head;
	        while (fast != null && fast.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        // remember: can NOT access the value without allocating space!
	        slow = reverse(slow);
	        
	        // compare
	        while (slow != null){
	            if (slow.val != head.val){
	                return false;
	            }
	            slow = slow.next;
	            head = head.next;
	        }
	        
	        return true;
	    }
	    
	    private ListNode reverse(ListNode head){
	        ListNode tail = new ListNode(head.val);
	        tail.next = null;
	        while (head.next != null){
	            ListNode cur = new ListNode(head.next.val);
	            cur.next = tail;
	            tail = cur;
	            head = head.next;
	        }
	        return tail;
	    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
