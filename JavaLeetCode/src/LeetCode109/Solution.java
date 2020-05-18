/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode109;

import java.util.ArrayList;
import java.util.List;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
	private ListNode findMiddleElement(ListNode head) {
		ListNode prevPtr = null;
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			prevPtr = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		if(prevPtr != null) {
			prevPtr.next = null;
		}
		return slowPtr;
	}
    public TreeNode sortedListToBST(ListNode head) {
    	if(head == null) return null;
    	ListNode mid = this.findMiddleElement(head);
    	
    	TreeNode node = new TreeNode(mid.val);
    	if(head == mid) {
    		return node;
    	}
    	
    	node.left = this.sortedListToBST(head);
    	node.right = this.sortedListToBST(mid.next);
    	return node;
    }
    /**
     * 空间换时间
     */
    private List<Integer> values;
    public Solution() {
    	this.values = new ArrayList<Integer>();
    }
    private void mapListToValues(ListNode head) {
    	while(head != null) {
    		this.values.add(head.val);
    		head = head.next;
    	}
    }
    
    private TreeNode convertListToBST(int left, int right) {
    	if(left > right) return null;
    	int mid = (left + right) / 2;
    	TreeNode root = new TreeNode(this.values.get(mid));
    	if(left == right) return root;
    	root.left = this.convertListToBST(0,  mid -1);
    	root.right = this.convertListToBST(mid+1, right);
    	return root;
    }
    public TreeNode sortedLT(ListNode head) {
    	this.mapListToValues(head);
    	return this.convertListToBST(0, this.values.size() - 1);
    }
}