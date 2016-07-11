package String.Easy;
/**
 * https://leetcode.com/problems/add-binary/
 * 
 * Tag: String (Easy)
 * 
 * 就是二进制相加
 * 没有考虑转成数字来加，这样转来转去感觉也耗时，而且结果还有长度的问题
 * 直接判断同位是否相同，然后注意一下进位，特别要注意进位用完要重新赋值、最前一位的进位（比如两个1相加）以及两个数长度不一样的时候
 * 
 * 时间复杂度:O(n), 3ms, beats 90.73%
 * 由于忘了重新给进位赋值，导致第一次WA，改完才AC。并且还是有依赖Run Code来debug
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
