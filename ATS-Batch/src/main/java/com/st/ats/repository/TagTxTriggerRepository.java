package com.st.ats.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.st.ats.entity.TagTxTriggerEntity;

@Repository
public interface TagTxTriggerRepository extends JpaRepository<TagTxTriggerEntity, Serializable> {

	@Query("FROM TagTxTriggerEntity tx WHERE txStatus=:status AND txFailureRsn=:reason AND createDate=:date")
	public List<TagTxTriggerEntity> findPendingRecords(String status,String reason,Date date);
}
