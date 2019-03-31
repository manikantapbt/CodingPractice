import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

public class ArraysTest {
	public static void main(String[] args) {

		String num="1234577777771889189";
		//System.out.println(find_smallest_number(num));
		int[] list = new int[20];
		list[0]=1;
	
	}
	
	   static String find_smallest_number(String num) {
	        for(int i=0;i<num.length();i++){
	            int leastIndex = findLeast(num.substring(i),i);
	            Character ci = num.charAt(i);
	            Character cLeast= num.charAt(leastIndex);
	            if(leastIndex==i||(ci.equals(cLeast))){
	                continue;
	            }
	            
	            else{
	                StringBuilder s = new StringBuilder(num);
	                char temp = num.charAt(i);
	                char temp1 = num.charAt(leastIndex);
	                s.setCharAt(leastIndex, temp);
	                s.setCharAt(i, temp1);
	                return s.toString();
	            }
	        }
	        return num;
	    }
	    static int  findLeast(String num,int k){
	        int len= num.length();
	        int least=num.charAt(len-1);
	        int leastIndex =len-1;
	        for(int i=len-1;i>=0;i--){
	            if(least>num.charAt(i)){
	                least=num.charAt(i);
	                leastIndex=i;
	            }
	        }
	        return leastIndex+k;
	    }
	
}
