/**
 * https://leetcode.com/problems/count-and-say/
 * 
 * Tag: String (Easy)
 * 
 * ��ǰһ���ַ�������������ÿ����������ͬ�ģ�����2��1��3��2����Ȼ���ʾΪ�ַ���
 * # 1. "1" (1��1)
 * # 2. "11" (2��1)
 * # 3. "21" (1��2��2��1)
 * # 4. "1211" (1��1��1��2��2��1)
 * # 5. "111221"
 * 
 * ʱ�临�Ӷ�:O(n*len), 20ms, beats 15.18%
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
