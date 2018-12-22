package user;

public class Userservices {
private Usercontroller uc;
	
	
	public void setUc(Usercontroller uc) {
		this.uc = uc;
	}
	 public boolean signup(User all)
	{
		User u = uc.getuser(all.getName());
		if(u==null)
		{
			uc.insertuser(all);
			return true ;
		}
		else return false ;
	}
	
	
	 public boolean signin(User all)
	{
		
		User u = uc.getuser(all.getName());
		if(u!=null)
		{
			if(u.getPassword().equals(all.getPassword()))
			{
				return true ;
			}
			else return false ;
			
		}
		else return false ;
		
	}
}
