package Untag;
/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * 
 * Tag: Bit Manipulation (EasyT¡£T)
 *  
 */
public class LC371_SumOfTwoIntegers {
	public int getSum(int a, int b) {
		while(b != 0)  
        {  
            int carry = a & b;  // AND to get the carry
            a = a ^ b;   		// Exclusive OR to add the sum 
            b = carry << 1;		// forward carry 
        }  
        return a;  
    }
}
