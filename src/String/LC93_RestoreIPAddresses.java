package String;

import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * 
 * Tag:String(Medium)
 * given a string, return the forms of being IP addresses
 * "010010" => ["0.10.0.10", "0.100.1.0"]
 *
 * recursive (DFS??)
 * 3ms, beats 88.19%
 * 
 */
public class LC93_RestoreIPAddresses {

	public class Solution {
	    public List<String> restoreIpAddresses(String s) {
	        List<String> list = new ArrayList<String>();
	        int len = s.length();
	        if (len > 3 && len < 13){
	            char[] str = s.toCharArray();
	            restoreIp(list, str, 0, "", 0);
	        }
	        return list;
	    }
	    
	    // using substring instead of char[] costs 10ms
	    private void restoreIp(List<String> list, char[] str, int start, String result, int part){
	        int len = str.length;
	        if (3 == part && isValid(str, start, len)){
	            list.add(result + new String(str, start, len-start));
	            // return; // using return; or else adds 1ms more ?!
	        }
	        
	        for (int i = 1; i < 4 && start+i < len; i++){
	            if (isValid(str, start, start+i)){
	                String cur = new String(str, start, i);
	                restoreIp(list, str, start + i, result + cur + ".", part + 1);
	            }
	        }
	    }
	    
	    private boolean isValid(char[] str, int i, int j){
	        if (str[i] == '0' && i+1 != j){ // "001" is invalid
	            return false;
	        }
	        int num = 0;
	        for (int k = i; k < j; k++){
	            num = num * 10 + (9 - ('9' - str[k]));
	        }
	        return (num <= 255 && num >= 0)? true: false;
	    }
	    
	}
}
