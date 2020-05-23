/**
 * 比较两个版本号 version1 和 version2。
如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。

你可以假设版本字符串非空，并且只包含数字和 . 字符。

 . 字符不代表小数点，而是用于分隔数字序列。

例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。

你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 

示例 1:

输入: version1 = "0.1", version2 = "1.1"
输出: -1
示例 2:

输入: version1 = "1.0.1", version2 = "1"
输出: 1
示例 3:

输入: version1 = "7.5.2.4", version2 = "7.5.3"
输出: -1
示例 4：

输入：version1 = "1.01", version2 = "1.001"
输出：0
解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
示例 5：

输入：version1 = "1.0", version2 = "1.0.0"
输出：0
解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/compare-version-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode165;

import javafx.util.Pair;

public class Solution {
    public int compareVersion(String version1, String version2) {
    	String[] s1 = version1.split("\\.");
    	String[] s2 = version2.split("\\.");
    	int len = s1.length > s2.length ? s1.length : s2.length;
    	for(int i = 0;i < len;i++) {
    		int x = i >= s1.length ? 0 : Integer.valueOf(s1[i]);
    		int y = i >= s2.length ? 0 : Integer.valueOf(s2[i]);
    		if(x > y) {
    			return 1;
    		}else if(x <y){
    			return -1;
    		}else if(x==y) {
    			continue;
    		}
    	}
    	return 0;
    }
    /**
     * 双指针
     * @param version1
     * @param version2
     * @return
     */
    public Pair<Integer,Integer	> getNextChunk(String version, int n, int p){
    	if(p > n -1) return new Pair(0,p);
    	int i , pEnd = p;
    	while(pEnd < n&& version.charAt(pEnd) != '.') {
    		++pEnd;
    	}
    	if(pEnd != n-1) i = Integer.parseInt(version.substring(p,pEnd));
    	else i = Integer.parseInt(version.substring(p,n));
    	p = pEnd + 1;
    	return new Pair(i,p);
    }
    public int compareVersion1(String version1, String version2) {
    	int p1 = 0, p2 = 0;
    	int n1 = version1.length(), n2 = version2.length();
    	int i1, i2;
    	Pair<Integer,Integer> pair;
    	while(p1 < n1 || p2 < n2) {
    		pair = getNextChunk(version1, n1, p1);
    		i1 = pair.getKey();
    		p1 = pair.getValue();
    		
    		pair = getNextChunk(version2, n2, p2);
    		i2 = pair.getKey();
    		p2 = pair.getValue();
    		if(i1 != i2) return i1 > i2 ? 1: -1;
    	}
    	return 0;
    }
}
