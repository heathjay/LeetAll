/**
 * 给定一个二叉树

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

 

进阶：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 

示例：



输入：root = [1,2,3,4,5,null,7]
输出：[1,#,2,3,#,4,5,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode117;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class Solution {
    public Node connect(Node root) {
        LinkedList<Node > list = new LinkedList<Node>();
        if(root == null) return root;
        list.add(root);
        
        while(!list.isEmpty()) {
        	int len = list.size();
        	Node pre = null;
        	for(int i = 0; i < len; i++) {
        		Node node = list.poll();
        		if(node.left != null) {
        			if(pre != null) pre.next = node.left;
        			pre = node.left;
        			list.addLast(node.left);
        		}
        		if(node.right != null) {
        			if(pre != null) pre.next = node.right;
        			pre = node.right;
        			list.addLast(node.right);
        		}
        	}
        }
        return root;
    }
    /**
     * 层序遍历写法
     * @param root
     * @return
     */
    public Node connect1(Node root) {
    	if(root == null ) return root;
    	
    	Queue<Node> Q  = new LinkedList<>();
    	Q.add(root);
    	
    	while(Q.size() > 0) {
    		int size = Q.size();
    		for(int i = 0; i < size; i ++) {
    			Node node = Q.poll();
    			if(i<size -1) {
    				node.next = Q.peek()	;
    			}
    			if(node.left!=null) Q.add(node.left);
    			if(node.right != null) Q.add(node.right);
    		}
    	}
    	return root;
    }
    Node prev, leftmost;
    public void processChild(Node childNode) {
    	if(childNode != null) {
    		if(this.prev != null) {
    			this.prev.next = childNode;
    		}else {
    			this.leftmost = childNode;
    		}
    		this.prev = childNode;
    	}
    }
    public Node connect2(Node root) {
    	if(root == null) return root;
    	this.leftmost = root;
    	Node curr = leftmost;
    	while(this.leftmost != null) {
    		this.prev = null;
    		curr = this.leftmost;
    		this.leftmost = null;
    		while(curr!=null) {
    			this.processChild(curr.left);
    			this.processChild(curr.right);
    			curr =curr.next;
    		}
    	}
    	return root;
    }
}
