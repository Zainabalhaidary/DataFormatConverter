package test.com.converter;

import static org.junit.Assert.*;

import java.util.Date;

import main.com.business.User;
import main.com.business.Users;
import main.com.converter.Converter;
import main.com.converter.ConverterFactory;
import main.com.converter.ConverterFactoryImpl;
import main.com.converter.XmlConverter;

import org.junit.Test;

public class ConverterTest {

	@Test
	public void testUnserialize_Xml() {
		ConverterFactory cf = new ConverterFactoryImpl();
		Converter converter = cf.createConverter("data/users.xml");
		converter.unserialize();
		int expectedUserListSize = 3;
		Users users= converter.getUsers();
		int actualUserListSize = users.getUsers().size();
		assertEquals(expectedUserListSize, actualUserListSize);
	}

	@Test
	public void testSerialize_Xml() {
		Users users = new Users();

		User user1 = new User();
		user1.setUserId(1);
		user1.setFirstName("user1 fn");
		user1.setLastName("user1 ln");
		user1.setUserName("user1 un");
		user1.setUserType("user1 ut");
		user1.setLastLoginTime(new Date());

		users.add(user1);

		User user2 = new User();
		user2.setUserId(1);
		user2.setFirstName("user2 fn");
		user2.setLastName("user2 ln");
		user2.setUserName("user2 un");
		user2.setUserType("user2 ut");
		user2.setLastLoginTime(new Date());

		users.add(user2);

		Converter converter = new XmlConverter();
		converter.setUSers(users);
		//making sure the file is being generated 
		String file = converter.serialize();

		assertNotEquals(file, null);

		Converter.clearUsers();

		converter = new XmlConverter(file);

		converter.unserialize();

		int expectedUsersCount = 2; //because we only added two users: user1,user2
		users = converter.getUsers();

		int actualUsersCount = users.getUsers().size();
		//making sure the file content is correct
		assertEquals(expectedUsersCount, actualUsersCount);
	}


	@Test
	public void testClearUsers() {

		Users users = new Users();

		User user1 = new User();
		user1.setUserId(1);
		user1.setFirstName("user1 fn");
		user1.setLastName("user1 ln");
		user1.setUserName("user1 un");
		user1.setUserType("user1 ut");
		user1.setLastLoginTime(new Date());

		users.add(user1);

		User user2 = new User();
		user2.setUserId(1);
		user2.setFirstName("user2 fn");
		user2.setLastName("user2 ln");
		user2.setUserName("user2 un");
		user2.setUserType("user2 ut");
		user2.setLastLoginTime(new Date());

		users.add(user2);

		Converter converter = new XmlConverter();
		//user list size = 2
		converter.setUSers(users);

		Converter.clearUsers();

		assertEquals(0,converter.getUsers().getUsers().size());
	}

}
