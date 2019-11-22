package com.st.ats.batch;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public interface LowBalReminder {

	public void preProcess();
	public void start(String status,String failureRsn,Date date);
	public void process(String email,Long phno);
	public void postProcess();
}
