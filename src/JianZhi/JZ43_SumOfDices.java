package JianZhi;

public class JZ43_SumOfDices {

	public static void main(String[] args){
		JZ43_SumOfDices test = new JZ43_SumOfDices();
		test.SumOfDices(5);
	}
	
	public static int DICES_MAX = 6;
	public void SumOfDices(int n){
		int[][] probablities = new int[2][];
		probablities[0] = new int[DICES_MAX * n + 1];
		probablities[1] = new int[DICES_MAX * n + 1];
		int flag = 0;
		for (int i = 0; i <= DICES_MAX; i++){
			probablities[flag][i] = 1;
		}
		for (int k = 2; k <= n; k++){
			for (int i = 0; i < k; i++)
				probablities[1-flag][i] = 0;
			for (int i = k; i <= k * DICES_MAX; i++){
				probablities[1-flag][i] = 0;
				for (int j = 1; j < i && j <= DICES_MAX; j++)
					probablities[1-flag][i] += probablities[flag][i-j];
			}
			flag = 1 - flag;
		}
		double total = Math.pow(DICES_MAX, n);
		for (int i = n; i <= DICES_MAX * n; i++){
			System.out.println(i + "-" + probablities[flag][i]/total);
		}
	}
}
