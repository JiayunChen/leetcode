package String;
/**
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * Tag: String (Easy)
 * 
 * output the length of the last string before blank
 * notice string without blank and string with blank at the beginning(end)
 * 
 * O(n), 1ms, beats 44.23%
 * using lastIndexOf()
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
