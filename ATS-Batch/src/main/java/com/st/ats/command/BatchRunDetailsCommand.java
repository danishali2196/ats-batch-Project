package com.st.ats.command;

import java.util.Date;

import lombok.Data;

@Data
public class BatchRunDetailsCommand {
	
	private String batchName;
	private Date startDate;
	private String runStatus;
	private Date endDate;
	

	
}
