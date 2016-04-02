/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        
        char[] temp = new char[4];
        boolean eof = false;
        int total = 0;
        while(!eof && total < n){
            int counter = read4(temp);
            for (int i = 0; i < counter && total < n; i++){
                buf[total++] = temp[i];
            }
            if (counter < 4) eof = true;
        }
        return total;
    }
}