/**
 * 
 */
package product;

import abstraction.IDValuePair;


public interface Product extends IDValuePair{

	public abstract long getId();
	public abstract void setId(long id);
	
	public abstract String getName();
	public abstract void setName(String name);
	
	public abstract String getCompany();
	public abstract void setCompany(String company);
	
	public abstract int getPrice();
	public abstract void setPrice(int price);
	
}