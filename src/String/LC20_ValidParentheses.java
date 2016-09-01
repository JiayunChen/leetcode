package String;
/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Tag: String (Easy)
 * 
 * # bracket matching
 * using "stack", remember null and the index range
 * 
 * 0ms, beats 96.72%
 * AC at first!
 * 
 */
public class LC20_ValidParentheses {
	 public boolean isValid(String s) {
	        if (s == null || s.isEmpty()){
	            return true;
	        }
	        
	        int top = -1, len = s.length();
	        char[] str = s.toCharArray();
	        char[] lefts = new char[len];
	        for (int i = 0; i < len; i++){
	            if (str[i] == '(' || str[i] == '{' || str[i] == '['){
	                lefts[++top] = str[i];
	            }
	            else if (str[i] == ')' || str[i] == '}' || str[i] == ']'){
	                if (top >= 0 && matchBracket(lefts[top], str[i])){
	                    top--;
	                }
	                else{
	                    return false;
	                }
	            }
	            else{
	                return false;
	            }
	        }
	        if (top < 0){
	            return true; 
	        }
	        else{
	            return false;
	        }
	    }
	    
	    private boolean matchBracket(char a, char b){
	        if (a == '(' && b == ')'){
	            return true;
	        }
	        if (a == '{' && b == '}'){
	            return true;
	        }
	        if (a == '[' && b == ']'){
	            return true;
	        }
	        return false;
	    }
}
