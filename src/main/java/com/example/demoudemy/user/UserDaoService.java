package com.example.demoudemy.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	//Logger logger = Logger.getLogger(UserDaoService.class.getName());
	private static List<User> users = new ArrayList();
	private static int usersCount = 4;
	static {
		users.add(new User(1, "Dhruthi", new Date()));
		users.add(new User(2, "Gu Jun Pyo", new Date()));
		users.add(new User(3, "Geum Jan Di", new Date()));
		users.add(new User(4, "Lee Min Ho", new Date()));
	}
	
	public List<User> findAll()
	{
		return users;
	}
	
	public User save(User user)
	{
		if(user.getId() == 0)
		{
			user.setId(++usersCount);
			users.add(user);
		//	logger.log(Level.INFO, String.format("User Count is %s", usersCount));
		}
		return user;
	}
	
	public User findOne(int id)
	{
		for(User user:users)
		{
			if(user.getId()==id)
				return user;
		}
		return null;
	}
	
	public User deleteById(int id)
	{
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext())
		{
			User user= iterator.next();
			if(user.getId() == id)
			{
				iterator.remove();
			    return user;	    
			}			
		}		
			return null;
	}
}
