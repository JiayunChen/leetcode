package JianZhi;

public class JZ45_LastNumberInCircle {
	
	public static void main(String[] args){
		int[] data = {3,4,5,1,2,6,7};
		System.out.println(LastNumberInCircle(data, 4));
	}

	// N��������mɾ��
	public static int LastNumberInCircle(int[] data, int m){
		if (data.length < 1){
			return -1;
		}
		int last = 0; // ע���������ʼ�����ͽ�������
		for (int i = 2; i <= data.length; i++){
			last = (last + m) % i;
		}
		return data[last];
	}
}
