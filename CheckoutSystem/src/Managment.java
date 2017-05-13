
public class Managment extends StaffMember {
	
	public Managment(String staffIdNo, String staffName, String staffPassword) {
		super(staffIdNo, staffName, staffPassword);
		setManagementAccess(true);
	}

}
