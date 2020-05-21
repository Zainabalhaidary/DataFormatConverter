package main.com.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import main.com.business.Constants;
import main.com.business.Users;

/**
 * The Converter class is the parent class of all the specific child converters (xml, json ...)
 * 
 * @author Al-HaidaryZ
 *
 */
public abstract class Converter {
	
	/**
	 * users: class owned list that holds the user values coming from different files
	 */
	protected static Users users = null;
	
	/**
	 * file: the file to be parsed
	 */
	protected String file = null;
	

	/**
	 * Abstract method to parse files
	 */
	public abstract void unserialize();
	
	
	/**
	 * Abstract method to generate files from users list
	 * @return String file name
	 */
	public abstract String serialize();
	
	
	/**
	 * Sets the users list
	 * @param uList: users list
	 */
	public void setUSers(Users uList)
	{
		users =  uList;
	}
	
	/**
	 * Instantiate or retrieve the latest users list
	 * @return List<User>
	 */
	public Users getUsers(){
		if(users==null)
		{
			users = new Users();
		}
		
		return users;
	}
	
	/**
	 * Gets file name to be deserialized
	 * @return String
	 */
	public String getFile() {
		return file;
	}
	
	
	/**
	 * Clear users list and initializes a new one.
	 */
	public static void clearUsers(){		
			users = new Users();
	}

	
	/**
	 * Generates file name to be serialized
	 * @return String
	 */
	public String generateFileName()
	{
		return "createdFiles/users"+new SimpleDateFormat(Constants.FILENAME_DATE_FORMAT)
		.format(new Date());
	}
}
