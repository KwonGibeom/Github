package product;

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

public class SimpleProductDAO implements ProductDAO {

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
	 * @see product.productDAO#update(abstraction.IDValuePair)
	 *
	 * @author Adam Hun/���ѿ�
	 * 2013. 10. 29.
	 * @description 
	 */
	@Override
	public <T extends IDValuePair> T update(T t) {
		// TODO Auto-generated method stub
		System.out.println("[SimpleproductDAO].update");
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		return t;
	}

	/** (non-Javadoc)
	 * @see product.productDAO#delete(abstraction.IDValuePair)
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
		String signature = "SimpleproductDAO.list(Class)";
		
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
		String signature = "SimpleproductDAO.list(Class)";
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
			System.out.println("SimpleproductDAO.list(Class, page, size).exception : ");
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
			System.out.println("SimpleproductDAO.list(Class, page, size).exception : ");
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
		String signature = "SimpleproductDAO.list(Class)";
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
	 * @see product.productDAO#update(abstraction.IDValuePair)
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
