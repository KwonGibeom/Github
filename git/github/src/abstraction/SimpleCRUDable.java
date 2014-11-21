/**
 * 
 */
package abstraction;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * @author KwonGibeom/권기범
 * @date 2014. 11. 21.
 * @description
 * TODO TODO
 */
public abstract class SimpleCRUDable implements CRUDable{

	protected SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(session==null){
			session = sessionFactory.openSession();
		} 
		return session;
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
		String signature = "SimplePropertiesDAO.list(Class)";
		 System.out.println("reading with id : " + id );
		T found;
		Session session = getCurrentSession();
		Criteria c = session.createCriteria(clas);
		Long l = new Long(id);
		long intId = l.intValue();
		c.add(Restrictions.eq("id",intId));
		found = (T) c.uniqueResult();
		
		return found;
	}

	/** (non-Javadoc)
	 * @see properties.PropertiesDAO#list(java.lang.Class)
	 *
	 * @author Adam Hun/
	 * 	 * 2013. 10. 15.
	 * @description 
	 */
	/*public List<IDValuePair> list(Class clas){
		String signature = "SimplePropertiesDAO.list(Class)";
		Class target = null;
		List<IDValuePair> l = null;
		System.out.println(signature + " for class : " + clas.getName());
		for( Property p : Property.values()){
			p.name().equalsIgnoreCase(clas.getName());
			target = clas;
		}
		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(target);
		l = (List<IDValuePair>)c.list();
		if(l!=null && l.size()>0){
			System.out.println(signature + " list.size() : " + l.size());
		}else{
			System.out.println(signature + " null lis !! ");
		}
		return l;
	}*/
	
	/** (non-Javadoc)
	 * @see properties.PropertiesDAO#getSessionFactory()
	 *
	 * @author Adam Hun/���ѿ�
	 * 2013. 10. 15.
	 * @description 
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/** (non-Javadoc)
	 * @see properties.PropertiesDAO#setSessionFactory(org.hibernate.SessionFactory)
	 *
	 * @author Adam Hun/
	 * 2013. 10. 15.
	 * @description 
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public <T extends IDValuePair> List<T> list(T t, int page, int maxResults) {
		// TODO Auto-generated method stub
		List<T> l = null;
		try{
			System.out.println("SimpleCRUDable.<T extends IDValuePair> List<T> list(T t, int page, int maxResults)");
			Session session = getCurrentSession();
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
			System.out.println("SimplePropertiesDAO.list(Class, page, size).exception : ");
			e.printStackTrace();
		}
		return l;
		
	}

	public <T extends IDValuePair> long  count(T t){
		
		long count = 0;
		Session session = getCurrentSession();
		Criteria c = session.createCriteria(t.getClass());
		c.setProjection(Projections.count("id"));
		Example e = Example.create(t);
		e.enableLike(MatchMode.ANYWHERE);
		e.excludeZeroes();
		e.ignoreCase();
		c.add(e);
		if( c.uniqueResult()!=null){
			count = (Long)c.uniqueResult();
		}
		 
		return count;
	}

	public <T> List<T> list(T t, int page, int maxResults) {
		// TODO Auto-generated method stub
		List<T> l = null;
		try{
			System.out.println("SimpleCRUDable.<T> List<T> list(T t, int page, int maxResults)");
			Session session = getCurrentSession();
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
			System.out.println("SimplePropertiesDAO.list(Class, page, size).exception : ");
			e.printStackTrace();
		}
		return l;
		
	}
	
	public <T> T create(T t) {
		// TODO Auto-generated method stub
		System.out.println("abstraction.SimpleCrudable.create(T t)");
		Session session = sessionFactory.getCurrentSession();
		Serializable s = session.save(t);
		t = (T) session.load(t.getClass(), s);
		if(t==null){
			System.out.println("abstraction.SimpleCrudable.create(T t). loaded a null t");
		}
		return t;
	}
	
}
