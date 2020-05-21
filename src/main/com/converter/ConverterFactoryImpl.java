package main.com.converter;


/**
 * This class implements the ConverterFactory interface 
 * 
 * @author Al-HaidaryZ
 *
 */
public class ConverterFactoryImpl implements ConverterFactory{


	/**
	 * Creates specific converter depending on file type
	 * @param String file
	 * @return Converter
	 */
	@Override
	public Converter createConverter(String file) {
		if(file.endsWith(".xml"))
		{
			return new XmlConverter(file);
		}
		else if(file.endsWith(".csv"))
		{
			return new CsvConverter(file);
		}
		else if(file.endsWith(".json"))
		{
			return new JsonConverter(file);
		}
		
		return null;
	}

	

	
}
