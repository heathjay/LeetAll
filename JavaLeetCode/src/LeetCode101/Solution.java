/**
 * 给定一个二叉树，检查它是否是镜像对称的。

 

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode101;
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class Solution {
    public boolean isSymmetric(TreeNode root) {
    	return isM(root,root);
    }
    public boolean isM(TreeNode t1,TreeNode t2) {
    	if(t1 == null && t2 == null) return true;
    	if(t1 == null || t2 == null) return true;
    	
    	return (t1.val == t2.val) && isM(t1.right, t2.left) && isM(t1.left, t2.right);
    }
}
