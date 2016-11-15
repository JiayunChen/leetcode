package Array;
/**
 * https://leetcode.com/problems/set-matrix-zeros/
 * 
 * Tag: Array (Medium)
 * given a matrix, when encounter a zero, set the row and line zeros
 *  * 
 * O(mn), 2ms, beats 23.87%
 * but its seems no better way
 * 
 */
public class LC73_SetMatrixZeros {
	/**
	 * the way without extra space
	 * be careful for the matrix[0][0]
	 */
	public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false, line = false;
        for (int i = 0; i < m; i++){
            if (0 == matrix[i][0]){
                line = true;
                break;
            }
        }
        for (int j = 0; j < n; j++){
            if (0 == matrix[0][j]){
                row = true;
                break;
            }
        }
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (0 == matrix[i][j]){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++){
            if (0 == matrix[i][0]){
                for (int j = 1; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++){
            if (0 == matrix[0][j]){
                for (int i = 1; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if (row){
            for (int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if (line){
            for (int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
	
	/**
	 * first try, using m+n extra space
	 * the easiest way
	 */
	public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] zeroi = new int[m];
        int[] zeroj = new int[n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (0 == matrix[i][j]){
                    zeroi[i] = 1;
                    zeroj[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++){
            if (1 == zeroi[i]){
                for (int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++){
            if (1 == zeroj[j]){
                for (int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
