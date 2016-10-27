package DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 * 
 * find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * 
 * Tag: DynamicProgramming (Medium)
 * 
 * 35ms, beats 61.42%
 * 
 */
public class LC368_LargestDivisibleSubset {
	// using addFirst instead of reverse the list is 8ms faster
	public List<Integer> largestDivisibleSubset(int[] nums) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        //List<Integer> result = new ArrayList<Integer>();
        if (nums.length > 0){
            int[] pre = new int[nums.length];
            int[] dp = new int[nums.length];
            int longest = 1, idx = 0;
        
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++){
                dp[i] = 1;
                pre[i] = -1;
                for (int j = i-1; j >= 0; j--){
                    if (0 == nums[i] % nums[j] && dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            
            for (int i = 1; i < nums.length; i++){
                if (dp[i] > longest){
                    longest = dp[i];
                    idx = i;
                }
            }
            
            while(idx >= 0){
                //result.add(nums[idx]);
                result.addFirst(nums[idx]); // Only LinkedList can use addFirst
                idx = pre[idx];
            }
            //Collections.reverse(result);
        }
        return result;
    }
}
