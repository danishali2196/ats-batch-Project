package com.st.ats.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.st.ats.entity.TagDetailsEntity;
import com.st.ats.entity.TagTxTriggerEntity;
import com.st.ats.entity.UserDetailsEntity;

@Service
public interface AtsBatchService {

	public List<TagTxTriggerEntity> searchPedingRecord(String status,String reason,Date date);

	public TagDetailsEntity getTagDetailById(Integer tagId);

	public UserDetailsEntity getUserById(Integer userId);

	public void sendMail(String email);

	public void sentMessage(Long phno);
	
}
