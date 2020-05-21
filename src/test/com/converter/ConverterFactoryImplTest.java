package test.com.converter;

import static org.junit.Assert.*;
import main.com.converter.Converter;
import main.com.converter.ConverterFactory;
import main.com.converter.ConverterFactoryImpl;

import org.junit.Test;

public class ConverterFactoryImplTest {

	@Test
	public void testCreateConverter_Xml() {
		//fail("Not yet implemented");
		ConverterFactory cf = new ConverterFactoryImpl();
		Converter converter = cf.createConverter(".xml");
		String actualResult = converter.getClass().getSimpleName();
		String expectedResult = "XmlConverter";
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testCreateConverter_Json() {
		//fail("Not yet implemented");
		ConverterFactory cf = new ConverterFactoryImpl();
		Converter converter = cf.createConverter(".json");
		String actualResult = converter.getClass().getSimpleName();
		String expectedResult = "JsonConverter";
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testCreateConverter_Csv() {
		//fail("Not yet implemented");
		ConverterFactory cf = new ConverterFactoryImpl();
		Converter converter = cf.createConverter(".csv");
		String actualResult = converter.getClass().getSimpleName();
		String expectedResult = "CsvConverter";
		assertEquals(expectedResult, actualResult);
	}

}
