package product;

import java.util.List;

import abstraction.CRUDable;
import abstraction.IDValuePair;

public interface ProductDAO extends CRUDable{
	public <T extends IDValuePair> long  count(T t);
	
	public <T extends IDValuePair> List<T> list(T t , long id);
	public <T extends IDValuePair> List<T> list(T t);
}

