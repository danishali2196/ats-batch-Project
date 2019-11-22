package com.st.ats.command;
import java.util.Date;
import lombok.Data;

@Data
public class UserDetails {

	private String fname;
	private String lname;
	private String gender;
	private Date dob;
	private String email;
	private Long phno;
	private String role;
	private String accStatus;
	private String activeSwitch;
}
