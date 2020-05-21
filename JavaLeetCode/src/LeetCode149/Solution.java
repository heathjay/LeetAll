/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。

示例 1:

输入: [[1,1],[2,2],[3,3]]
输出: 3
解释:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
示例 2:

输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出: 4
解释:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-points-on-a-line
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode149;

public class Solution {
    public int maxPoints(int[][] points) {
    	if(points.length < 3) return points.length;
    	int i = 0;
    	for(; i < points.length - 1;i++) {
    		if(points[i][0] != points[i+1][0] || points[i][1] != points[i+1][1]) {
    			break;
    		}
    	}
    	
    	if(i == points.length -1) return points.length;
    	int max = 0;
    	for(i = 0 ;i<points.length;i++) {
    		for(int j = i + 1; j < points.length ; j ++) {
    			if(points[i][0] == points[j][0] && points[i][1] == points[j][1])continue;
    			int tempMax = 0;
    			for(int k = 0; k < points.length;k++) {
    				if(k!= i && k != j) {
    					if(test(points[i][0],points[i][1],points[j][0],points[j][1],points[k][0],points[k][1]))
    						tempMax++;
    				}
    			}
    			if(tempMax > max)max = tempMax;
    		}
    	}
    	return max+2;
    }
    private boolean test(int x1,int y1,int x2,int y2,int x,int y) {
    	int g1 = gcd(y2-y1,x2-x1);
    	if(y==y2 && x == x2) {
    		return true;
    	}
    	int g2 = gcd(y-y2,x-x2);
    	return (y2-y1)/g1 == (y-y2)/g2 && (x2-x1)/g1 ==(x-x2)/g2;
    }
    private int gcd(int a,int b) {
    	while(b != 0) {
    		int temp = a % b	;
    		a = b;
    		b =temp;
    	}
    	return a;
    }
}
