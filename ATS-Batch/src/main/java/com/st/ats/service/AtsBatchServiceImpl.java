package com.st.ats.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.st.ats.entity.TagDetailsEntity;
import com.st.ats.entity.TagTxTriggerEntity;
import com.st.ats.entity.UserDetailsEntity;
import com.st.ats.repository.TagDetailsRepository;
import com.st.ats.repository.TagTxTriggerRepository;
import com.st.ats.repository.UserDetailsRepository;

public class AtsBatchServiceImpl implements AtsBatchService {

	@Autowired
	TagTxTriggerRepository txRepo;
	
	@Autowired
	TagDetailsRepository tagRepo;
	
	@Autowired
	UserDetailsRepository userRepo;
	
	@Autowired
	JavaMailSender sender;

	@Override
	public List<TagTxTriggerEntity> searchPedingRecord(String status, String reason, Date date) {
		List<TagTxTriggerEntity> pendingRecords = txRepo.findPendingRecords(status, reason, date);
		return pendingRecords;
	}

	@Override
	public TagDetailsEntity getTagDetailById(Integer tagId) {
		TagDetailsEntity tagEntity = tagRepo.findTagDetailById(tagId);
		return tagEntity;
	}

	@Override
	public UserDetailsEntity getUserById(Integer userId) {
		Optional<UserDetailsEntity> optional = userRepo.findById(userId);
		UserDetailsEntity userEntity = optional.get();
		return userEntity;
	}

	@Override
	public void sendMail(String email) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		//logic
		
	}

	@Override
	public void sentMessage(Long phno) {
		// TODO Auto-generated method stub
		//logic
	}
	

}
