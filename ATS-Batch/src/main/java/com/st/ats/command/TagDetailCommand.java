package com.st.ats.command;

import java.util.Date;

import lombok.Data;

@Data
public class TagDetailCommand {
	
	private String vchlRegNo;
	private String vhclType;
	private Date tagStartDate;
	private Date tagExpDate;
	private Float tagBal;
	private Integer userId;

}
