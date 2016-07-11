package String.Easy;
/**
 * https://leetcode.com/problems/reverse-string/
 * 
 * Tag: String (Easy)
 * 
 * 反转字符串
 * 
 * 时间复杂度:O(n), 3ms, beats 59.42%
 * 
 */
public class LC344_ReverseString {
	// 第一反应还是另外用个数组，其实 也没多大必要
	public String reverseString(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        char[] ss = s.toCharArray();
        char[] t = new char[len];
        for (int i = 0; i < len; i++){
            t[i] = ss[len-i-1];
        }
        return new String(t);
    }
	
	// 伤心的是并没有变快，char[]数组的t.length也是属性不是方法哦
	public String reverseString2(String s) {
        char[] t = s.toCharArray();
        int len = t.length;
        for (int i = 0; i < len/2; i++){
            char tmp = t[i];
            t[i] = t[len - i -1];
            t[len - i -1] = tmp;
        }
        return new String(t);
    }
}
