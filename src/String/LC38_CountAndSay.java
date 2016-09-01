package String;
/**
 * https://leetcode.com/problems/count-and-say/
 * 
 * Tag: String (Easy)
 * 
 * counting the previous string and presenting it 
 * # 1. "1" (one 1)
 * # 2. "11" (two 1)
 * # 3. "21" (one 2, one 1)
 * # 4. "1211" (one 1, one 2, two 1)
 * # 5. "111221"
 * 
 * O(n*len)
 * first try: using string+= costs 20ms, beats 15.18%
 * Then using stringBuilder.append costs 4ms, beats 62.77%
 * 
 * -- StringBuilder is faster than String
 * -- Runtime Error for mistaking i as j T_T
 * -- Run code after checking spelling!!
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
