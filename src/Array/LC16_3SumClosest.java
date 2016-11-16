package Array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/majority-element/
 * find the closet sum of three integers to the given number
 * 
 * Input: array = [1,2,1,-1], target = 1
 * Output: 2(-1+2+1)
 * 
 * Tag: Array, Two Pointers (Medium)
 * 16ms, beats 97.23% 
 *  
 */
public class LC16_3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = 0, diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++){
            int low = i + 1, high = nums.length - 1;
            while (low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target){
                    return target;
                }
                else if (sum < target){
                    if (target - sum < diff){
                        diff = target - sum;
                        closet = sum;
                    }
                    low++;
                }
                else{
                    if (sum - target < diff){
                        diff = sum - target;
                        closet = sum;
                    }
                    high--;
                }
            }
        }
        return closet;
    }
}
