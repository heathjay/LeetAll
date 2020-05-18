/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode108;


public class Solution {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	int[] nums;
	public TreeNode helper(int left, int right) {
		if(left > right) return null;
		int p = (left + right)/2;
		
		TreeNode root = new TreeNode(nums[p]);
		root.left = helper(left,p-1);
		root.right = helper(p+1,right);
		return root;
	}
    public TreeNode sortedArrayToBST(int[] nums) {
    	this.nums = nums;
    	return helper(0, nums.length - 1);
    }
    /**
     * 右边为根
     */
    public TreeNode hp(int left, int right) {
    	if(left > right) return null;
    	int p = (left + right) /2;
    	if( (left + right) % 2 == 0) {
    		p += 1;
    	}
    	TreeNode root = new TreeNode(nums[p]);
    	root.left = hp(left,p-1);
    	root.right = hp(p+1,right);
    	return root;
    }
}
