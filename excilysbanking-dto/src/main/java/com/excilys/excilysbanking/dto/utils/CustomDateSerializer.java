
package com.excilys.excilysbanking.dto.utils;

import java.io.IOException;
import java.util.Locale;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class CustomDateSerializer extends JsonSerializer<DateTime> {
	
	private static DateTimeFormatter formatter = DateTimeFormat.shortDate();
	
	public static void setLocale(Locale locale) {
		CustomDateSerializer.formatter = DateTimeFormat.shortDate().withLocale(locale);
	}
	
	@Override
	public void serialize(DateTime value, JsonGenerator gen, SerializerProvider arg2) throws IOException, JsonProcessingException {
		gen.writeString(formatter.print(value));
	}
}