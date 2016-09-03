package Practice.Graph;

public class BinarySearchTree {
	public static void main(String[] args){
		int[] val = {5,4,1,8,6,3,2,7,9};
		ListNode head = new ListNode(val[0]);
		ListNode p = head;
		for (int i = 1; i < val.length; i++){
			ListNode node = new ListNode(val[i]);
			p.next = node;
			p = p.next;
		}
		
		TreeNode root = convertListToTree(head);
		print(root);
	}
	
	public static void print(TreeNode root){
		System.out.print(root.val);
		if (root.left != null){
			print(root.left);
		}
		if (root.right != null){
			print(root.right);
		}
	}
	
	public static TreeNode convertListToTree(ListNode head){
		if (head == null){
			return null;
		}
		TreeNode root = new TreeNode(head.val);
		TreeNode curNode = root;
		for(head = head.next; head != null; ){
			if (head.val <= curNode.val){
				if (curNode.left == null){
					TreeNode node = new TreeNode(head.val);
					curNode.left = node;
					head = head.next;
					curNode = root;
				}
				else{
					curNode = curNode.left;
				}
			}
			else{
				if (curNode.right == null){
					TreeNode node = new TreeNode(head.val);
					curNode.right = node;
					head = head.next;
					curNode = root;
				}
				else{
					curNode = curNode.right;
				}
			}
		}
		return root;
	}
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

