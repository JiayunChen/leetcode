package String.Medium;
/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Tag: String (Medium)
 * 
 * 114ms, beats 7.79%
 * First Medium try, Worst result!!!What have I done= =
 * 
 */
public class LC3_LongestSubstringWithoutRepeatingCharacters {
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
                    for (int j = start; j < i; j++){
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
