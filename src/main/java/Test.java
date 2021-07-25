import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;

public class Test implements Cloneable {
	public static void main(String[] args) {
		BigDecimal decimal = new BigDecimal(2.112411);
		System.out.println(decimal.setScale(2, RoundingMode.CEILING));
//
//
//		String a = "a";
//		String b = "a";
//		String c = new String("a");
//
//		System.out.println(a==b);
//		System.out.println(c==a);

		Integer a1 = 2;
		Integer a2 = 2;
		Long a3 = 128L;
		Long a4 = 128L;
//		Long a5 = 127L;

		System.out.println(a1==a2);
		System.out.println(a3==a4);
//		System.out.println(a3==1L);

//		Collections.emptyList().get(0);
	}
}
