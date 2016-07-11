package String.Easy;
/**
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * Tag: String (Easy)
 * 
 * 输出空格后的最后一串字符串的长度
 * 就注意下前后有空格，没有空格的情况
 * 
 * 时间复杂度:O(n), 1ms, beats 44.23%
 * 用的函数，没什么可说的
 * 
 */
public class LC58_LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        int i = s.trim().lastIndexOf(" ");
        int len = s.trim().length();
        if (i < 0){
            return len;
        }
        else{
            return (len - i - 1);
        }
    }
}
