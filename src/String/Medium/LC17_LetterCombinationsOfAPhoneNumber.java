package String.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 2016.08.11
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Tag: String (Medium)
 * 
 * recursion¡¢BFS(queue)¡¢DFS(stack)
 * all uses 1ms, beats 46.16% = =
 * 
 */
public class LC17_LetterCombinationsOfAPhoneNumber {
	/**
	 * using stack
	 * -- a d g (output)
	 * -- a d h (output)
	 * -- a d i (output)
	 * -- a d f ('i' is the last, go back)
	 * -- a e g (output)
	 * -- ...
	 */
	public List<String> letterCombinations3(String digits) {
        List<String> list = new ArrayList<>();
        char[] str = digits.toCharArray();
        int len = str.length;
        if (len > 0){
            char[] start = {'w', 't', 'p', 'm', 'j', 'g', 'd', 'a'};
            char[] end = {'z', 'v', 's', 'o', 'l', 'i', 'f', 'c'};
            char[] stack = new char[len];
            int i = 0;
            while (i < len){
                if (str[i] <= '1' || str[i] > '9'){
                    i = -1;
                    break;
                }
                stack[i] = start[('9' - str[i++])];
            }
            
            while (i >= 0){
                if (i == len){
                    list.add(new String(stack));
                    i--;
                }
                
                if (stack[i] != end[('9' - str[i])]){
                    stack[i] = (char)(stack[i] + 1);
                    i++;
                }
                else{
                    stack[i] = (char)(start[('9' - str[i])] - 1);
                    i--;
                }
            }
        }
        return list;
    }
	
	/**
	 * C++ version
	 * 0ms, beats 17.18%
	 vector<string> letterCombinations(string digits) {
        vector<string> result;
        int len = digits.size();
        if (len > 0){
            char start[] = {'0', '0', 'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
            char end[] = {'0', '0', 'c', 'f', 'i', 'l', 'o', 's', 'v', 'z'};
            char stack[len+1];
            int i = 0;
            for (; i < len; i++){
                if (digits[i] <= '1' || digits[i] > '9'){
                    return result;
                }
                stack[i] = start[digits[i] - '0'];
            }
            while (i >= 0){
                if (i == len){
                    stack[i] = '\0';
                    result.push_back(stack);
                    i--;
                }
                if (stack[i] != end[digits[i] - '0']){
                    stack[i] = (char)(stack[i] + 1);
                    i++;
                }
                else{
                    stack[i] = (char)(start[digits[i] - '0'] - 1);
                    i--;
                }
            }
        }
        return result;
     }
	 */
	
	/**
	 * using queue
	 * -- a b c
	 * --   b c ad ae af
	 * --     c ad ae af bd be bf
	 * --       ad ae af bd be bf cd ce cf
	 * --          ae af bd be bf cd ce cf adg adh adi
	 */
	public List<String> letterCombinations2(String digits) {
        List<String> list = new ArrayList<>();
        char[] str = digits.toCharArray();
        int len = str.length;
        if (len > 0){
            if (str[0] <= '9' && str[0] > '1'){
                int size = (int)Math.pow(4, len) + 1, head = 0, tail = 0;
                String[] queue = new String[size];
                
                char[] chs = {'w', 't', 'p', 'm', 'j', 'g', 'd', 'a'};
                int num = (str[0] == '7' || str[0] == '9')? 4: 3;
                for (int j = 0; j < num; j++){
                    queue[tail] = "" + (char)(chs[('9' - str[0])] + j);
                    tail = (tail + 1) % size;
                }
                
                for (int i = 1; i < len; i++){
                    if (str[i] <= '1' || str[i] > '9'){
                        head = tail;
                        break;
                    }
                    num = (str[i] == '7' || str[i] == '9')? 4: 3;
                    for (int now = tail; head < now; head = (head + 1) % size){
                        for (int j = 0; j < num; j++){
                            queue[tail] = queue[head] + (char)(chs[('9' - str[i])] + j);
                            tail = (tail + 1) % size;
                        }
                    }
                }
                
                while (head != tail){
                    list.add(queue[head]);
                    head = (head + 1) % size;
                }
            }
        }
        return list;
    }
	
	/**
	 * using recursion
	 * 
	 */
	public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        char[] str = digits.toCharArray();
        int len = str.length;
        if (len > 0){
            combines(list, str, len, 0, "");
        }
        return list;
    }
    
    private void combines(List<String> list, char[] str, int length, int index, String result){
        if (index == length){
            list.add(result);
            return;
        }
        
        if (str[index] > '1' && str[index] <= '9'){
            int[] offset = {22, 19, 15, 12, 9, 6, 3, 0};
            char start = (char)('a' + offset[('9' - str[index])]);
            if (str[index] == '7' || str[index] == '9'){
                for (int i = 0; i < 4; i++){
                    combines(list, str, length, index+1, result + (char)(start + i));
                    //sb.deleteCharAt(sb.length() - 1);
                }
            }
            else{
                for (int i = 0; i < 3; i++){
                    combines(list, str, length, index+1, result + (char)(start + i));
                }
            }
        }
    }
}
