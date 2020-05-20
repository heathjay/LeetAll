/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的 深拷贝。 

我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 

示例 1：



输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：



输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：



输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode138;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution {
	/**
	 * 回溯
	 */
	HashMap<Node, Node> visitedHash = new HashMap<>();
    public Node copyRandomList(Node head) {
    	if(head == null) return null;
    	
    	if(this.visitedHash.containsKey(head)) {
    		return this.visitedHash.get(head);
    	}
    	Node node = new Node(head.val);
    	this.visitedHash.put(head, node);
    	node.next = this.copyRandomList(head.next);
    	node.random = this.copyRandomList(head.random);
    	return node;
    }
    /**
     * 迭代
     */
    HashMap<Node,Node> visited = new HashMap<>();
    public Node getNode(Node node) {
    	if(node != null) {
    		if(this.visited.containsKey(node)) {
    			return this.visited.get(node);
    		}else {
    			this.visited.put(node, new Node(node.val));
    			return this.visited.get(node);
    		}
    	}
    	return null;
    }
    public Node copyNode(Node head) {
    	if(head == null) return null;
    	Node oldNode =head;
    	Node newNode = new Node(oldNode.val);
    	this.visited.put(oldNode, newNode);
    	while(oldNode != null) {
    		newNode.random = this.getNode(oldNode.random);
    		newNode.next = this.getNode(oldNode.next);
    		oldNode = oldNode.next;
    		newNode = newNode.next;
    	}
    	return this.visited.get(head);
    }
    /**
     * 空间优化
     */
    public Node co(Node head) {
    	if(head == null) return null;
    	Node ptr = head;
    	while(ptr != null) {
    		Node newNode = new Node(ptr.val);
    		newNode.next = ptr.next;
    		ptr.next = newNode;
    		ptr = newNode.next;
    	}
    	ptr= head;
    	
    	while(ptr != null) {
    		ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
    		ptr = ptr.next.next;
    	}
    	Node ptr_old_list = head;
    	Node ptr_new_list = head.next;
    	Node head_old = head.next;
    	while(ptr_old_list != null) {
    		ptr_old_list.next = ptr_old_list.next.next;
    		ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
    		ptr_old_list = ptr_old_list.next;
    		ptr_new_list = ptr_new_list.next;
    	}
    	return head_old;
    }
}
