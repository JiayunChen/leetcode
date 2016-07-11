package String.Easy;
/**
 * https://leetcode.com/problems/reverse-string/
 * 
 * Tag: String (Easy)
 * 
 * 判断回文数
 * 和反转字符串差不多，就是没注意是字母数字，所以拿了一个WA
 * 
 * 时间复杂度:O(n), 11ms, beats 41.65%
 * 第一种方法先转成小写字母了，这里可能浪费时间
 * 第二种方法手动判断(Math.abs(a-b) == 'a'-'A')这个就可以判大写和小写相同啦
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
