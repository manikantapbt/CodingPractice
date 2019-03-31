import java.math.BigInteger;

public class ConstructtheArray {

	public static void main(String[] args) {
		int n=72071;
		int k=66860;
		System.out.println(constructTheArray(n,k));
	}

	public static int  constructTheArray(Integer n,Integer k) {
		BigInteger mod = BigInteger.valueOf(10).pow(9).add(BigInteger.valueOf(7));
		BigInteger n1 = BigInteger.valueOf(n);
		BigInteger k1 = BigInteger.valueOf(k-1);
		BigInteger res= BigInteger.valueOf(k-2).mod(mod);
		System.out.println(mod.intValue()+" "+res.intValue()+" "+k1.intValue());
		for(int i=1;i<=n-3;i++) {
			res = (res.multiply(k1)).mod(mod);
		}
		return (res.add(BigInteger.valueOf(1))).mod(mod).intValue();
	}
}
