package String.Easy;
/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Tag: String (Easy)
 * 
 * ��������ǰ׺
 * �͸����һ���򵥣����ǻ��ǲ��˺ܶ�ӣ�̫�������㣡
 * 
 * # �ַ���
 * ��Զ�������пգ�null���ַ�������Ҳ�ǣ�
 * ��������Ҫ�ӡ�ֻ��һ������ʼ��ֻ��һ���ַ���Ԫ�أ�ֻ��һ����ĸ���ַ���
 * �����strs.length & �ַ�����str.length() 
 * breakʱ��סֻ����һ��ѭ��
 * 
 * ʱ�临�Ӷ�:O(mn), 2ms, beats 63.49%
 * 
 */
public class LC14_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        int size = strs.length; // ע����length����length()
        if (0 == size){
            return ""; // ���Ƿ���""������null
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
        return strs[0].substring(0, commonLen); // substring����������������ڵ��ַ�
    }
}