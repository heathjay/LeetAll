/**
 * 给定一个二叉树，原地将它展开为一个单链表。

 

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode114;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public void flatten(TreeNode root) {
        while(root != null) {
        	if(root.left == null) root = root.right;
        	else {
        		TreeNode pre = root.left;
        		while(pre.right != null) pre = pre.right;
        		pre.right = root.right;
        		root.right = root.left;
        		root.left = null;
        		root = root.right;
        	}
        }
    }
    /**
     * 递归前序，反向
     * 6-5-4-3-2-1
     */
    private TreeNode pre = null;
    public void flatten2(TreeNode root) {
    	if(root == null) return ;
    	flatten2(root.right);
    	flatten2(root.left);
    	root.right = pre;
    	root.left = null;
    	pre = root;
    }
    /**
     * 迭代
     * @param root
     */
    public void flatten3(TreeNode root) {
    	Stack<TreeNode> toVisit = new Stack<>();
    	TreeNode cur = root;
    	TreeNode pre = null;
    	
    	while(cur != null || !toVisit.isEmpty()) {
    		while(cur != null) {
    			toVisit.push(cur);
    			cur = cur.right;
    		}
    		cur = toVisit.peek();
    		if(cur.left == null || cur.left == pre) {
    			toVisit.pop();
    			cur.right = pre;
    			cur.left = null;
    			pre = cur;
    			cur =null;
    		}else {
    			cur = cur.left;
    		}
    	}
    }
}
