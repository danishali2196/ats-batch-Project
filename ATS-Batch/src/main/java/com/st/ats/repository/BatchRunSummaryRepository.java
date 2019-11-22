package com.st.ats.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.ats.entity.BatchRunSummaryEntity;

@Repository
public interface BatchRunSummaryRepository extends JpaRepository<BatchRunSummaryEntity, Serializable> {

}
