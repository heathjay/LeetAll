/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode92;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Solution {
	private boolean stop;
	private ListNode left;
	public void recurseAndRev(ListNode right,int m, int n) {
		if(n==1) {
			return;
		}
		right = right.next;
		if(m > 1) {
			this.left = this.left.next ;
		}
		this.recurseAndRev(right, m-1, n-1);
		if(this.left == right || right.next == this.left) {
			this.stop = true;
		}
		if(!this.stop) {
			int t = this.left.val;
			this.left.val = right.val;
			right.val = t;
			this.left = this.left.next;
		}
	}
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	this.left = head;
    	this.stop = false;
    	this.recurseAndRev(head,m,n);
    	return head;
    }
}
