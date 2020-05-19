/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	  List<List<Integer>> triangle = new ArrayList<>();
        	triangle.add(new ArrayList<>());
      	triangle.get(0).add(1);
   	
      	for(int rowNum = 1; rowNum <= rowIndex; rowNum++) {
      		List<Integer> row = new ArrayList<>();
      		List<Integer> preRow = triangle.get(rowNum - 1);
      		
      		row.add(1);
      		for(int j = 1; j < rowNum;j++) {
      			row.add(preRow.get(j-1) + preRow.get(j));
      		}
      		row.add(1);
      		triangle.add(row);
      	}
      	return triangle.get(triangle.size() -1);
    }
}
