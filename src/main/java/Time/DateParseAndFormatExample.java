package Time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateParseAndFormatExample {
	public static void main(String[] args) {
		//Format examples
		LocalDate date = LocalDate.now();
		//default format
		System.out.println("Default format of LocalDate="+date);
		System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
		System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));

		LocalDateTime dateTime = LocalDateTime.now();
		//default format
		System.out.println("Default format of LocalDateTime="+dateTime);
		//specific format
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::yyyy HH::mm::ss")));
		System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

		Instant timestamp = Instant.now();

		//default format
		System.out.println("Default format of Instant="+timestamp);

		//Parse examples
		LocalDateTime dt = LocalDateTime.parse("27::окт.::2014 21::39::48",
				DateTimeFormatter.ofPattern("d::MMM::yyyy HH::mm::ss"));
		System.out.println("Default format after parsing = "+dt);

	}
}
