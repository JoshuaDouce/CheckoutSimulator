
public class StaffMember {
	
	private String staffIdNo;
	private String staffName;
	private String staffPassword;
	private boolean managementAccess;
	
	public StaffMember(String staffIdNo, String staffName, String staffPassword){
		this.staffIdNo = staffIdNo;
		this.staffName = staffName;
		this.staffPassword = staffPassword;
		setManagementAccess(false);
	}

	public String getStaffIdNo() {
		return staffIdNo;
	}

	public void setStaffIdNo(String staffIdNo) {
		this.staffIdNo = staffIdNo;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPassword() {
		return staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	public boolean isManagementAccess() {
		return managementAccess;
	}

	public void setManagementAccess(boolean managementAccess) {
		this.managementAccess = managementAccess;
	}
	
	public String toString(){
		if(managementAccess = false){
		return "Role: Team member " + "Staff no: " + staffIdNo + "Name: " + staffName;
		}
		else{
		return "Role: Managment " + "Staff no: " + staffIdNo + "Name: " + staffName;
		}	
	}

}
