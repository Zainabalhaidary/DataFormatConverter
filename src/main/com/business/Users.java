package main.com.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import main.com.comparator.UserComparator;



/**
 * User list class
 * 
 * @author Al-HaidaryZ
 *
 */
@XmlRootElement( name = "users" )
public class Users
{
	
    /**
     * Users constructor initialize users list
     */
    public Users() {
    	 if( this.users == null )
         {
             this.users = new ArrayList<User>();
         }
	}

	private List<User> users;

    /**
     * users list getter
     * @return List<User>
     */
    public List<User> getUsers()
    {
        return users;
    }

    
    /**
     * users list setter
     * @param users
     */
    @XmlElement( name = "user" )
    public void setUsers( List<User> users )
    {
        this.users = users;
    }

    /**
     * add new user to the users list in a sorted manner
     * @param user
     */
    public void add( User user )
    {
        if( this.users == null )
        {
            this.users = new ArrayList<User>();
        }
        this.users.add( user );
        this.sort( new UserComparator());
    }

    /**
     * Overrides Object.toString() method to print users list
     */
    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        for( User user : this.users )
        {
            str.append( user.toString() );
        }
        return str.toString();
    }
    
    /**
     * Sorts the users list using comparator
     * 
     * @param comparator
     */
    public void sort(Comparator<User> comparator)
    {
    	Collections.sort(this.users, comparator);
    }

    /**
     * Appends all the userList items to the main users list
     * @param userList
     */
    public void addAll(List<User> userList)
    {
    	users.addAll(userList);
    	this.sort( new UserComparator());
    }
}

