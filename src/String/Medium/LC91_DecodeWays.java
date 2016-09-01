package String.Medium;
/**
 * https://leetcode.com/problems/decode-ways/
 * 
 * Tag: String (Medium), Dynamic Programming
 * '1' - > 'A' ... '26' -> 'Z'
 * given a string like '12', return the ways decoded(2, 'AB' or 'L')
 * 
 * O(n), 2ms, beats 66.73%
 * 
 */
public class LC91_DecodeWays {
	public int numDecodings(String s) {
        char[] str = s.toCharArray();
        int len = str.length; 
        if (0 == len || str[0] == '0'){
            return 0;
        }
        
        int[] result = new int[len]; // default value 0
        result[0] = 1;
        for (int i = 1; i < len; i++){
            if (str[i] >= '0' && str[i] <= '9'){
                if (str[i] > '0'){
                    result[i] += result[i - 1];     // 1 ~ 9
                }
                
                if (str[i - 1] == '1' || (str[i - 1] == '2' && str[i] < '7')){
                    result[i] += (i > 1)? result[i - 2]: 1; // 10 ~ 26
                }
            }
            
            if (0 == result[i]){
                return 0; // such as 00¡¢30...
            }
        }
        // neglect the other char
        
        return result[len - 1];
    }
}
