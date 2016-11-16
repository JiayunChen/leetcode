package LinkedList;
/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * Tag: Linked-list (Medium)
 * Add two list in reverse order
 * similar with add string, nothing new, be careful with the carry(especially the last one)
 *  
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * 48ms, beats 95.13%
 * 
 */
public class LC2_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode p = head;
        head.next = null;
        for ( ; l1 != null && l2 != null; l1=l1.next, l2=l2.next){
            int sum = l1.val + l2.val + carry;
            carry = (sum > 9)? 1: 0;
            ListNode node = new ListNode(sum % 10);
            node.next = null;
            p.next = node;
            p = p.next;
        }
        for ( ; l1 != null; l1=l1.next){
            if (l1.val + carry > 9){
                l1.val += carry - 10;
                carry = 1;
            }
            else{
                l1.val += carry;
                carry = 0;
                
            }
            ListNode node = new ListNode(l1.val);
            node.next = null;
            p.next = node;
            p = p.next;
        }
        for ( ; l2 != null; l2=l2.next){
            if (l2.val + carry > 9){
                l2.val += carry - 10;
                carry = 1;
            }
            else{
                l2.val += carry;
                carry = 0;
                
            }
            ListNode node = new ListNode(l2.val);
            node.next = null;
            p.next = node;
            p = p.next;
        }
        if (carry == 1){
            ListNode node = new ListNode(1);
            node.next = null;
            p.next = node;
            p = p.next;
        }
        return head.next;
    }
}

