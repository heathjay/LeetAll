/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 

示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode25;

import java.util.Stack;

import LeetCode23.Solution.ListNode;

public class Solution {
	/**
	 * 堆栈
	 * @param head
	 * @param k
	 * @return
	 */
	 public ListNode reverseKGroup12(ListNode head, int k) {
		 Stack<ListNode> stack = new Stack<ListNode>();
		 ListNode dummy = new ListNode(-1);
		 dummy.next = head;
		 ListNode cur = dummy;
		 while(head != null) {
		
			 for(int i = 0;i< k;i++) {
				 if(head == null) break;
				 stack.push(head);
				 head = head.next;
			 }
			 if(stack.size() < k) break;
			 while(!stack.isEmpty()) {
				 cur.next = stack.pop();
				 cur = cur.next;
			 }
		 }
		 ListNode pre = new ListNode(0);
		 while(!stack.isEmpty()) {
			 ListNode list = stack.pop();
			 list.next= pre.next;
			 pre.next = list;
		 }
		 cur.next = pre.next;
		 return dummy.next;
	 }
	 public ListNode reverseKGroup(ListNode head, int k) {
		 ListNode dummy = new ListNode(-1);
		 dummy.next = head;
		 
		 ListNode pre = dummy;
		 ListNode end = dummy;
		 while(end.next!=null) {
			 for(int i = 0;i < k && end != null;i++) end = end.next;
			 if(end == null) break;
			 ListNode start = pre.next;
			 ListNode next = end.next;
			 end.next = null;
			 pre.next = reverse(start);
			 start.next = next;
			 pre = start;
			 end = pre;
		 }
		 return dummy.next;
		 
	 }
	 
	 public ListNode reverse(ListNode head) {
		 ListNode pre = null;
		 ListNode cur = head;
		 while(cur!=null) {
			 ListNode next = cur.next;
			 cur.next = pre;
			 pre = cur;
			 cur = next;
		 }
		 return pre;
	 }
	 public class ListNode {
	       int val;
	       ListNode next;
	       ListNode(int x) { val = x; }
	 }
}
