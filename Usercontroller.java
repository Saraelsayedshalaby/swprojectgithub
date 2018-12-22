package user;

import java.util.ArrayList;

import util.NitriteDatabaseHelper;

public class Usercontroller {
	public Usercontroller(){
	
	}
	ArrayList<User> users=new ArrayList<>();

	
	User getuser (String name )//key of database 
	{
		users=NitriteDatabaseHelper.all(User.class);
		User myuser =null;
		for(User u:users)
		{
			if(u.getName().equals(name))
			{
				myuser=u;
				break;
			}
		}
		
		return myuser;
	}
	public ArrayList<User> gettAllUsers(){
		users=NitriteDatabaseHelper.all(User.class);
		return users;
	}
	void insertuser(User user)
	{
		//users.add(user);
		NitriteDatabaseHelper.insert(user, User.class);
	}
}
