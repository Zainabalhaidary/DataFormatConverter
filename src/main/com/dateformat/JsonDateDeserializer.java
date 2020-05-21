package main.com.dateformat;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import main.com.business.Constants;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class JsonDateDeserializer implements JsonDeserializer<Date>  {
	
	/**
	 * * Implements the deserialize method of the interface JsonDeserializer in order to parse an element of type date
     * 
     * @param element - The Json data being deserialized
     * @param type  -The type of the Object to deserialize to
     * @return date - a deserialized object of the specified type
     * @throws JsonParseException
	 */
	@Override
	public Date deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
		String date = element.getAsString();
		SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT_FROM);
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		try {
			return formatter.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
