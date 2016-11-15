package Array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/majority-element/
 * 
 * Tag: Array (Easy), Divide and Conquer, Bit Manipulation
 * return the element that appears MORE than n/2 times(assumes non-empty array and the element must exists)
 * though it's quite easy, there're many interesting ways to solve the problem
 *  
 */
public class LC169_MajorityElement {
	/**
	 * quite interesting, find the element appears more than n/k time
	 * main idea: remove the different elements, and the result appears
	 */
	public int majorityElement(int[] nums) {
        int cnt = 0, result = 0;
        for (int i = 0; i < nums.length; i++){
            if (0 == cnt){
                result = nums[i];
                cnt++;
            }
            else{
                if (result == nums[i]){
                    cnt++;
                }
                else{
                    cnt--;
                }
            }
        }
        return result;
    }
	
	/**
	 * first way came to my mind
	 * O(nlogn), 5ms, 33.19%
	 */
	public int majorityElement2(int[] nums) {
        int len = nums.length;
        int i = 0, step = len/2;
        Arrays.sort(nums);
        for (; i < step && nums[i] != nums[i+step]; i++);
        return nums[i];
        
        /**
         * the shorter code:
         * Arrays.sort(nums);
         * return nums[nums.length/2];
         */
    }
}
