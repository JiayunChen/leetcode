package String.Easy;
/**
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * Tag: String (Easy)
 * 
 * ����ո������һ���ַ����ĳ���
 * ��ע����ǰ���пո�û�пո�����
 * 
 * ʱ�临�Ӷ�:O(n), 1ms, beats 44.23%
 * �õĺ�����ûʲô��˵��
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
