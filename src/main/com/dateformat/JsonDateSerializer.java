package main.com.dateformat;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.com.business.Constants;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
public class JsonDateSerializer implements JsonSerializer<Date> {

	/**
	 * Implements the serialize method of the interface JsonSerializer in order to parse an element of type date
	 * 
	 * @param date - The data being serialized
     * @param type  -The type of the Object to serialize to
     * @return JsonElement - a serialized object in the desired format
	 * */
	@Override
	public JsonElement serialize(Date date, Type type,JsonSerializationContext context) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT_TO);  
	    return new JsonPrimitive(sdf.format(date));
	}

}  
