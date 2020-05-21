package main.com.workbench;

import main.com.converter.Converter;
import main.com.converter.ConverterFactory;
import main.com.converter.ConverterFactoryImpl;

/**
 * Demonstrates how to :
 * 1 - Use the converter to parse through different file types 
 * 2 - generate a sorted users list
 * 3 - Regenerate the files with the full list of users
 * 
 * 
 * @author Al-HaidaryZ
 *
 */
public class ReadWriteFiles {


	public static void main(String[] args) {
		
		/**
		 * The ConverterFactory is an interface whose implementation creates new converter of
		 * whatever implementation it chooses depending on the file type (Factory design pattern)
		 */
		
		ConverterFactory cf = new ConverterFactoryImpl();

		/**
		 * The Converter here is applying the polymorphism principle where by the 
		 * parent class reference is used to refer to a child class object.
		 *  The converter factory create the suitable converter
		 */
		Converter xmlConverter =  cf.createConverter("data/users.xml");
		Converter jsonConverter =  cf.createConverter("data/users.json");
		
		/**
		 * Converters parsing different files 
		 */
		xmlConverter.unserialize();
		jsonConverter.unserialize();

		/**
		 * Converters generating new files to createdFiles folder
		 */
		xmlConverter.serialize();
		jsonConverter.serialize();
		
		/**
		 * Clearing users list to start a new list of users when needed 
		 */
		Converter.clearUsers();
		
//		xmlConverter.unserialize();
//		xmlConverter.serialize();
		
		
	}

}
