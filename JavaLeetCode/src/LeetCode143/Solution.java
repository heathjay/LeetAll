/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorder-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode143;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
	/**
	 * 递归
	 * @param head
	 */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        int len = 0;
        ListNode h = head;
        while(h != null) {
        	len++;
        	h = h.next;
        }
        reorderListHelper(head,len);
    }
    private ListNode reorderListHelper(ListNode head,int len) {
    	if(len == 1) {
    		ListNode outTail = head.next;
    		head.next = null;
    		return outTail;
    	}
    	if(len == 2) {
    		ListNode outTail = head.next.next;
    		head.next.next = null;
    		return outTail;
    	}
    	
    	ListNode tail = reorderListHelper(head.next, len-2);
    	ListNode subHead =head.next;
    	head.next = tail;
    	ListNode outTail = tail.next;
    	tail.next = subHead;
    	return outTail;
    }
    /**
     * 
     * @param head
     */
    public void reorderList1(ListNode head) {
    	if(head == null || head.next == null || head.next.next == null) return;
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	ListNode newHead = slow.next;
    	slow.next = null;
    	newHead = reverseList(newHead);
    	while(newHead != null) {
    		ListNode temp = newHead.next;
    		newHead.next = head.next;
    		head.next = newHead;
    		head = newHead.next;
    		newHead = temp;
    	}
    }
    private ListNode reverseList(ListNode head) {
    	if(head == null) {
    		return null;
    	}
    	ListNode tail = head;
    	head = head.next;
    	tail.next = null;
    	while(head != null) {
    		ListNode temp = head.next;
    		head.next = tail;
    		tail = head;
    		head = temp;
    	}
    	return tail;
    }
}
