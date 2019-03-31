import java.util.Arrays;
import java.util.Base64;

public class ByteArrayToString {
 
	public static void main(String[] args) {
		int[] a= {1,2,3};
		int[] b=Arrays.copyOf(a, a.length);
		a[1]=44;
		System.out.println(b[2]);
	}
}
