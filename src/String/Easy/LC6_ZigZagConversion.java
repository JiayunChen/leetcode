package String.Easy;
/**
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * Tag: String (Easy)
 * 
 * 字符串变成z字形状输�?
 * 第一道题，提交之前都要记得特殊情况的处理，最�?单的输入、长度为0等情�?
 * 尝试了几下：主要就是计算步距，char[]效率好过string�?
 * Best: 第四�? 5ms
 *
 */
public class LC6_ZigZagConversion {
	/**
	 * �?单的解题思路：主要就是取模，找每�?行的模�?�，注意不要超过字符串长�?
	 * 提交两次AC，第�?次是因为没有考虑行数�?1的情况（0值的处理�?
	 * 
	 * 时间复杂度：O(n*q)�?44ms，beats 12.73% 
	 */
	public String convert(String s, int numRows) {
        int len = s.length();
        if (len < 2 || numRows < 2){
            return s;
        }
        String t = "";
        int divisor = 2 * numRows - 2;
        int quotient = len / divisor;
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j <= quotient; j++){ // j=quotient，不对每个余数单独处理了
                int now = j * divisor + i;
                if (now >= len){
                    break;
                }
                t += s.charAt(now);
                if (i > 0 && i < numRows-1){ // 每一组的中间的数还要再加�?个字�?
                    int next = now + 2 * (numRows-i-1);
                    if (next < len){
                        t += s.charAt(next);
                    }
                }
            }
        }
        return t;
    }
	
	
	/**
	 * 用空间换�?点时间，前面是算每次去取字符的位置，这里用数组存储是算每个字符对应的位置
	 * 但是字符串拷来拷去的还是太浪费时间了
	 * 
	 * 时间复杂度：O(n)�?32ms，beats 24.02%
	 */
	public String convert2(String s, int numRows) {
        int len = s.length();
        if (len < 2 || numRows < 2){
            return s;
        }
        int divisor = 2 * numRows - 2;
        String[] strs = new String[numRows];
        for (int i = 0; i < numRows; i++){
            strs[i]="";
        }
        for (int i = 0; i < len; i++){
            if (i%divisor < numRows){
                strs[i % divisor] += s.charAt(i);
            }
            else{
                int pos = numRows-1 - i%(numRows-1);
                strs[pos] += s.charAt(i);
            }
        }
        String t = "";
        for (String str: strs){
            t += str;
        }
        return t;
    }
	
	
	/**
	 * 其实和第�?种做法是�?样的，只是代码更�?洁了，从步距上去计算
	 * 为什么讨论里有一个跟这代码一毛一样，号称Better than 97.88% ？－> 貌似是char数组快一�??
	 * 
	 * 时间复杂度：O(n*q)�?43ms，beats 14.00% 
	 * --> char[] str = s.toCharArray()再访问str[i]后，快了2ms，beats 16�?29%
	 * --> 重点是t改成char[]数组，然后t[k++]这样赋�?�，瞬间变成5ms，beats 96.59%！！
	 */
	public String convert3(String s, int numRows) {
        int len = s.length();
        if (len < 2 || numRows < 2){
            return s;
        }
        String t = "";
        int d = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++){
            for (int j = i; j < len; j += d){
                t += s.charAt(j);
                if (i > 0 && i < numRows-1 && (j+d-2*i) < len){
                    t += s.charAt(j+d-2*i); // 中间的数再加�?个d-2i步距
                }
            }
        }
        return t;
    }

	
	/**
	 * 也就是计算步进，但换成char[]数组后效率提高很�?
	 * 
	 * 时间复杂度：O(n)�?5ms，beats 96.59%
	 */
	public String convert4(String s, int numRows) {
        int len = s.length();
        if (len < 2 || numRows < 2){
            return s;
        }
        char[] t = new char[len];
        char[] str = s.toCharArray();
        int d = 2 * numRows - 2;
        for (int i = 0, k = 0; i < numRows; i++){
            for (int j = i; j < len; j += d){
                t[k++] = str[j]; // 每行的数的步进为d
                if (i > 0 && i < numRows-1 && (j+d-2*i) < len){
                    t[k++] = str[j+d-2*i]; // 中间的行再加�?个d-2i步进的数
                }
            }
        }
        return new String(t);
    }
		
}
