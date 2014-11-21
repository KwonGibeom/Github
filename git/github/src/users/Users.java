/**
 * 
 */
package users;

import users.UsersPrivilege;

import abstraction.IDValuePair;


public interface Users extends IDValuePair{
	
	public abstract long getId();
	public abstract void setId(long id);
	
	public abstract long getCompNo();
	public abstract void setCompNo(long compNo);
	
	public abstract String getUserId();
	public abstract void setUserId(String userId);
	
	public abstract String getUserName();
	public abstract void setUserName(String userName);
	
	public abstract String getTeamCode();
	public abstract void setTeamCode(String teamCode);
	
	public abstract String getUserPass();
	public abstract void setUserPass(String userPass);
	
	public abstract String getAccess();
	public abstract void setAccess(String access);
	
	public abstract String getAddDate();
	public abstract void setAddDate(String addDate);
	
	public abstract String getStopFlag();
	public abstract void setStopFlag(String stopFlag);
	
	public abstract String getStopDate();
	public abstract void setStopDate(String stopDate);
	
	public abstract UsersPrivilege getPrivilege();
	public abstract void setPrivilege(UsersPrivilege newPriv);
	
	public void setPrivilegeId(long newPrivId);
	public long getPrivilegeId();

	
}