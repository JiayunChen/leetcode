package String;
/**
 * https://leetcode.com/problems/simplify-path/
 * 
 * Tag:String(Medium)
 * to simplify the path
 * notice './' and '../' and the redundant '/'
 * 
 * example:
 * "///abc/" => "/abc"
 * "abcd" => "/abcd"
 * "ab/./../c/d/.." => "/c "
 * "./de" => "/de"
 * "/../" => "/"
 *
 * O(n), 5ms, beats 98.47%
 * using ASM (state machine)
 * 
 */
public class LC71_SimplifyPath {
	public static enum STATE{
        START, CHAR, SLASH, DOT, DDOT
    }
    
    public String simplifyPath(String path) {
        char[] p = path.trim().toCharArray();
        int i= 0, j = 0, len = p.length;
        char[] result = new char[len+1]; // len+1 in case add '/' in the front
        STATE state = STATE.START;
        result[j++] = '/';
        while(i < len){
            switch(state){
                case START:
                    if (p[i] == '.'){
                        state = STATE.DOT;
                        i++;
                    }
                    else if (p[i] == '/'){
                        state = STATE.SLASH;
                    }
                    else{
                        state = STATE.CHAR;
                    }
                    break;
                case CHAR:
                    result[j++] = p[i++];
                    if (i < len && p[i] == '/'){
                        state = STATE.SLASH;
                    }
                    break;
                case SLASH:
                    while (i < len && p[i] == '/'){
                        i++;
                    }
                    if (i < len){
                        if (result[j-1] != '/'){
                            result[j++] = '/';
                        }
                        state = STATE.START;
                    }
                    break;
                case DOT:
                    if (p[i] == '.'){
                        state = STATE.DDOT;
                        i++;
                    }
                    else if (p[i] == '/'){
                        state = STATE.START;
                        i++;
                    }
                    else{
                        result[j++] = '.';
                        state = STATE.CHAR;
                    }
                    break;
                case DDOT:
                    if (p[i] == '/'){
                        j = getLastSlash(result, j);
                        state = STATE.START;
                        i++;
                    }
                    else{
                        result[j++] = '.';
                        result[j++] = '.';
                        state = STATE.CHAR;
                    }
                    break;
            }
        }
        if (state == STATE.DDOT){
            j = getLastSlash(result, j);
        }
        if (j > 1 && result[j-1] == '/'){
            j--;
        }
        return new String(result, 0, j);
    }
    
    private int getLastSlash(char[] result, int j){
        int k = j - 2; // result[j-1] must be '/'
        while (k >= 0 && result[k] != '/'){
            k--;
        }
        if (k >= 0){
            return k + 1;
        }
        return j;
    }
}
