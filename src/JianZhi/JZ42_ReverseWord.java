package JianZhi;

public class JZ42_ReverseWord {

	public static void main(String[] args){
		System.out.println(ReverseWord("I am a student."));
		System.out.println(ReverseWord("Hello World"));
		System.out.println(ReverseWord("Thanks "));
	}
	
	public static String ReverseWord(String string){
		char[] str = string.toCharArray();
		reverse(str, 0, str.length);
		for (int i = 0, j = 0; j < str.length; ){
			while (j < str.length && str[j] != ' ')
				j++;
			if (j <= str.length){
				reverse(str, i, j);
				i = j + 1;
				j++;
			}
		}
		return new String(str);
	}
	
	public static void reverse(char[] str, int start, int end){
		for (int i = start, j = end - 1; i < j; i++, j--){
			char tmp = str[i];
			str[i] = str[j];
			str[j] = tmp;
		}
	}
}
