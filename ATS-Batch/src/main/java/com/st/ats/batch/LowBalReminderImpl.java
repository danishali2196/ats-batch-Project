package com.st.ats.batch;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.ats.entity.BatchRunDetailsEntity;
import com.st.ats.entity.BatchRunSummaryEntity;
import com.st.ats.entity.TagDetailsEntity;
import com.st.ats.entity.TagTxTriggerEntity;
import com.st.ats.entity.UserDetailsEntity;
import com.st.ats.repository.BatchRunDetailsRepostory;
import com.st.ats.repository.BatchRunSummaryRepository;
import com.st.ats.service.AtsBatchService;

@Component
public class LowBalReminderImpl implements LowBalReminder {

	@Autowired
	BatchRunDetailsRepostory runRepo;
	
	@Autowired
	BatchRunSummaryRepository summaryRepo;

	@Autowired
	AtsBatchService service;
	
	
	private static final String BATCH_NAME = "reminder batch";
	private static Integer runId = 0;
	private static Integer totalCount = 0;
	private static Integer successCount = 0;
	private static Integer failureCount = 0;
	
	@Override
	public void preProcess() {
		// TODO :: insert record to batch_run_dtle_dtle
		BatchRunDetailsEntity runEntity = new BatchRunDetailsEntity();
		runEntity.setBatchName(BATCH_NAME);
		runEntity.setCreatedBy(BATCH_NAME);
		runEntity.setRunStatus("st");
		runEntity.setStartDate(new Date());

		BatchRunDetailsEntity runDetailsEntity = runRepo.save(runEntity);
		runId = runDetailsEntity.getRunId();
	}

	@Override
	public void start(String status, String failureRsn, java.sql.Date date) {
		// TODO :: retrive the record based on condition
		List<TagTxTriggerEntity> txEntities = service.searchPedingRecord(status, failureRsn, date);
		totalCount = txEntities.size();
		txEntities.forEach(triggerEntity ->{
			Integer tagId=triggerEntity.getTagId();
			TagDetailsEntity tagDetail = service.getTagDetailById(tagId);
			Integer userId = tagDetail.getUserId();
			UserDetailsEntity user = service.getUserById(userId);
			String email = user.getEmail();
			Long phno = user.getPhno();
			process(email, phno);
		});
		
	}

	@Override
	public void process(String email, Long phno) {
		try {
			service.sendMail(email);
			service.sentMessage(phno);
			successCount++;
			postProcess();
		}
		catch (Exception e) {
			e.printStackTrace();
			failureCount++;
		}
	}

	@Override
	public void postProcess() {
		BatchRunSummaryEntity summaryEntity = new BatchRunSummaryEntity();
		summaryEntity.setBatchName(BATCH_NAME);
		summaryEntity.setSummaryDetails("Total Records ::"+totalCount+", Success Records ::"+successCount+", Failure Records::"+failureCount);
		summaryRepo.save(summaryEntity);
		
		BatchRunDetailsEntity runDetailsEntity = new BatchRunDetailsEntity();
		runDetailsEntity.setRunStatus("C");
		runDetailsEntity.setRunId(runId);
		runRepo.save(runDetailsEntity);
		
	}

	

	
	
	

}
