/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4


 */
package LeetCode21;

public class Solution {
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 	ListNode dummy = new ListNode(0);
		 	ListNode cur = dummy;
		 	while(true) {
		 		//退出条件
		 		if(l1 == null && l2 == null) return dummy.next;
		 		if(l1 == null && l2 != null) {
		 			cur.next = l2;
		 			return dummy.next;
		 		}
		 		if(l1 != null && l2 == null) {
		 			cur.next = l1;
		 			return dummy.next;
		 		}
		 		
		 		//取出值 
		 		int x = l1.val;
		 		int y = l2.val;
		 		//比较
		 		if(x>y) {
		 			cur.next = new ListNode(y);
		 			l2 =( l2.next == null)? null : l2.next;
		 		}else if(x < y )  {
		 			cur.next = new ListNode(x);
		 			l1 = (l1.next == null)? null : l1.next;
		 		}else if(x==y) {
		 			cur.next = new ListNode(x);
		 			cur = cur.next;
		 			cur.next = new ListNode(y);
		 			l2 =( l2.next == null)? null : l2.next;
		 			l1 = (l1.next == null)? null : l1.next;
		 		}
		 		cur = cur.next;
		 	}
	    }
	 public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		 ListNode dummy = new ListNode(0);
		 	ListNode cur = dummy;
		 	while(l1 != null && l2 != null) {
		 		if(l1.val > l2.val) {
		 			cur.next = new ListNode(l2.val);
                  l2 = l2.next;
		 		}else if(l1.val < l2.val) {
		 			cur.next = new ListNode(l1.val);
                  l1 = l1.next;
		 		}else if(l1.val == l2.val) {
		 			cur.next = new ListNode(l1.val);
		 			cur = cur.next;
		 			cur.next = new ListNode(l2.val);
                  l1 = l1.next;
                  l2 = l2.next;
		 		}
		 		cur = cur.next;
		 	}
		 	cur.next = (l1 == null) ? l2 : l1;
		 	return dummy.next;
	 }
	 
	   public class ListNode {
	       int val;
	       ListNode next;
	       ListNode(int x) { val = x; }
	   }
	  
}
