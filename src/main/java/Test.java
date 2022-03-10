import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test implements Cloneable {
	public static void main(String[] args) {
//		BigDecimal decimal = new BigDecimal(2.112411);
//		System.out.println(decimal.setScale(2, RoundingMode.CEILING));
//
//
//		String a = "a";
//		String b = "a";
//		String c = new String("a");
//
//		System.out.println(a==b);
//		System.out.println(c==a);

		Integer a1 = 128;
		Integer a2 = 128;
		Long a3 = 127L;
		Long a4 = 127L;
//		Long a5 = 127L;

		System.out.println(a1==a2);
		System.out.println(a3==a4);
//		System.out.println(a3==1L);

//		Collections.emptyList().get(0);
		//com1
		//com2
		//com3
		//commit mast1
		//commit mast2

		Map<String, BigDecimal> map = new HashMap<>();
		if(map.containsKey("name")){
			BigDecimal newValue =  map.get("name").add(new BigDecimal("new value"));
			map.put("name", newValue);
		} else{
			map.put("name", new BigDecimal("241"));
		}

		map.entrySet().stream().forEach(es -> {
			//запись в файл
		});

		for (Map.Entry<String, BigDecimal> entry :map.entrySet()) {
			//запись в файл
		}




	}
}
