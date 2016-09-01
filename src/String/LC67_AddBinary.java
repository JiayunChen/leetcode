package String;
/**
 * https://leetcode.com/problems/add-binary/
 * 
 * Tag: String (Easy)
 * 
 * binary add
 * judge a[i] == b[j] and notice the carry especially at the first bit and when the length of strings are different
 * 
 * O(n), 3ms, beats 90.73%
 * forget to reassign to the carry costing a WA
 * 
 */
public class LC67_AddBinary {
	public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if (aLen == 0 && bLen == 0){
            return "0";
        }
        int rLen = 2 * (aLen > bLen? aLen: bLen);
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        char[] result = new char[rLen];
        
        boolean carry = false;
        int i = aLen-1, j = bLen - 1, k = rLen - 1;
        for (; i >=0 && j >= 0; i--, j--, k--){
            if (aa[i] == bb[j]){ // 1+1, 0+0
                result[k] = carry? '1': '0';
                if (aa[i] == '1'){
                    carry = true;
                }
                else{
                    carry = false;
                }
            }
            else{ // 1+0
                result[k] = carry? '0': '1';
            }
        }
        for (; i>=0; i--, k--){
            if (!carry){
                result[k] = aa[i];
            }
            else{
                if (aa[i] == '1'){
                    result[k] = '0';
                }
                else{
                    result[k] = '1';
                    carry = false;
                }
            }
        }
        for (; j>=0; j--, k--){
            if (!carry){
                result[k] = bb[j];
            }
            else{
                if (bb[j] == '1'){
                    result[k] = '0';
                }
                else{
                    result[k] = '1';
                    carry = false;
                }
            }
        }
        if (carry){
            result[k--] = '1';
        }
        for (int m=k; m>=0; m--){
            result[m]='0';
        }
        
        String str = new String(result);
        return str.substring(k+1);
    }
}
