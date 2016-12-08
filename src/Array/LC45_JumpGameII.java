package Array;
/**
 * https://leetcode.com/problems/jump-game-ii/
 * find the closet sum of three integers to the given number
 * 
 * Example:
 * A = [2,3,1,1,4], return 2.
 * 
 * Tag: Array, Greedy (Hard)
 * 10ms, beats 57.73% 
 * right algorithm, bad performance, don't know why
 *  
 */
public class LC45_JumpGameII {
	public int jump(int[] nums) {
        int cur = 0, next = 0, step = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > cur){
                cur = next;
                step++;
            }
            if (i + nums[i] > next){
                next = i + nums[i];
            }
        }
        return step;
    }
}
