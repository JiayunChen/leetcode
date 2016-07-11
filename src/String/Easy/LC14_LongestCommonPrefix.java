package String.Easy;
/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Tag: String (Easy)
 * 
 * 输出最长公共前缀
 * 就跟想的一样简单，但是还是踩了很多坑，太粗心了你！
 * 
 * # 字符串
 * 永远别忘了判空！null！字符串数组也是！
 * 测试首先要从“只有一个”开始：只有一个字符串元素；只有一个字母的字符串
 * 数组的strs.length & 字符串的str.length() 
 * break时记住只跳出一层循环
 * 
 * 时间复杂度:O(mn), 2ms, beats 63.49%
 * 
 */
public class LC14_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        int size = strs.length; // 注意是length不是length()
        if (0 == size){
            return ""; // 答案是返回""而不是null
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
        return strs[0].substring(0, commonLen); // substring不包含后面参数所在的字符
    }
}
