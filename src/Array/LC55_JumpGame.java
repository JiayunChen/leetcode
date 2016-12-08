package Array;
/**
 * https://leetcode.com/problems/jump-game/
 * find the closet sum of three integers to the given number
 * 
 * Example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * Tag: Array, Greedy (Medium)
 * 7ms, beats 87.80% 
 *  
 */
public class LC55_JumpGame {
	public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > reach){
                return false;
            }
            else if (i + nums[i] > reach){
                reach = i + nums[i];
            }
        }
        return (reach >= nums.length - 1);
    }
	
	public boolean canJump2(int[] nums) {
        int last = nums.length - 1;
        for (int i = last - 1; last > 0 && i >= 0; i--){
            if (i + nums[i] >= last){
                last = i;
            }
        }
        return (last <= 0);
    }
	
	/* using DP is unnecessary, using boolean[] to record costs O(n^2)
	 * using int[] to record the max length reachable, but r[i] is only related to r[i-1],
	 * so O(1) space is enough
	 */
}
