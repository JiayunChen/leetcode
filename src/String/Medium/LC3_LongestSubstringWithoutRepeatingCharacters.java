package String.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Tag: String (Medium)
 * - string.length() is better than cstr.length
 * - java init "int" variable as 0 
 * - only 256 characters
 * 
 * Round1: 114ms, beats 7.79%
 * First Medium try, Worst result!!!What have I done= =
 * It must be an O(n) way
 * 
 * Round2: 16ms, beats 71.75% 
 * the O(n) way, record the previous occurance index
 * 
 * Round3: 4ms, beats 98.53%
 * using int[] instead of Map
 * 
 */
public class LC3_LongestSubstringWithoutRepeatingCharacters {
	/**
	 * 4ms, beats 98.53%
	 * use the map to record the index
	 * the "Map" stucture costs time
	 */
	public int lengthOfLongestSubstring3(String s) {
        int len = s.length();
        int max = 0, start = 0;
        int[] prev = new int[256]; // using as map
        char[] str = s.toCharArray();
        for (int i = 0; i < len; i++){
            if (prev[str[i]] > start){
                if (max < (i - start)){
                    max = i - start;
                }
                start = prev[str[i]];
            }
            prev[str[i]] = i + 1; // don't use index in case mistaking default 0 as value
        }
        int cnt = len - start;
        return (max > cnt)? max: cnt;
    }
	
	/**
	 * 16ms, beats 71.75%
	 * use the map to record the index
	 * the "Map" stucture costs time
	 */
	public int lengthOfLongestSubstring2(String s) {
		Map map = new HashMap();
        char[] str = s.toCharArray();
        int max = 0, len = s.length(); // str.length costs more time(2ms) than s.length()
        for (int i = 0, cnt = 0, start = 0; i < len; i++){ // using str.length instead of len costs 3ms
            if (map.containsKey(str[i])){
                int prev = (int)map.get(str[i]);
                if (prev >= start){
                    start = prev + 1;
                    cnt = i - start;
                }
            }
            map.put(str[i], i);
            if (max < ++cnt){ // put this in "if (prev >= start)" costs 1 more ms, why??
                max = cnt;
            }
        }
        return max;
    }
	
	/**
	 * 114ms, beats 7.79%
	 * garbage!!
	 */
	public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int len = s.length();
        int[] first = new int[len];
        for (int i = 0; i < len; i++){
            first[i] = s.indexOf(s.charAt(i));
        }
        for (int i = 0, start = 0; i < len; ){
            int cnt = 0;
            boolean ok = true;
            for (i = start; i < len && ok; ){
                if (first[i] != i){
                    for (int j = start; j < i; j++){ // No need to go back to compare
                        if (first[j] == first[i]){
                            start = j + 1;
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok){
                    cnt++;
                    i++;
                }
            }
            if (max < cnt){
                max = cnt;
            }
        }
        return max;
    }
}
