package JianZhi;

public class JZ41_FindContinuousSequenceWithSum {

	public static void main(String[] args){
		FindContinuousSequenceWithSum(15);
	}
	
	// 打印所有和为s的连续序列
	public static void FindContinuousSequenceWithSum(int s){
		if (s > 2){
			int mid = (1 + s) / 2;
			int small = 1, big = 2;
			int sum = small + big;
			while (small < mid){
				while (sum < s){
					big++;
					sum += big;
				}
				if (sum == s){
					for (int i = small; i < big; i++)
						System.out.print(i + " + ");
					System.out.println(big);
				}
				sum -= small;
				small++;
			}
			
		}
	}
}
