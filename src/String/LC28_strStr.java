package String;
/**
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Tag: String (Easy)
 * 
 * returns the index of the first occurance of needle in haystack, or -1
 * first thought: KMP
 * discuss:
 *  haystack.indexOf(needle)
 *  compare substring
 * 
 * KMP is not the practical best, in fact comparing substring has better effect.
 * 
 */
public class LC28_strStr {
	/**
	 * KMP 4ms, beats 55.17% 
	 * (it costs longer than i thought)
	 */
	public int strStr(String haystack, String needle) {
        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();
        /*
        if (s.length == 0){
            return (t.length == 0? 0: -1); // redundant
        }
        else if (t.length == 0){
            return 0;
        }*/
        if (t.length == 0){
        	return 0;
        }
        
        int[] next = getNext(t);
        for (int i = 0, j = 0; i < s.length; i++){
            while (j > 0 && s[i] != t[j]){ // Don't miss compare s[i] with the new j
                j = next[j-1];
            }
            if (s[i] == t[j]){
                j++;
            }
            
            if (j == t.length){
                return (i-j+1);
            }
        }
        return -1;
    }
    
	/**
	 * Example:
	 * ABCDABDE
	 * 00123401
	 * 
     * ABCDABABCDABDE
     * ABCDABDE
     *     ABCDABDE
     *     
     * j = next[j-1] = 3
     * move to str[3]
     */
    private int[] getNext(char[] str){
        int[] next = new int[str.length];
        next[0] = 0;
        for (int i = 1; i < str.length; i++){
            if (str[i] == str[next[i-1]]){
                next[i] = next[i-1] + 1; // the length of the same prefix
            }
            else{
                next[i] = (str[i] == str[0])? 1: 0;
            }
        }
        return next;
    }
    
    
    /**
     * indexOf takes 0ms, beats 96.68%!
     * see the source code!! ( using the str.value(char[]) inside makes faster)
     * 
     * based on the source code: 1ms, beats 72.79%
     * using haystack.charAt(i) costs 4ms, proving that char[] is faster!
     */
    public int strStr2(String haystack, String needle) {
    	//return haystack.indexOf(needle);
    	if (needle.isEmpty()){
            return 0;
        }
        
        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();
        int max = s.length - t.length;
        char first = t[0];
        for (int i = 0; i <= max; i++){
            // find the first 
            while (i<= max && s[i] != first){
                i++;
            }
            // match the rest from index 1 
            if (i <= max){
                int j, k;
                for (j = 1, k = i+1; j < t.length && s[k] == t[j]; k++, j++);
                if (j == t.length){
                    return i;
                }
            }
        }
        return -1;
    }
    
    
    /**
     * 1ms, beats 72.79%
     * using the substring to compare
     */
    public int strStr3(String haystack, String needle) {
        if (needle.isEmpty()){
            return 0;
        }
        
        int len = needle.length();
        int max = haystack.length() - len;
        for (int i = 0; i <= max; i++){
            String tmp = haystack.substring(i, i+len);
            if (tmp.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
