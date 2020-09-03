
public class Solution405 {

	public static void main(String[] args) {
	}
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            int temp = num & 0b1111;
            String curr = "";
            switch(temp){
                case 10: curr = "a";break;
                case 11: curr = "b";break;
                case 12: curr = "c";break;
                case 13: curr = "d";break;
                case 14: curr = "e";break;
                case 15: curr = "f";break;
                default: curr =temp + "";
            }
            sb.append(curr);
            num >>>=4;
        }
        return sb.reverse().toString();
    }
}
