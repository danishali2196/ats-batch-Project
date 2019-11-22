package com.st.ats.command;

import lombok.Data;

@Data
public class TagTxDetailsCommand {
	
	private Integer tagId;
	private String vhclRegNo;
	private Integer tollPlazaId;
	private Float tollAmt;
	private String txStatus;
	private String txFailureRsn;
	private String reminderMsgSt;
	

}
