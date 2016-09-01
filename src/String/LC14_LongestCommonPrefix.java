package String;
/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Tag: String (Easy)
 * 
 * easy as thought, be more careful
 * 
 * # string
 * never forget empty! null!
 * test begins with "only one": the string with length 1 and the array with size 1
 * cstr.length & string.length()
 * "break" only breaks one loop 
 * 
 * O(mn), 2ms, beats 63.49%
 * 
 */
public class LC14_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        int size = strs.length; 
        if (0 == size){
            return ""; 
        }
        
        int minLen = strs[0].length();
        for (int i = 1; i < size; i++){
            int len = strs[i].length();
            minLen = (len < minLen)? len: minLen;
        }
        if (0 == minLen){
            return "";
        }
        
        int commonLen;
        boolean finished = false;
        char[] firstString = strs[0].toCharArray();
        for (commonLen = 0; commonLen < minLen; commonLen++){
            for (int i = 1; i < size; i++){
                if (strs[i].charAt(commonLen) != firstString[commonLen]){
                    finished = true; 
                    break;
                }
            }
            if (finished){
                break;
            }
        }
        return strs[0].substring(0, commonLen); // substring does NOT contains strs[commonLen]
    }
}
