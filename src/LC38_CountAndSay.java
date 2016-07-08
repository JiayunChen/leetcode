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
 * ʱ�临�Ӷ�:O(n*len)
 * �����string��+=����ʱ20ms, beats 15.18%
 * �����ĳ�StringBuilder��append����ʱ4ms, beats 62.77%
 * 
 * -- StringBuilder��String��
 * -- Ϊ��һ��jд����i��������һ��Runtime Error
 * -- ����ƴд�������ֵͼ����⣬ϣ����ÿ�μ������ȥRun Code����Ȼ��ʧȥ����debug������
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
