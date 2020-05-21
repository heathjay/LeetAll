
/**
 * 给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode144;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	preorder(root,res);
    	return res;
    }
    public void preorder(TreeNode root, List<Integer> res) {
    	if(root == null) return;
    	res.add(root.val);
    	preorder(root.left,res);
    	preorder(root.right,res);
    }
    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
    	LinkedList<TreeNode> stack = new LinkedList<>();
    	LinkedList<Integer> output = new LinkedList<>();
    	
    	if(root == null) return output;
    	stack.add(root);
    	while(!stack.isEmpty()) {
    		TreeNode node = stack.pollLast()	;
    		output.add(node.val);
    		if(node.right != null) stack.add(node.right);
    		if(node.left != null) stack.add(node.left);
    	}
    	return output;
    }
}
