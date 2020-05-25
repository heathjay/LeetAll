/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class Solution {
	  public List<Integer> rightSideView(TreeNode root) {
		  List<Integer> res = new ArrayList<>();
		  LinkedList<TreeNode> stack = new LinkedList<>();
		  if(root == null) return res;
		  stack.add(root);
		  while(!stack.isEmpty()) {
			  int len = stack.size();
			  for(int i = 0; i < len;i++) {
				  TreeNode node =stack.poll();
				  if(i == len -1) res.add(node.val);
				  if(node.left != null) stack.addLast(node.left);
				  if(node.right != null) stack.addLast(node.right);  
			  }
		  }
		  return res;
	    }
}
