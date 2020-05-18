/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode112;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	/**
	 * 递归
	 * @param root
	 * @param sum
	 * @return
	 */
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) return false;
    	sum -= root.val;
    	if((root.left == null) && (root.right == null)) return (sum == 0);
    	return hasPathSum(root.left,sum) || hasPathSum(root.right,sum)	;
    }
    public boolean xx(TreeNode root, int sum) {
    	if(root == null) return false;
    	
    	LinkedList<TreeNode> node_stack = new LinkedList<>();
    	LinkedList<Integer> sum_stack = new LinkedList<>();
    	node_stack.add(root);
    	sum_stack.add(sum - root.val);
    	TreeNode node;
    	int cur_sum;
    	while(!node_stack.isEmpty()) {
    		node = node_stack.poll();
    		cur_sum = sum_stack.poll();
    		if((node.right == null) && (node.left == null) && cur_sum == 0	) {
    			return true;
    		}
    		if(node.right != null) {
    			node_stack.add(node.right);
    			sum_stack.add(cur_sum - node.right.val);
    		}
    		if(node.left != null) {
    			node_stack.add(node.left);
    			sum_stack.add(cur_sum - node.left.val);
    		}
    		
    	}
    	return false;
    }
}
