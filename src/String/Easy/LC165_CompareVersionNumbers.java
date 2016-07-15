package String.Easy;
/**
 * https://leetcode.com/problems/compare-version-numbers/
 * 
 * Tag: String (Easy)
 * 
 * # compare two version number
 * strip every integer to compare
 * notice that version does NOT only have two dots('.')
 * 
 * O(n), 2ms, beats 80.43%
 * 
 */
public class LC165_CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        if (len1 == 0 || len2 == 0){
            return (len1 > len2)? 1: (len1==len2? 0: -1);
        }
        
        int start1 = 0, start2 = 0, end1, end2;
        while (start1 < len1 && start2 < len2){
            end1 = getEndIndex(version1, start1);
            end2 = getEndIndex(version2, start2);
            int a = Integer.valueOf(version1.substring(start1, end1));
            int b = Integer.valueOf(version2.substring(start2, end2));
            if (a != b){
                return (a > b)? 1: -1;
            }
            start1 = end1 + 1;
            start2 = end2 + 1;
        }
        
        while (start1 < len1){
            end1 = getEndIndex(version1, start1);
            if (Integer.valueOf(version1.substring(start1, end1)) > 0){
                return 1;
            }
            start1 = end1 + 1;
        }
        while (start2 < len2){
            end2 = getEndIndex(version2, start2);
            if (Integer.valueOf(version2.substring(start2, end2)) > 0){
                return -1;
            }
            start2 = end2 + 1;    
        }
        return 0;
    }
    
    private int getEndIndex(String version, int fromIndex){
        int i = version.indexOf('.', fromIndex);
        return (i == -1)? version.length(): i;
    }
}
