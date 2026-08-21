package constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UIConstants
{
	public static final String LOGIN_PAGE_TITLE = "Login";
	public static final String LOGIN_PAGE_ERROR = "Login page is not displayed.";
	public static final String DASHBOARD_PAGE_TITLE = "Dashboard";
	public static final String LOGIN_PAGE_INVALID_CREDENTIALS = "Invalid credentials";
	public static final String DASHBOARD_PAGE_ERROR = "Dashboard verification failed.";
	public static final String REQUIRED_TEXT = "Required";
	public static final String PIM_PAGE_TITLE = "PIM";
	public static final String PIM_PAGE_ADD_EMPLOYEE_TEXT = "Add Employee";
	public static final String PIM_PAGE_EMPLOYEE_ID_NOT_NULL = "Employee ID should not be null";
	public static final String PIM_PAGE_EMPLOYEE_ID_NOT_EMPTY = "Employee ID should not be empty";
	public static final String PIM_PAGE_EMPLOYEE_ID_ONLY_DIGITS = "Employee ID should contain only digits";
	public static final String PIM_PAGE_EMPLOYEE_ID_ALREADY_EXISTS = "Employee Id already exists";
	public static final String PIM_PAGE_EMPLOYEE_INFO_TITLE = "Employee Information";
	public static final String PIM_PAGE_NO_RECORD_FOUND = "No Record Found";
	public static final String PIM_PAGE_TABLE_HEADERS_INCORRECT = "Table headers are incorrect";
	public static final String PIM_PAGE_TABLE_SHOULD_CONTAIN_RECORDS = "Employee table should contain records.";
	public static final String PIM_PAGE_EMPLOYEE_NAME_NOT_EMPTY = "Employee Name should not be empty.";
	public static final String PIM_PAGE_CURRENT_PAGE_NUMBER = "2";
	public static final List<String> EXPECTED_HEADERS = new ArrayList<>(Arrays.asList("Id",
			"First (& Middle) Name",
		    "Last Name",
		    "Job Title",
		    "Employment Status",
		    "Sub Unit",
		    "Supervisor",
		    "Actions"));
}