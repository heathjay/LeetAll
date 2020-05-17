/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

示例:

输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode95;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    public LinkedList<TreeNode> generate(int start, int end){
    	LinkedList<TreeNode> tree = new LinkedList<>();
    	if(start > end) {
    		tree.add(null);
    		return tree;
    	}
    	
    	for(int i = start; i <= end; i++) {
    		LinkedList<TreeNode> left_trees = generate(start, i -1);
    		LinkedList<TreeNode> right_trees = generate(i+1,end);
    		
    		for(TreeNode l : left_trees) {
    			for(TreeNode r : right_trees) {
    				TreeNode cur = new TreeNode(i);
    				cur.left = l;
    				cur.right = r;
    				tree.add(cur);
    			}
    		}
    	}
    	return tree;
    }
	public List<TreeNode> generateTrees(int n) {
		if(n==0)return new LinkedList<TreeNode>();
		
		return generate(1,n);
    }
}
