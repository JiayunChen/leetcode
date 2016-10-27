package String;
/**
 * https://leetcode.com/problems/multiply-strings/
 * 
 * Tag: String (Medium)
 * 
 * Just do the math, and be careful of [carry] and zero
 * 
 * 24ms, beats 98.45%
 * 
 */
public class LC43_MultiplyStrings {
	public String multiply(String num1, String num2) {
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        
        int len = s1.length + s2.length, k = len - 1;
        char[] result = new char[len];
        for (int i = 0; i < len; i++){
            result[i] = '0';
        }
        
        for (int i = s1.length - 1; i >= 0; i--, k--){
            for (int j = s2.length - 1, r = k; j >= 0; j--, r--){
                int m = (s1[i] - '0') * (s2[j] - '0') + (result[r] - '0');
                if (m > 9){
                    result[r-1] = (char)(result[r-1] + m / 10);
                }
                result[r] = (char)(m % 10 + '0');
            }
        }
        for (k = 0; k < len && result[k] == '0'; k++);
        if (k == len){
            k = len - 1;
        }
        
        // using new String is much better than substring: 30ms->24ms
        return new String(result, k, len-k);//String.valueOf(result).substring(k);
    }
}
