package DynamicProgramming;
/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * Tag: Dynamic Programming / Binary Search (Medium)
 * 
 */
public class LC300_LongestIncreasingSubsequence {
	/**
	 * using BS, O(nlogn)
	 * 1ms, beats 85.74%
	 */
	public int lengthOfLIS(int[] nums) {
        int len = nums.length, k = 0;
        int[] b = new int[len + 1];
        b[0] = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++){
            if (nums[i] > b[k]){
                b[++k] = nums[i];
            }
            else if(nums[i] < b[k]){
                BinarySearch(b, k, nums[i]);
            }
        }
        return k;
    }
    
    public void BinarySearch(int[] b, int k, int num){
        int low = 1, high = k;
        while (low <= high){
            int mid = (low + high) / 2;
            if (b[mid] < num){ // can NOT set ==
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        b[low] = num;
    }
    
    /**
     * using DP£¬O(n^2)
     */
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (0 == len){
            return 0;
        }

        int max;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++){
            max = 1;
            for (int j = i - 1; j >= 0; j--){
                if (nums[i] > nums[j] && dp[j] + 1 > max){
                    max = dp[j] + 1;  // without max, it costs 7ms more time??
                }
            }
            dp[i] = max;
        }

        max = 1;
        for (int i = 1; i < len; i++){
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

}
