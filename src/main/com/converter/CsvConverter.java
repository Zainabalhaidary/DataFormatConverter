package main.com.converter;


public class CsvConverter extends Converter{

	
	/**
	 * It initializes the users list if it's being used for the first time
	 * @param file
	 */
	public CsvConverter() {
		Converter.users = this.getUsers();
	}
	
	/**
	 * Sets the file to be unserialized
	 * It initializes the users list if it's being used for the first time
	 * @param file
	 */	
	public CsvConverter(String file) {
		this.file=file;
		Converter.users = this.getUsers();
	}

	/**
	 * This method parses csv file and saves the values into the static users list
	 */
	@Override
	public void unserialize() {
		// TODO Auto-generated method stub
	}

	/**
	 * This method generates csv files from users list
	 */
	@Override
	public String serialize() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
