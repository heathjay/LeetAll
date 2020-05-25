/**
 * 203. 移除链表元素
难度
简单

385





删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
package LeetCode203;
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	ListNode pre = dummy;
    	if(head == null) return head;
    	while(head != null) {
    		if(head.val == val) {
    			pre.next = head.next;
    			
    		}else
    			pre = head;
    		head = head.next;
    	}
    	return dummy.next;
    }
}
