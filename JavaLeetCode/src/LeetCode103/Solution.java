/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	if(root == null) {
    		return new ArrayList<List<Integer>>();
    	}
    	
    	List<List<Integer>> res = new ArrayList<>();
    	
    	LinkedList<TreeNode> node_queue = new LinkedList<TreeNode> ();
    	node_queue.addLast(root);
    	node_queue.addLast(null);
    	
    	LinkedList<Integer> level_list = new LinkedList<Integer>();
    	boolean is_order_left = true;
    	
    	while(!node_queue.isEmpty()) {
    		TreeNode curr = node_queue.pollFirst();
    		if(curr != null) {
    			if(is_order_left) {
    				level_list.addLast(curr.val);
    			}else {
    				level_list.addFirst(curr.val);
    			}
    			
    			if(curr.left != null) {
    				node_queue.addLast(curr.left);
    			}
    			if(curr.right != null) {
    				node_queue.addLast(curr.right);
    			}
    		}else {
    			res.add(level_list);
    			level_list = new LinkedList<Integer>();
    			if(node_queue.size() > 0) {
    				node_queue.addLast(null);
    			}
    			is_order_left = !is_order_left;
    		}
    	}
    	return res;
    	
    	
    }
}
