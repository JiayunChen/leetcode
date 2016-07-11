package String;
/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * Tag: String (Easy)
 * 
 * 字符串转int数字，各种错误处理要命！
 * # 1.首先想到，注意正负号（正号容易被忽略�?
 * # 2.头尾的空白字符（习惯用trim()还不错）
 * # 3.�?头出现的0（还以为不会出这个样例，疏忽了）
 * # 4.其他字符（并不是字符串里包含其他字符就返�?0，�?�是返回前面正确处理出来的）
 * # 5.int越界问题（这个真的没有�?�虑到，-2147483648~2147483647�?
 * 
 * 几个样例�?
 * # 1."+" => 0
 * # 2."+123" => 123
 * # 3."-123" => 123
 * # 4." -12abc" => -12
 * # 5." +-123" => 0 
 * # 6." -0012asd12" => -12
 * # 7."2147483648" => 2147483647
 * # 8."-2147483649" => -2147483648
 * 
 * 时间复杂�?:O(n), 4ms, beats 32.68%
 * 感觉用C是更快的，这题主要学到全面�?�虑错误处理，不纠结时间�?
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
		if (cstr[0] == '+'){	// 正号别忘�?
			i++;
		}
		while (i < len && cstr[i] == '0'){	// 别忘了判下标是否超出长度
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
