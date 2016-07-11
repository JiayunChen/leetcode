package String.Easy;
/**
 * https://leetcode.com/problems/reverse-string/
 * 
 * Tag: String (Easy)
 * 
 * ��ת�ַ����е�Ԫ����ĸ
 * ��ע���´�Сд��ע������Զ��Խ�磬ʱʱ�ж�i<j
 * 
 * ʱ�临�Ӷ�:O(n), 5ms, beats 82.54%
 * 
 */
public class LC345_ReverseVowelsOfAString {
	public String reverseVowels(String s) {
        char[] t = s.toCharArray();
        for (int i = 0, j = t.length - 1; i < j; i++, j--){
            while (i < j && !isVowel(t[i])){
                i++;
            }
            while (i < j && !isVowel(t[j])){
                j--;
            }
            if (i < j){
                char tmp = t[i];
                t[i] = t[j];
                t[j] = tmp;
            }
        }
        return new String(t);
    }
    
    private boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}
