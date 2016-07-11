package String;
/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Tag: String (Easy)
 * 
 * 输出最长公共前缀
 * 就跟想的一样简单，但是还是踩了很多坑，太粗心了你！
 * 
 * # 括号匹配
 * 其实就是用栈的思想，用char数组就好了，注意下标和判空，别越界
 * 
 * 时间复杂度:O(n), 0ms, beats 96.72%
 * 一次AC
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
