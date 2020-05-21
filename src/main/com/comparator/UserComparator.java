package main.com.comparator;

import java.util.Comparator;

import main.com.business.User;

public class UserComparator implements Comparator<User>{


	@Override
	public int compare(User u1, User u2) {
		if(u1.getUserId()-(u2.getUserId())>0){
			return 1;    
		}else if(u1.getUserId()-(u2.getUserId())==0){
			return 0;
		}else if(u1.getUserId()-(u2.getUserId())<0){
			return -1;
		}
		return 0;
	}

}
