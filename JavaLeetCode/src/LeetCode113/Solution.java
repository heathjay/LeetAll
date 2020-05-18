/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode113;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	helper(root, sum, new LinkedList<Integer>());
    	return res;
    }
    public void helper(TreeNode root, int sum, LinkedList<Integer> cur) {
    	if(root == null) return ;
    	sum -= root.val;
    	cur.add(root.val);
    	if((root.left == null) && (root.right == null) &&(sum == 0)) {
    		res.add(new LinkedList<Integer>(cur));
    		cur.removeLast();
    		return;
    	}
    	if(root.left != null) helper(root.left, sum, cur);
    	if(root.right != null) helper(root.right, sum, cur);
    	cur.removeLast();
    } 
}
