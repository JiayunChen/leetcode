package String;
/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Tag: String (Easy)
 * 
 * ��������ǰ׺
 * �͸����һ���򵥣����ǻ��ǲ��˺ܶ�ӣ�̫�������㣡
 * 
 * # ����ƥ��
 * ��ʵ������ջ��˼�룬��char����ͺ��ˣ�ע���±���пգ���Խ��
 * 
 * ʱ�临�Ӷ�:O(n), 0ms, beats 96.72%
 * һ��AC
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
