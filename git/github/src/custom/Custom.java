/**
 * 
 */
package custom;

import abstraction.IDValuePair;


public interface Custom extends IDValuePair{
	
	public abstract long getCustNo();
	public abstract void setCustNo(long custNo);
	
	public abstract String getCustNum();
	public abstract void setCustNum(String custNum);
	
	public abstract String getCustName();
	public abstract void setCustName(String custName);
	
	public abstract String getOwnerName();
	public abstract void setOwnerName(String ownerName);
	
	public abstract String getCustMail();
	public abstract void setCustMail(String custMail);
	
	public abstract String getCustTel();
	public abstract void setCustTel(String custTel);
	
	public abstract String getCustFax();
	public abstract void setCustFax(String custFax);
	
	public abstract String getCustEmp1();
	public abstract void setCustEmp1(String custEmp1);
	
	public abstract String getCustEmp2();
	public abstract void setCustEmp2(String custEmp2);
	
	public abstract String getCustEmp3();
	public abstract void setCustEmp3(String custEmp3);
	
	public abstract String getEmpTel1();
	public abstract void setEmpTel1(String empTel1);
	
	public abstract String getEmpTel2();
	public abstract void setEmpTel2(String empTel2);
	
	public abstract String getEmpTel3();
	public abstract void setEmpTel3(String empTel3);
	
	public abstract String getAddDate();
	public abstract void setAddDate(String addDate);
	
	public abstract String getStopFlag();
	public abstract void setStopFlag(String stopFlag);
	
	public abstract String getStopDate();
	public abstract void setStopDate(String stopDate);
	
}