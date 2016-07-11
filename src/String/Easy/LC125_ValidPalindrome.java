package String.Easy;
/**
 * https://leetcode.com/problems/reverse-string/
 * 
 * Tag: String (Easy)
 * 
 * �жϻ�����
 * �ͷ�ת�ַ�����࣬����ûע������ĸ���֣���������һ��WA
 * 
 * ʱ�临�Ӷ�:O(n), 11ms, beats 41.65%
 * ��һ�ַ�����ת��Сд��ĸ�ˣ���������˷�ʱ��
 * �ڶ��ַ����ֶ��ж�(Math.abs(a-b) == 'a'-'A')����Ϳ����д�д��Сд��ͬ��
 * 8ms, beats 77.54%
 * 
 */
public class LC125_ValidPalindrome {
	/**
	 * 11ms, beats 41.65%
	 */
	public boolean isPalindrome(String s) {
        char[] t = s.toLowerCase().toCharArray();
        for (int i = 0, j = t.length-1; i<j; i++, j--){
            while(i < j && !Character.isLetter(t[i]) && !Character.isDigit(t[i])){
                i++;
            }
            while(i < j && !Character.isLetter(t[j]) && !Character.isDigit(t[j])){
                j--;
            }
            if (t[i] != t[j]){
                return false;
            }
        }
        return true;
    }
	
	/**
	 * 8ms, beats 77.54%
	 */
	public boolean isPalindrome2(String s) {
        char[] t = s.trim().toCharArray();
        for (int i = 0, j = t.length-1; i<j; i++, j--){
            while(i < j && !Character.isLetter(t[i]) && !Character.isDigit(t[i])){
                i++;
            }
            while(i < j && !Character.isLetter(t[j]) && !Character.isDigit(t[j])){
                j--;
            }
            if (i < j && !isSame(t[i], t[j])){ // notice if(i<j)
                return false;
            }
        }
        return true;
    }
	
	private boolean isSame(char a, char b){
		if (Character.isDigit(a) && Character.isDigit(b)){
			return a==b;
		}
		else if(Character.isLetter(a) && Character.isLetter(b)){
			return a==b || (Math.abs(a-b) == 'a'-'A');
		}
		return false;	
	}
}
