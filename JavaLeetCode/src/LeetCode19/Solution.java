/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode19;

public class Solution {
	  public ListNode removeNthFromEnd(ListNode head, int n) {
		  if(head == null) return null;
	         ListNode temp = new ListNode(0);
	         temp.next = head;
			  ListNode first = temp;
			  ListNode cur = temp;
			  for(int i = 0 ; i <= n; i ++) {
				first = first.next;
			  }
			  while(first != null) {
				  first = first.next;
				  cur = cur.next;
			  }
			  cur.next = cur.next.next;
			  return temp.next;
	  }
	  
	  
	    public class ListNode {
	        int val;
	        ListNode next;
	        ListNode(int x) { val = x; }
	    }
	   
}
