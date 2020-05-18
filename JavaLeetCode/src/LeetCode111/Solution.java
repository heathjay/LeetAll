/**
 * 给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode111;

import java.util.LinkedList;

import javafx.util.Pair;

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
	 * @return
	 */
    public int minDepth(TreeNode root) {
    	if(root == null) return 0;
    	if((root.left == null) && (root.right == null)) {
    		return 1;
    	}
    	
    	int min_depth = Integer.MAX_VALUE;
    	if(root.left != null) {
    		min_depth = Math.min(minDepth(root.left), min_depth);
    	}
    	if(root.right != null) {
    		min_depth = Math.min(minDepth(root.right), min_depth);
    	}
    	return min_depth + 1;
    }
    /**
     * 深度
     * @param root
     * @return
     */
    public int dsf(TreeNode root) {
    	LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
    	if(root == null) return 0;
    	else stack.add(new Pair(root,1));
    	
    	int min_depth = Integer.MAX_VALUE;
    	while(!stack.isEmpty()) {
    		Pair<TreeNode, Integer> curr = stack.pollLast();
    		root = curr.getKey();
    		int current_depth = curr.getValue();
    		if((root.left == null) && (root.right == null)) {
    			min_depth = Math.min(min_depth, current_depth);
    		}
    		if(root.left != null) stack.add(new Pair(root.left, current_depth + 1));
    		if(root.right != null) stack.add(new Pair(root.right, current_depth +1));
    	}
    	return min_depth;
    }
    /**
     * 广度
     * @param root
     * @return
     */
    public int bsf(TreeNode root) {
    	LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
    	if(root == null) return 0;
    	else stack.add(new Pair(root,1));
    	
    	int current_depth = 0;
    	while(!stack.isEmpty()) {
    		Pair<TreeNode, Integer> current = stack.poll();
    		root = current.getKey();
    		current_depth = current.getValue();
    		if((root.left == null) && (root.right == null)) break;
    		if(root.left !=null) stack.add(new Pair(root.left, current_depth+1) );
    		if(root.right !=null) stack.add(new Pair(root.right, current_depth+1) );
    	}
    	return current_depth;
    }
}
