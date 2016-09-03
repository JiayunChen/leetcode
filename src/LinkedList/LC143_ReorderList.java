package LinkedList;
/**
 * https://leetcode.com/problems/reorder-list/
 * 
 * Tag: Linked-list (Medium)
 * 
 * 2ms, beats 79.24%
 * O(n) time, O(1) space
 * 
 */
public class LC143_ReorderList {
	public void reorderList(ListNode head) {
        if (head != null){
            ListNode mid = head, tail = head, tmp;
            while (tail != null && tail.next != null){
                mid = mid.next;
                tail = tail.next.next;
            }
            if (tail != null){
                mid = mid.next;
                tail = null;
            }
            
            // find the mid and reverse the latter
            while (mid != null){
                tmp = mid.next;
                mid.next = tail;
                tail = mid;
                mid = tmp;
            }
            
            while (tail != null){
                tmp = tail.next;
                tail.next = head.next;
                head.next = tail;
                head = tail.next;
                tail = tmp;
            }
            head.next = null;// import!!
        }
    }
}
