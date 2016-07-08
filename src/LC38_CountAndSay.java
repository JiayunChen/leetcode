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
 * 时间复杂度:O(n*len)
 * 起初用string的+=，用时20ms, beats 15.18%
 * 后来改成StringBuilder的append，用时4ms, beats 62.77%
 * 
 * -- StringBuilder比String快
 * -- 为了一个j写成了i，白送了一个Runtime Error
 * -- 对于拼写错误这种低级问题，希望你每次检查完再去Run Code，不然就失去肉眼debug的意义
 * 
 */
public class LC38_CountAndSay {
	public String countAndSay(int n) {
        String last = "1";
        //String cur = "1";
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i = 1; i < n; i++){
            //cur = "";
            sb.delete(0, sb.length());
            int len = last.length();
            char[] str = last.toCharArray();
            for (int j = 0; j < len; j++){
                int k = j;
                for (; k < len-1 && str[k] == str[k+1]; k++);
                //cur += String.valueOf(k-j+1) + str[j];
                sb.append(String.valueOf(k-j+1)).append(str[j]);
                j = k;
            }
            //last = cur;
            last = sb.toString();
        }
        return sb.toString();
    }
}
