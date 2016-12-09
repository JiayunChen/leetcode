package Array;
/**
 * https://leetcode.com/problems/rotate-array/
 * 
 * Tag: Array (EasyT¡£T)
 *  
 */
public class LC189_RotateArray {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k %= len;
		reverse(nums, 0, len - k - 1);
		reverse(nums, len - k, len - 1);
		reverse(nums, 0, len - 1);
    }
	
	public void reverse(int[] nums, int s, int t){
		while (s < t){
			int tmp = nums[s];
			nums[s] = nums[t];
			nums[t] = tmp;
			s++;
			t--;
		}
	}
}
