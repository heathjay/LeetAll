/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.


 */
package LeetCode24;

public class Solution {
	public class ListNode {
		    int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	/**
	 * 递归
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode first = head;
		ListNode second = head.next;
		
		first.next = swapPairs(second.next);
		second.next = first;
		
		return second;
    }
	/**
	 * 迭代
	 */
	public ListNode swap(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode pre = dummy;
		
		while(head != null && head.next !=null) {
			ListNode first = head;
			ListNode second = head.next;
			
			pre.next = second;
			first.next = second.next;
			second.next = first;
			
			pre = first;
			head = first.next;
		}
		
		return dummy.next;
	}
}
