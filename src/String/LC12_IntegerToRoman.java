package String;
/**
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * Tag: String (Medium)
 * 
 * O(n), 8ms, beats 71.99%
 * integer from 1~3999
 * 
 */
public class LC12_IntegerToRoman {
	public String intToRoman(int num) {
        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder sb = new StringBuilder();
        int d, digits = 1;
        for (d = 10; num / d > 0; d *= 10, digits++);
        for (d /= 10; d >= 1; d /= 10, digits--){
            int cur = num / d;
            if (cur < 4){
                for (int i = 0; i < cur; i++){
                    sb.append(symbol[2*(digits-1)]);
                }
            }
            else if (cur == 4){
                sb.append(symbol[2*(digits-1)]);
                sb.append(symbol[2*(digits-1)+1]);
            }
            else if (cur == 9){
                sb.append(symbol[2*(digits-1)]);
                sb.append(symbol[2*digits]);
            }
            else{
                sb.append(symbol[2*(digits-1)+1]);
                for (int i = 5; i < cur; i++){
                    sb.append(symbol[2*(digits-1)]);
                }
            }
            num %= d;
        }
        return sb.toString();
    }
	
	/**
	 * A simple way from discuss, quite tricky
	 * 6ms, beats 98.63%
	 */
	private static String M[] = {"","M","MM","MMM"};
    private static String C[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    private static String X[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    private static String I[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    public String intToRoman2(int num) {
        StringBuilder roman = new StringBuilder();
	    return roman.append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[num%10]).toString();
   }
}
