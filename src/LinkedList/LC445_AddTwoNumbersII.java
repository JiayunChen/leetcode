package LinkedList;
/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 * 
 * Tag: Linked-list (Medium)
 * Add two list in order and return a linked list
 *   
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * 
 * 48ms, beats 95.13%
 * 
 */
public class LC445_AddTwoNumbersII {
	/**
	 * how to deal with the carry? -- add and reverse the result
	 * another way is to use stack, not much new idea
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, len1 = 0, len2 = 0;
        ListNode head = new ListNode(0), p, p1, p2;
        for (p1 = l1; p1 != null; p1 = p1.next, len1++);
        for (p2 = l2; p2 != null; p2 = p2.next, len2++);
        
        head.next = null;
        for (p1 = l1; len1 > len2; p1 = p1.next, len1--){
            ListNode node = new ListNode(p1.val);
            node.next = head.next;
            head.next = node;
        }
        for (p2 = l2; len2 > len1; p2 = p2.next, len2--){
            ListNode node = new ListNode(p2.val);
            node.next = head.next;
            head.next = node;
        }
        for (; p1 != null && p2 != null; p1 = p1.next, p2 = p2.next){
            ListNode node = new ListNode(p1.val + p2.val);
            node.next = head.next;
            head.next = node;
        }
        
        // deal with the carry
        for (p = head; p.next != null; p = p.next){
            if (p.next.val + carry > 9){
                p.next.val += carry - 10;
                carry = 1;
            }
            else{
                p.next.val += carry;
                carry = 0;
            }
        }
        if (1 == carry){
            ListNode node = new ListNode(1);
            node.next = null;
            p.next = node;
        }
        
        // reverse the result 
        for (p = head.next, head = null; p != null; ){
            ListNode tmp = p.next;
            p.next = head;
            head = p;
            p = tmp;
        }
        return head;
    }
}
