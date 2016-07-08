/**
 * https://leetcode.com/problems/count-and-say/
 * 
 * Tag: String (Easy)
 * 
 * 对前一个字符串挨个数数（每次数连续相同的，比如2个1、3个2），然后表示为字符串
 * # 1. "1" (1个1)
 * # 2. "11" (2个1)
 * # 3. "21" (1个2，2个1)
 * # 4. "1211" (1个1，1个2，2个1)
 * # 5. "111221"
 * 
 * 时间复杂度:O(n*len), 20ms, beats 15.18%
 * 
 */
public class LC38_CountAndSay {
    public String countAndSay(int n) {
        String last = "1";
        String cur = "1";
        for (int i = 1; i < n; i++){ // start from 1
            cur = "";
            int len = last.length();
            char[] str = last.toCharArray();
            for (int j = 0; j < len; j++){
                int k = j;
                for (; k < len-1 && str[k] == str[k+1]; k++);
                cur += String.valueOf(k-j+1) + str[j];
                j = k; // Don't forget this!
            }
            last = cur;
        }
        return cur;
    }
}
