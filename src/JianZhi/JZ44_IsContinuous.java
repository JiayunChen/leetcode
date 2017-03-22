package JianZhi;

public class JZ44_IsContinuous {
	public static void main(String[] args){
		int[][] data = {{1,2,0,3,5},{1,2,4,6,0},{2,3,4,5,6},{1,3,0,0,4},{1,3,5,0,0}}; 
		for (int i = 0; i < data.length; i++){
			System.out.println((IsContinuous(data[i], data[i].length))? "true": "false");
		}
	}
	
	// ����0��������Ҳ����ַ��������ˡ����û��֤�Դ��
	public static boolean IsContinuous (int[] data, int m){
		int[] poker = new int[14];
		int gap = 0, start = -1, end = -1;
		for (int i = 0; i < data.length; i++){
			if (data[i] < 15 || data[i] >= 0)
				poker[data[i]]++;
		}
		for (int i = 0; i < 14; i++){
			if (poker[i] > 0){
				start = (start < 0)? i: start;
				end = i;
			}
		}
		return (end - start + 1 - m <= poker[0]);
	}	
	// ������Ļ�12345��23456��JQK12����˳�ӣ�10JQKA��İ�
}

