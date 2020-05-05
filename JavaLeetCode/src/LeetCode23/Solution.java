/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode23;

public class Solution {
	 public ListNode mergeKLists(ListNode[] lists) {
		 if(lists.length == 0) return null;
		 ListNode res = lists[0];
		 for(int i = 1;i<lists.length;i++) {
			 res = mergeTwo(res,lists[i]);
		 }
		 return res;
	    }
	 public ListNode mergeTwo(ListNode a, ListNode b) {
		 ListNode head = new ListNode(0);
		 ListNode cur = head;
		 while(a != null && b != null) {
			 if(a.val > b.val) {
				 cur.next = b;
				 b = b.next;
			 }else if(a.val < b.val) {
				 cur.next = a;
				 a = a.next;
			 }else if( a.val == b.val) {
				 cur.next = a;
				 a = a.next;
				 cur = cur.next;
				 cur.next = b;
				 b = b.next;
			 }
			 cur = cur.next;
		 }
		 cur.next = a == null? b:a;
		 return head.next;
	 }
	 
	   public class ListNode {
	       int val;
	       ListNode next;
	       ListNode(int x) { val = x; }
	   }
	  
}
