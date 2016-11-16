package Untag;
/**
 * 2016.11.16
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * 
 * (Medium)
 * 
 * find the longest substring of repeating letters with k times chance to replace the letter
 * "sliding window"
 * 
 * 9ms, beats 99.93%
 * 
 */
public class LC424_LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
        char[] str = s.toCharArray();
        int[] capital = new int[26];
        int most = 0, longest = 0, start = 0;
        for (int i = 0; i < str.length; i++){
            most = Math.max(most, ++capital[str[i] - 'A']);
            while (i - start + 1 - most > k){
                capital[str[start] - 'A']--;
                start++;
            }
            longest = Math.max(longest, i - start + 1);
        }
        return longest;
    }
}
