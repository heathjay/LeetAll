/**
 * 给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode124;
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
	int max_sum = Integer.MIN_VALUE;
	
	public int max_gain(TreeNode node) {
		if(node == null) return 0;
		
		int left_gain = Math.max(max_gain(node.left), 0);
		int right_gain = Math.max(max_gain(node.right), 0);
		
		int price_newpath = node.val + left_gain+right_gain;
		max_sum = Math.max(max_sum, price_newpath);
		return node.val + Math.max(left_gain, right_gain);
	}
    public int maxPathSum(TreeNode root) {
    	max_gain(root);
    	return max_sum;
    }
}
