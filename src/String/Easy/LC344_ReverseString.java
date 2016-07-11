package String.Easy;
/**
 * https://leetcode.com/problems/reverse-string/
 * 
 * Tag: String (Easy)
 * 
 * ��ת�ַ���
 * 
 * ʱ�临�Ӷ�:O(n), 3ms, beats 59.42%
 * 
 */
public class LC344_ReverseString {
	// ��һ��Ӧ���������ø����飬��ʵ Ҳû����Ҫ
	public String reverseString(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        char[] ss = s.toCharArray();
        char[] t = new char[len];
        for (int i = 0; i < len; i++){
            t[i] = ss[len-i-1];
        }
        return new String(t);
    }
	
	// ���ĵ��ǲ�û�б�죬char[]�����t.lengthҲ�����Բ��Ƿ���Ŷ
	public String reverseString2(String s) {
        char[] t = s.toCharArray();
        int len = t.length;
        for (int i = 0; i < len/2; i++){
            char tmp = t[i];
            t[i] = t[len - i -1];
            t[len - i -1] = tmp;
        }
        return new String(t);
    }
}
