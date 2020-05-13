/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode83;



class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	ListNode p = dummy;
    	while(p.next != null && p.next.next != null	) {
    		if(p.next.next!=null && p.next.val == p.next.next.val) {
    			p.next.next = p.next.next.next;
    		}else {
    			p = p.next;
    		}
    	}
    	return dummy.next;
    }
}
