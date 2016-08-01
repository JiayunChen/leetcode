package String.Easy;
/**
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * Tag: String (Easy)
 * 
 * output string as the shape of z
 * central idea: calculate the step for each row
 * give fourth try and the best is 5ms, beats 96.59%
 *
 */
public class LC6_ZigZagConversion {
	/**
	 * get the row depending mod
	 * 
	 * O(n*q), 44ms, beats 12.73% 
	 */
	public String convert(String s, int numRows) {
        int len = s.length();
        if (len < 2 || numRows < 2){
            return s;
        }
        String t = "";
        int divisor = 2 * numRows - 2;
        int quotient = len / divisor;
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j <= quotient; j++){ 
                int now = j * divisor + i;
                if (now >= len){
                    break;
                }
                t += s.charAt(now);
                if (i > 0 && i < numRows-1){ 
                    int next = now + 2 * (numRows-i-1);
                    if (next < len){
                        t += s.charAt(next);
                    }
                }
            }
        }
        return t;
    }
	
	
	/**
	 * using space exchange for some time
	 * 
	 * O(n), 32ms, beats 24.02%
	 */
	public String convert2(String s, int numRows) {
        int len = s.length();
        if (len < 2 || numRows < 2){
            return s;
        }
        int divisor = 2 * numRows - 2;
        String[] strs = new String[numRows];
        for (int i = 0; i < numRows; i++){
            strs[i]="";
        }
        for (int i = 0; i < len; i++){
            if (i%divisor < numRows){
                strs[i % divisor] += s.charAt(i);
            }
            else{
                int pos = numRows-1 - i%(numRows-1);
                strs[pos] += s.charAt(i);
            }
        }
        String t = "";
        for (String str: strs){
            t += str;
        }
        return t;
    }
	
	
	/**
	 * calculate the step to get row character
	 * 
	 * O(n*q), 43ms, beats 14.00% 
	 * --> using char[] is much faster!!
	 */
	public String convert3(String s, int numRows) {
        int len = s.length();
        if (len < 2 || numRows < 2){
            return s;
        }
        String t = "";
        int d = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++){
            for (int j = i; j < len; j += d){
                t += s.charAt(j);// step d for each row
                if (i > 0 && i < numRows-1 && (j+d-2*i) < len){
                    t += s.charAt(j+d-2*i); // add (d-2i) for medium rows
                }
            }
        }
        return t;
    }

	
	/**
	 * calculating the step, using char[] is fast
	 * 
	 * O(n), 5ms, beats 96.59%!
	 */
	public String convert4(String s, int numRows) {
        int len = s.length();
        if (len < 2 || numRows < 2){
            return s;
        }
        char[] t = new char[len];
        char[] str = s.toCharArray();
        int d = 2 * numRows - 2;
        for (int i = 0, k = 0; i < numRows; i++){
            for (int j = i; j < len; j += d){
                t[k++] = str[j]; // step d for each row
                if (i > 0 && i < numRows-1 && (j+d-2*i) < len){
                    t[k++] = str[j+d-2*i]; // add (d-2i) for medium rows
                }
            }
        }
        return new String(t);
    }
		
}
