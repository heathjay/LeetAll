/**
 * 给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode145;

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
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	postorder(res,root);
    	return res;
    }
    public void postorder(List<Integer> res, TreeNode root) {
    	if(root == null) return ;
    	postorder(res,root.left);
    	postorder(res, root.right);
    	res.add(root.val);
    }
    
    public List<Integer> postorderTraversal1(TreeNode root) {
    	LinkedList<Integer> res = new LinkedList<>();
    	LinkedList<TreeNode> list = new LinkedList<>();
    	list.add(root);
    	while(!list.isEmpty()) {
    		TreeNode node= list.removeLast();
    		res.addFirst(node.val);
    		if(node.left !=null) list.add(node.left);
    		if(node.right != null) list.add(node.right);
    	}
    	return res;
    }
}
