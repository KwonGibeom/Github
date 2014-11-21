package users;

import java.util.List;

import abstraction.CRUDable;
import abstraction.IDValuePair;
import users.Users;

public interface UsersDAO extends CRUDable{
	public <T extends IDValuePair> long  count(T t);
	public List<Users> getList();
	
	public boolean authenticate(String accountName, String clearPassword);
	public Users authenticate(String accountName, String clearPassword,
			int authenticationMode);
	
	public class AuthenticationMode{
		public static final int BOOLEAN = 1;
		public static final int OBJECT = 2;
	}
	public <T extends IDValuePair> T readCompany(Class clas, String userId);
	public <T extends IDValuePair> List<T> list(T t , long id);

}

