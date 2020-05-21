package main.com.converter;


/**
 * The ConverterFactory is an interface whose implementation creates new converter of
 * whatever implementation it chooses depending on the file type (Factory design pattern)
 * 
 * 
 * @author Al-HaidaryZ
 */

public interface ConverterFactory {
	
	
	/**
	 * This method's implementation creates specific converter depending on the file type
	 * @param file
	 * @return Converter
	 */
	public Converter createConverter(String file);
	
}
