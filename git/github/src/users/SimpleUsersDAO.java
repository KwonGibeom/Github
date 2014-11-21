package users;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import abstraction.IDValuePair;

import users.Users;

public class SimpleUsersDAO implements UsersDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		Session session = null;
		try {
			System.out.println("getCurrentSession");
			session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (session == null) {
			System.out.println("openSession");
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	@Override
	public <T extends IDValuePair> T create(T t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		return t;
	}

	/** (non-Javadoc)
	 * @see users.usersDAO#update(abstraction.IDValuePair)
	 *
	 * @author Adam Hun/���ѿ�
	 * 2013. 10. 29.
	 * @description 
	 */
	@Override
	public <T extends IDValuePair> T update(T t) {
		// TODO Auto-generated method stub
		System.out.println("[SimpleusersDAO].update");
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		return t;
	}

	/** (non-Javadoc)
	 * @see users.usersDAO#delete(abstraction.IDValuePair)
	 *
	 * @author Adam Hun/���ѿ�
	 * 2013. 10. 29.
	 * @description 
	 */
	@Override
	public <T extends IDValuePair> boolean delete(T t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
		return true;
	}

	/** (non-Javadoc)
	 * @see abstraction.CRUDable#list(abstraction.IDValuePair)
	 *
	 * @author Adam Hun/���ѿ�
	 * 2014. 11. 4.
	 * @description 
	 */
	@Override
	public <T extends IDValuePair> List<T> list(T t) {
		String signature = "SimpleusersDAO.list(Class)";
		
		List<T> l = null;
	 
		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(t.getClass());
		c.setMaxResults(10);
		c.setFirstResult(1);
		l = (List<T>)c.list();
		if(l!=null && l.size()>0){
			System.out.println(signature + " list.size() : " + l.size());
		}else{
			System.out.println(signature + " null lis !! ");
		}
		return l;
	}

	/** (non-Javadoc)
	 * @see abstraction.CRUDable#list(java.lang.Class)
	 *
	 * @author Adam Hun/���ѿ�
	 * 2014. 11. 4.
	 * @description 
	 */
	@Override
	public <T extends IDValuePair> List<T> list(Class<T> t) {
		String signature = "SimpleusersDAO.list(Class)";
		List<T> l = null;
		System.out.println(signature + " for class : " + t.getName());
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(t);
		l = (List<T>)c.list();
		if(l!=null && l.size()>0){
			System.out.println(signature + " list.size() : " + l.size());
		}else{
			System.out.println(signature + " null lis !! ");
		}
		return l;
	}

	/** (non-Javadoc)
	 * @see abstraction.CRUDable#list(java.lang.Class)
	 *
	 * @author Adam Hun/���ѿ�
	 * 2014. 11. 4.
	 * @description 
	 */
	@Override
	public <T extends IDValuePair> List<T> list(Class<T> t, int page, int maxResults) {
		List<T> l = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			Criteria c = session.createCriteria(t.getClass());
			Example e = Example.create(t);
			e.enableLike(MatchMode.ANYWHERE);
			e.excludeZeroes();
			e.ignoreCase();
			c.add(e);
			c.setFirstResult((page-1)*maxResults);
			c.setMaxResults(maxResults);
			c.addOrder(Order.desc("id"));
			l = (List<T>)c.list();
		}catch(Exception e){
			System.out.println("SimpleusersDAO.list(Class, page, size).exception : ");
			e.printStackTrace();
		}
		return l;
	}


	/** (non-Javadoc)
	 * @see abstraction.CRUDable#list(abstraction.IDValuePair, int, int)
	 *
	 * @author KwonGibeom/권기범
	 * 2014. 11. 4.
	 * @description 
	 */
	@Override
	public <T extends IDValuePair> List<T> list(T t, int page, int maxResults) {
		// TODO Auto-generated method stub
		List<T> l = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			Criteria c = session.createCriteria(t.getClass());
			Example e = Example.create(t);
			e.enableLike(MatchMode.ANYWHERE);
			e.excludeZeroes();
			e.ignoreCase();
			c.add(e);
			c.setFirstResult((page-1)*maxResults);
			c.setMaxResults(maxResults);
			c.addOrder(Order.desc("id"));
			l = (List<T>)c.list();
		}catch(Exception e){
			System.out.println("SimpleusersDAO.list(Class, page, size).exception : ");
			e.printStackTrace();
		}
		return l;
		
	}

	/** (non-Javadoc)
	 * @see abstraction.CRUDable#read(java.lang.Class, long)
	 *
	 * @author KwonGibeom/권기범
	 * 2014. 11. 4.
	 * @description 
	 */
	@Override
	public <T extends IDValuePair> T read(Class clas, long id) {
		// TODO Auto-generated method stub
		String signature = "SimpleusersDAO.list(Class)";
		 System.out.println("reading with id : " + id );
		T found;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(clas);
		Long l = new Long(id);
		long intId = l.intValue();
		c.add(Restrictions.eq("id",intId));
		found = (T) c.uniqueResult();
		
		return found;
	}
	
	public <T extends IDValuePair> long  count(T t){
		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(t.getClass());
		c.setProjection(Projections.count("id"));
		Example e = Example.create(t);
		e.enableLike(MatchMode.ANYWHERE);
		e.excludeZeroes();
		e.ignoreCase();
		c.add(e);
		long count = (Long) c.uniqueResult();
		return count;
	}

	/** (non-Javadoc)
	 * @see users.usersDAO#update(abstraction.IDValuePair)
	 *
	 * @author Adam Hun/���ѿ�
	 * 2013. 10. 29.
	 * @description 
	 */
	@Override
	public <T extends IDValuePair> T merge(T t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.merge(t);
		return t;
	}

	@Override
	public List<Users> getList() {
		System.out.println(this.getClass().getSimpleName() + " : getList()");

		List<Users> l = null;
		Session session = getCurrentSession();
		Criteria c = session.createCriteria(Users.class);

		c.setFirstResult(0);
		c.setMaxResults(10);
		l = (List<Users>) c.list();

		return l;
	}
	
	@Override
	public boolean authenticate(String accountName, String clearPassword) {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		sb.append("clear password : " + clearPassword + " \n");
		
		
		String encrypted = generateEncrypted(clearPassword);

		sb.append("encrypted : " + encrypted + " \n");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SimpleUsers.class);
		criteria.add(Restrictions.eq("userId", accountName));
		sb.append("userId : " + accountName + " \n" );
		criteria.add(Restrictions.eq("users_password", encrypted));
		Object obj = criteria.uniqueResult();
		SimpleUsers users = null;
		if(obj!=null && obj instanceof SimpleUsers){
			users	= (SimpleUsers) obj;
			sb.append("login success \n");
			System.out.println(sb.toString());
			return true;
		}
		sb.append("login failure \n");
		System.out.println(sb.toString());
		return false;
	}
	
	@Override
	public Users authenticate(String accountName, String clearPassword,
			int authenticationMode) {
		Users users = null;
	 
		switch(authenticationMode){
			case UsersDAO.AuthenticationMode.OBJECT:{
				users = AuthenticateAndReturnUsers(accountName, clearPassword);
				break;
			}case UsersDAO.AuthenticationMode.BOOLEAN:{
				
				break;
			}default : {
				users = AuthenticateAndReturnUsers(accountName, clearPassword);
				break;
			}
		}
		
		return users;
	}
	
	//암호화방식 추가해야됨
	public String generateEncrypted(String source){
		String encrypted = "";
		
		/*Session session = sessionFactory.getCurrentSession();
		Query query  = session.createSQLQuery("SELECT 1 as id , SIDEEFFECT_ENCRYPT( :source ) AS encryptedPassword FROM DUAL").addEntity(UsersPassword.class);
		query.setParameter("source", source);
		
		Object obj = query.uniqueResult();
		if(obj!=null){
			UsersPassword mp = (UsersPassword)obj;
			encrypted = mp.getEncryptedPassword();
		}
		return encrypted;*/
		return source;
	}
	
	private Users AuthenticateAndReturnUsers(String accountName, String clearPassword){
		StringBuilder sb = new StringBuilder();
		sb.append("clear password : " + clearPassword + " \n");
		String encrypted = generateEncrypted(clearPassword);
		sb.append("encrypted : " + encrypted + " \n");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SimpleUsers.class);
		criteria.add(Restrictions.eq("userId", accountName));
		sb.append("userId : " + accountName + " \n" );
		criteria.add(Restrictions.eq("userPass", encrypted));
		Object obj = criteria.uniqueResult();
		SimpleUsers users = null;
		if(obj!=null && obj instanceof SimpleUsers){
			users	= (SimpleUsers) obj;
			sb.append("login success \n");
			System.out.println(sb.toString());
		}else{
			sb.append("login failure \n");
		}
		
		System.out.println(sb.toString());
		return users;
	}
	
	@Override
	public <T extends IDValuePair> T readCompany(Class clas, String userId) {
		// TODO Auto-generated method stub
		String signature = "SimpleUsersDAO.list(Class)";
		 System.out.println("reading with id : " + userId );
		T found;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(clas);

		String l = new String(userId);
		String stringId = new String(userId);
		c.add(Restrictions.eq("userId",stringId));
		found = (T) c.uniqueResult();
		
		return found;
	}
	
	public <T extends IDValuePair> List<T> list(T t , long id){//, int page, int maxResults) {
		// TODO Auto-generated method stub
		List<T> l = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			Criteria c = session.createCriteria(t.getClass());
			Example e = Example.create(t);
			e.enableLike(MatchMode.ANYWHERE);
			e.excludeZeroes();
			e.ignoreCase();
			c.add(Restrictions.like("id", id));
			c.add(e);
			//c.setFirstResult((page-1)*maxResults);
			//c.setMaxResults(maxResults);
			c.addOrder(Order.desc("id"));
			l = (List<T>)c.list();
		}catch(Exception e){
			System.out.println("SimpleUsersDAO.list(Class, id).exception : ");
			e.printStackTrace();
		}
		return l;
		
	}

}
