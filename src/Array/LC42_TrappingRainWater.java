package Array;
/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Tag: Array, Stack, Two Pointers (Hard)
 * O(n), 19ms, beats 93.30%
 */
public class LC42_TrappingRainWater {
	public int trap(int[] height) {
        int cur = 0, sum = 0, top = 0, topHeight = 0;
        for (int i = 0;  i < height.length; i++){
            if (height[i] >= topHeight){
                top = i;
                topHeight = height[i];
                sum += cur;
                cur = 0;
            }
            else{
                cur += topHeight - height[i];
            }
        }
        cur = 0;
        topHeight = 0;
        for (int j = height.length - 1; j >= top; j--){
            if (height[j] >= topHeight){
                topHeight = height[j];
                sum += cur;
                cur = 0;
            }
            else{
                cur += topHeight - height[j];
            }
        }
        return sum;
    }
}
