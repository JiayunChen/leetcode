package JianZhi;

public class JZ12_Print1ToMaxOfNDigits {

	public static void main(String[] args){
		JZ12_Print1ToMaxOfNDigits test = new JZ12_Print1ToMaxOfNDigits(2);
	}
	
	public JZ12_Print1ToMaxOfNDigits(int n){
		if (n <= 0)
			return;
		
		char[] number = new char[n];
		Print1ToMaxOfNDigits(number, -1);
	}
	
	public void Print1ToMaxOfNDigits(char[] number, int index){
		if (index == number.length - 1){
			PrintNumber(number);
		}
		else{
			for (int i = 0; i < 10; i++){
				number[index + 1] = (char) (i + '0');
				Print1ToMaxOfNDigits(number, index + 1);
			}
		}
	}
	
	public void PrintNumber(char[] number){
		boolean zero = true;
		for (int i = 0; i < number.length; i++){
			if (zero && number[i] != '0')
				zero = false;
			if (!zero){
				System.out.print(number[i]);
			}
		}
		System.out.print(" ");
	}
}
