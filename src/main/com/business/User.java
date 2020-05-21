package main.com.business;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import main.com.dateformat.XmlDateAdapter;

import com.google.gson.annotations.SerializedName;


/**
 * This class represents the user data model 
 * 
 * @author Al-HaidaryZ
 *
 */
@XmlType( propOrder = { "userId", "firstName", "lastName", "userName", "userType" , "lastLoginTime"} )
@XmlRootElement( name = "user" )
public class User {

	@SerializedName("user_id")
	private int userId;
	@SerializedName("first_name")
	private String firstName;
	@SerializedName("last_name")
	private String lastName;
	@SerializedName("username")
	private String userName;
	@SerializedName("user_type")
	private String userType;
	@SerializedName("last_login_time")
	private Date lastLoginTime;


	public User() {
		// TODO Auto-generated constructor stub
	}


	/**UserId getter 
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**UserId setter 
	 * @param userId
	 */
	@XmlElement( name = "userid" )
	public void setUserId(int userId) {
		this.userId = userId;
	}


	/** FirstName getter 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/** FirstName setter
	 * @param firstName
	 */
	@XmlElement( name = "firstname" )
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/** LastName getter
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/** LastName setter
	 * @param lastName
	 */
	@XmlElement( name = "surname" )
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**UserName getter
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	
	/**UserName setter
	 * @param userName
	 */
	@XmlElement( name = "username" )
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/** UserType getter
	 * @return userType
	 */
	public String getUserType() {
		return userType;
	}

	/** UserType setter
	 * @param userType
	 */
	@XmlElement( name = "type" )
	public void setUserType(String userType) {
		this.userType = userType;
	}


	/** lastLoginTime getter
	 * @return lastLoginTime
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/** LastLoginTime getter
	 * @param lastLoginTime
	 */
	@XmlElement( name = "lastlogintime" )
	@XmlJavaTypeAdapter( XmlDateAdapter.class )
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/** 
	 * Overrides Object.toString() method to print User information
	 */
	@Override
	public String toString()
	{
		StringBuffer str = new StringBuffer( "userID: " + getUserId() + "\n" );
		str.append( "FirstName: " + getFirstName() + "\n" );
		str.append( "LastName: " + getLastName() + "\n" );
		str.append( "UserName: " + getUserName() + "\n" );
		str.append( "UserType: " + getUserType() + "\n" );
		str.append( "LastLoginTime: " + getLastLoginTime()+ "\n" );

		return str.toString();
	}


}
