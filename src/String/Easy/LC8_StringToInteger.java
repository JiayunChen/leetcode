package String.Easy;
/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * Tag: String (Easy)
 * 
 * All kinds of traps!!!
 * # 1.+ and -
 * # 2.the blank --> trim()
 * # 3.0 at the beginning
 * # 4.other characters! returns the partical integer
 * # 5.int range!! (-2147483648~2147483647)
 * 
 * Samples:
 * # 1."+" => 0
 * # 2."+123" => 123
 * # 3."-123" => 123
 * # 4." -12abc" => -12
 * # 5." +-123" => 0 
 * # 6." -0012asd12" => -12
 * # 7."2147483648" => 2147483647
 * # 8."-2147483649" => -2147483648
 * 
 * O(n), 4ms, beats 32.68%
 * maybe C is faster, learnt how to consider overall
 * 
 */
public class LC8_StringToInteger {
	public int myAtoi(String str) {
		if (str.isEmpty()){
			return 0;
		}
		
		int len = str.trim().length();
		char[] cstr = str.trim().toCharArray();
		boolean negative = false;
		int i = 0;
		if (cstr[0] == '-'){
			i++;
			negative = true;
		}
		if (cstr[0] == '+'){ 
			i++;
		}
		while (i < len && cstr[i] == '0'){	// don't forget i < len
			i++;
		}
		
		double result = 0;
		if (negative){
			for (; i < len; i++){
				if (cstr[i] < '0' || cstr[i] > '9')
					break;
				result = (cstr[i] - '0') + result * 10;
				if ((-1*result) < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;	// -2147483648
			}
			return (int)(-1*result);
		}
		else{
			for (; i < len; i++){
				if (cstr[i] < '0' || cstr[i] > '9')
					break;
				result = (cstr[i] - '0') + result * 10;
				if (result > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;	// 2147483647
			}
			return (int)(result);
		}
	}
}
