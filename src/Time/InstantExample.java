package Time;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {
	//Instant class is used to work with machine readable time format, it stores date time in unix timestamp.
	public static void main(String[] args) {
//		Read this: https://www.baeldung.com/java-zone-offset
		//Current timestamp
		Instant timestamp = Instant.now();
		System.out.println("Current Timestamp = "+timestamp);

		//Instant from timestamp
		Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println("Specific Time = "+specificTime);

		//Duration example
		Duration thirtyDay = Duration.ofDays(2);
		//PT48H
		System.out.println(thirtyDay);

	}
}
