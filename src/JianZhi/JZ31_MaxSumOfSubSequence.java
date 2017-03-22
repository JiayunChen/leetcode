package JianZhi;

public class JZ31_MaxSumOfSubSequence {

	public static void main(String[] args){
		//1, -2, 3, 10, -4, 7, 2, -5
		int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
		System.out.println(MaxSum(data));
	}
	
	public static int MaxSum(int[] data){
		if (data.length < 1){
			return -1;
		}
		int max = data[0];
		int[] sum = new int[data.length];
		for (int i = 1; i < data.length; i++){
			sum[i] = data[i];
			if (sum[i-1] > 0){
				sum[i] += sum[i-1];
			}
		}
		for (int i = 1; i < data.length; i++){
			if (sum[i] > max){
				max = sum[i];
			}
		}
		return max;
	}

	
	
}
