import java.util.HashMap;


public class StaffDatabase {
	
		private HashMap <String, StaffMember> staffDatabase;
		
		public StaffDatabase(){
			staffDatabase = new HashMap<String, StaffMember>();
			testStaff();
		}
		
		public void addStaff(StaffMember staff){
			String idNo = staff.getStaffIdNo();
			staffDatabase.put(idNo, staff);
		}
		
		public void removeStaff(String staffIdNo){
			staffDatabase.remove(staffIdNo);
		}
		
		public StaffMember getStaff(String staffIdNo){
			StaffMember staff1 = staffDatabase.get(staffIdNo);
			return staff1;
		}
		
		public void listAllStaff(){
			for (String staff: staffDatabase.keySet()){

	            String value = staffDatabase.get(staff).toString();  
	            System.out.println(value);  
	        } 
		}
		
		public void testStaff(){
			Managment m1 = new Managment("112233", "Manager", "1234");
			StaffMember s1 = new StaffMember("111111", "Staff1", "5678");
			StaffMember s2 = new StaffMember("222222", "Staff1", "5678");
			
			addStaff(m1);
			addStaff(s1);
			addStaff(s2);
		}
		
		public int databaseSize(){
			return staffDatabase.size();
		}
}
