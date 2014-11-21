/**
 * 
 */
package users;

public class SimpleUsersPrivilege implements UsersPrivilege{

	private long id;
	private String propertyValue;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	
}
