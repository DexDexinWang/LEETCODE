
public class Solution158 {
	
	public class Reader4{
		int read4(char[] chars) {
			return -1;
		}
	}
	
	public class Solution extends Reader4 {
	    /**
	     * @param buf Destination buffer
	     * @param n   Number of characters to read
	     * @return    The number of actual characters read
	     */
	    
	    private int left = 0;
	    private int right = 0;
	    private char[] buff = new char[4];
	    
	    public int read(char[] buf, int n) {
	        
	        int ptr = 0;
	        
	        while (ptr < n) {
	            
	            if (left == 0) 
	                right = read4(buff);
	            
	            if (right == 0)
	                break;
	            
	            while (ptr < n && left < right) {
	                buf[ptr++] = buff[left++];
	            }
	            
	            if (left >= right) 
	                left = 0;
	        }
	        return ptr;
	    }
	}

}
