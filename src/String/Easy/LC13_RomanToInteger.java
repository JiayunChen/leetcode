package String.Easy;
/**
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * Tag: String (Easy)
 * 
 * O(n), 7ms, beats 81.97%
 * 
 */
public class LC13_RomanToInteger {
	public int romanToInt(String s) {
        int num = 0;
        int len = s.length();
        char[] str = s.toCharArray();
        for (int i = 0; i < len; i++){
            num += value(str[i]);
            if (i + 1 < len && -1 == compare(str[i], str[i+1])){
                num += value(str[i+1]) - 2*value(str[i]);
                i++;
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
    
    private int compare(char a, char b){
        if (a == b){
            return 0;
        }
        if (a == 'I'){
            return -1;
        }
        if (a == 'X'){
            return (b == 'I' || b == 'V')? 1: -1;
        }
        if (a == 'C'){
            return (b == 'D' || b == 'M')? -1: 1;
        }
        return 1;
    }
}
