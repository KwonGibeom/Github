/**
 * 
 */
package users;

import users.UsersPrivilege;

public class SimpleUsers implements Users {

	private long id;
	private long compNo;
	private String userId;
	private String userName;		
	private String teamCode;
	private String userPass;
	private String access;
	private String addDate;
	private String stopFlag;
	private String stopDate;
	private UsersPrivilege privilege;
	private long privilegeId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCompNo() {
		return compNo;
	}
	public void setCompNo(long compNo) {
		this.compNo = compNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getStopFlag() {
		return stopFlag;
	}
	public void setStopFlag(String stopFlag) {
		this.stopFlag = stopFlag;
	}
	public String getStopDate() {
		return stopDate;
	}
	public void setStopDate(String stopDate) {
		this.stopDate = stopDate;
	}
	public UsersPrivilege getPrivilege() {
		return privilege;
	}
	public void setPrivilege(UsersPrivilege privilege) {
		this.privilege = privilege;
	}
	public long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(long privilegeId) {
		this.privilegeId = privilegeId;
	}
	
	public boolean validate() {
		
		try{
			
			boolean hasAccountName = getUserId()!=null&&!"".equals(getUserId())?true:false;
			/*boolean hasEmailUserName = getEmailUserName()!=null&&!"".equals(getEmailUserName())?true:false;
			boolean hasEmailDomain = getEmailDomain()!=null&&!"".equals(getEmailDomain())?true:false;
			boolean hasOrg = getOrganisation()!=null&&!"".equals(getOrganisation())?true:false;*/
			boolean hasUsersPassword = getUserPass()!=null&&!"".equals(getUserPass())?true:false;
			
			if(hasAccountName 
					/*&& hasEmailUserName
					&& hasEmailDomain
					&& hasOrg*/
					&& hasUsersPassword){
				
			}else{
				
				System.out.println("hasAccountName:" + hasAccountName);
				/*System.out.println("hasEmailUserName:" +hasEmailUserName );
				System.out.println("hasEmailDomain:" + hasEmailDomain);
				System.out.println("hasOrg:" + hasOrg);*/
				System.out.println("hasUsersPassword:" + hasUsersPassword);
				
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return true;
	}
	
}
