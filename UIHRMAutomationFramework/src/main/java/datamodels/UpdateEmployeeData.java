package datamodels;

public class UpdateEmployeeData
{
	private String Username;
    private String Password;
    private String EmpID;   
    private String FirstName;
    private String LastName;
    private String UpdateEmpId;
    private String Job;
    
    public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public String getUpdateEmpId() {
		return UpdateEmpId;
	}
	public void setUpdateEmpId(String updateEmpId) {
		UpdateEmpId = updateEmpId;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getEmpID() {
		return EmpID;
	}
	public void setEmpID(String empID) {
		EmpID = empID;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
    
}