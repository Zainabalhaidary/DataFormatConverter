package main.com.converter;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

import main.com.business.Users;

/**
 * This is a child class of Converter. It serialize and unserialize xml file.
 * 
 * @author Al-HaidaryZ
 *
 */
public class XmlConverter extends Converter{
	
	
	/**
	 * It initializes the users list if it's being used for the first time
	 * @param file
	 */
	public XmlConverter() {
		Converter.users = this.getUsers();
	}
	
	/**
	 * Sets the file to be unserialized
	 * Initializes the users list if it's being used for the first time
	 * @param file
	 */
	public XmlConverter(String file) {
		this.file=file;
		Converter.users = getUsers(); 
	}

	/**
	 * This method parses xml files and saves the values into the static users list
	 */
	@Override
	public void unserialize() {

		try {
			
			File file = new File(this.getFile());
            JAXBContext jaxbContext = JAXBContext.newInstance( Users.class );

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Users users = (Users)jaxbUnmarshaller.unmarshal( file );
            Converter.users.addAll(users.getUsers());
            

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * This method generates xml file from users list
	 * @return String file name
	 */
	@Override
	public String serialize() {
		
		String generatedFileName = null;
		
		try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance( Users.class );
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			/* set this flag to true to format the output */
			jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

			/* marshaling of java objects in xml  */
			if(Converter.users.getUsers().size()>0)
			{
				generatedFileName =generateFileName()+".xml";
				jaxbMarshaller.marshal(Converter.users, new File(generatedFileName) );
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return generatedFileName;
	}
	
	
}
