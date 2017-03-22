package JianZhi;

public class JZ45_LastNumberInCircle {
	
	public static void main(String[] args){
		int[] data = {3,4,5,1,2,6,7};
		System.out.println(LastNumberInCircle(data, 4));
	}

	// N个数，逢m删除
	public static int LastNumberInCircle(int[] data, int m){
		if (data.length < 1){
			return -1;
		}
		int last = 0; // 注意下这个初始条件和结束条件
		for (int i = 2; i <= data.length; i++){
			last = (last + m) % i;
		}
		return data[last];
	}
}
