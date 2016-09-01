package String;

import java.util.List;
import java.util.ArrayList;


/**
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * Tag: String (Medium)
 * 
 * key condition: left parenthese >= right parenthese
 * using char[] is faster than String when modifing the string
 * 
 */
public class LC22_GenerateParentheses {
	/**
	 * 1ms, beats 91.76%
	 */
	public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        char[] str = new char[2*n];
        generate2(list, str, n, n, 0);
        return list;
    }
    
    private void generate2(List<String> list, char[] str, int left, int right, int index){
        if (left == 0 && right == 0){
            list.add(new String(str));
        }
        if (left > 0){
            str[index] = '(';
            generate2(list, str, left - 1, right, index + 1);
        }
        if (right > 0 && left < right){
            str[index] = ')';
            generate2(list, str, left, right - 1, index + 1);
        }
    }
    
	/**
	 * recursion way, easy to understand but not fast
	 * 2ms, beats 31.04%
	 */
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate(list, "", n, n);
        return list;
    }
    
    private void generate(List<String> list, String result, int left, int right){
        if (left == 0 && right == 0){
            list.add(result);
        }
        if (left > 0){
            generate(list, result + "(", left - 1, right);
        }
        if (right > 0 && left < right){
            generate(list, result + ")", left, right - 1);
        }
    }
}

/*
 * C++ version
 * 
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> result;
        char str[2 * n + 1];
        generate(result, str, n, n, 0);
        return result;
    }
    
    // Don't forget & when using an object as parameter!
    void generate(vector<string>& result, char str[], int left, int right, int index){
        if (left == 0 && right == 0){
            str[index] = '\0'; // Remember '\0' in C/C++!
            result.push_back(string(str));
        }
        else{
            if (left > 0){
                str[index] = '(';
                generate(result, str, left - 1, right, index + 1);
            }
            if (right > 0 && left < right){
                str[index] = ')';
                generate(result, str, left, right - 1, index + 1);
            }
        }
    }
};
 *
 *
 */
