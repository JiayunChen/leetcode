package String;
/**
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * Tag: String (Easy)
 * 
 * O(n), 7ms, beats 81.97%
 * integer from 1~3999
 * 
 */
public class LC13_RomanToInteger {
	public int romanToInt(String s) {
        int num = 0;
        int len = s.length();
        char[] str = s.toCharArray();
        for (int i = 0; i < len; i++){
            num += value(str[i]);
            if (str[i] == 'I' || str[i] == 'X' || str[i] == 'C'){
                if (i + 1 < len && value(str[i]) < value(str[i+1])){
                    num += value(str[i+1]) - 2*value(str[i]);
                    i++;
                }
            }
        }
        return num;
    }
    
    private int value(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
