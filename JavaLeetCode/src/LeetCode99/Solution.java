/**
 * 二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。

示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2
示例 2:

输入: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

输出: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/recover-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode99;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
public class Solution {
	public void dd(TreeNode root) {

        if(root == null) return;
        int rv = root.val;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        int leftV = leftNode == null ? Integer.MIN_VALUE : leftNode.val;
        int rightV = rightNode == null? Integer.MAX_VALUE : rightNode.val;
        
        if(leftV > rv) {
        	int temp = rv;
        	rv = leftV;
        	leftV = temp;
        }
        
        if(rightV < rv) {
        	int temp = rv;
        	rv = rightV;
        	rightV = rv;
        }
        
        if(leftNode != null) recoverTree(leftNode);
        if(rightNode != null) recoverTree(rightNode);
	}
	/**
	 * 递归
	 * @param root
	 */
    public void recoverTree(TreeNode root) {
    	List<Integer> nums = new ArrayList<>();
    	inorder(root,nums);
    	int[] swapped = findTwoSwapped(nums);
    	recover(root, 2, swapped[0], swapped[1]);
    }
    public void inorder(TreeNode root, List<Integer> nums) {
    	if(root == null) return;
    	inorder(root.left, nums);
    	nums.add(root.val);
    	inorder(root.right, nums);
    }
    public int[] findTwoSwapped(List<Integer> nums) {
    	int n = nums.size();
    	int x = -1 , y = -1;
    	for(int i = 0; i < n - 1; i++) {
    		if(nums.get(i+1) < nums.get(i)) {
    			y = nums.get(i+1);
    			if(x == -1) x = nums.get(i);
    			else break;
    		}
    	}
    	return new int[] {x,y};
    }
    public void recover(TreeNode r, int count, int x, int y) {
    	if(r != null) {
    		if(r.val == x || r.val == y) {
    			r.val = r.val == x ? y :x;
    			if(-- count == 0) return;
    		}
    		recover(r.left,count,x,y);
    		recover(r.right,count,x,y);
    	}
    }
    
    //II迭代
    /**
     * 交换
     * @param a
     * @param b
     */
    public void swap( TreeNode a, TreeNode b) {
    	int tmp = a.val;
    	a.val = b.val;
    	b.val = tmp;
    }
    
    public void recoverTree1(TreeNode root) {
    	Deque<TreeNode> stack = new ArrayDeque();
    	TreeNode x = null, y = null, pred = null;
    	
    	while(!stack.isEmpty() || root !=null) {
    		while(root != null) {
    			stack.add(root);
    			root = root.left;
    		}
    		
    		root = stack.removeLast();
    		if(pred != null && root.val < pred.val) {
    			y = root;
    			if(x == null) x = pred;
    			else break;
    		}
    		pred = root;
    		root = root.right;
    	}
    	swap(x,y);
    }
}
