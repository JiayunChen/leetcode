package String;
/**
 * https://leetcode.com/problems/basic-calculator-ii/
 * 
 * Tag: String (Medium)
 * simple calculate(+ - * /), not including brackets
 * 
 * 27ms, beats 79.16%
 * then 14ms, beats 94.85%
 * 
 */
public class LC227_BasicCalculate {
	/**
	 * 27ms, beats 79.16%
	 * ||
	 * calculate integer instead of using substring
	 * ||
	 * 14ms, beats 94.85%
	 */
	public int calculate(String s) {
        int top = 0, len = s.length();
        char[] str = s.toCharArray();
        int[] stack = new int[len];
        char op = '#';
        // int start = 0;
        for (int i = 0; i< len; i++){
            while (i < len && str[i] == ' '){
                i++;
            }
            if (i < len){
                if (str[i] >= '0' && str[i] <= '9'){
                	/*
                    start = i;
                    while (i < len && str[i] >= '0' && str[i] <= '9'){
                        i++;
                    }
                    int num = Integer.valueOf(s.substring(start, i)); // Better not use this
                    */
                	int num = str[i++] - '0';
                    while (i < len && str[i] >= '0' && str[i] <= '9'){
                        num = (str[i] - '0') + num * 10;
                        i++;
                    }
                    
                    if (op != '#'){
                        num = calculate(stack[--top], num, op); // --top not top--
                        op = '#';
                    }
                    stack[top++] = num;
                    i--;
                }
                else if (str[i] == '+' || str[i] == '-'){
                    stack[top++] = str[i];
                }
                else if (str[i] == '*' || str[i] == '/'){
                    op = str[i];
                }
            }
        }
        int result = stack[0];
        for (int i = 1; i < top; i++){
            op = (stack[i++] == '+')? '+': '-';
            int b = stack[i];
            result = calculate(result, b, op);
        }
        return result;
    }
    
    private int calculate(int a, int b, char op){
        switch(op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }
        return a;
    }
}
