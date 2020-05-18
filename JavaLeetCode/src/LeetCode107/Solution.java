/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

 */
package LeetCode107;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res = new LinkedList<>();
    	if(root == null) return res;
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	while(!q.isEmpty()) {
    		List<Integer> tmp = new LinkedList<>();
    		int len = q.size();
    		
    		for(int i = 0; i < len;i++) {
    			TreeNode node = q.poll();
    			tmp.add(node.val);
    			if(node.left != null) {
    				q.add(node.left);
    			}
    			if(node.right != null) {
    				q.add(node.right);
    			}
    			
    		}
    		res.add(0, tmp);
    	}
    	return res;
    }
}
