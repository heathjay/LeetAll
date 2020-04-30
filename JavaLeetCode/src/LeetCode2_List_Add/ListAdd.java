package LeetCode2_List_Add;
/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jay
 *
 */


public class ListAdd {
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode rs = new ListNode(0);
		 ListNode curr = rs;
		 int remains = 0;
		 while(l1 !=null ||l2 != null) {
			int x = (l1==null)?0:l1.val;
		 	int y = (l2==null)?0:l2.val;
		 	int sum = x+ y + remains;
			remains = sum / 10;
		 	sum = sum % 10;
		 	curr.next= new ListNode(sum);
		 	curr = curr.next;
		 	l1=(l1==null)? null:l1.next;
		 	l2=(l2==null)? null:l2.next;
		 }
		 if (remains > 0) {
		      curr.next = new ListNode(remains);
		  }
		 	return rs.next;
	    }
	 public static void main(String[] args) {
		ListNode p1 = new ListNode(3);
		ListNode p2 = new ListNode(4);
		ListNode p3 = new ListNode(2);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(6);
		ListNode p6 = new ListNode(5);
		
		p3.next = p2;
		p2.next = p1;
		
		p6.next = p5;
		p5.next = p4;
		
		
		ListNode rs = addTwoNumbers(p3,p6);
		System.out.println(rs.val);
	 }
}
