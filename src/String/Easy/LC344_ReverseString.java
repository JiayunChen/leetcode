package String.Easy;
/**
 * https://leetcode.com/problems/reverse-string/
 * 
 * Tag: String (Easy)
 * 
 * reverse string
 * 
 * O(n), 3ms, beats 59.42%
 * 
 */
public class LC344_ReverseString {
	// using another array to record is not so neccessary
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
	
	// not faster as I wished
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
