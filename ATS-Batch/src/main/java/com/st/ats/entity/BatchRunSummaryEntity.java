package com.st.ats.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="ats_batch_run_summary")
public class BatchRunSummaryEntity {

	@Id
	@SequenceGenerator(name="summaryIdSeq",sequenceName="summary_id_seq", initialValue=1)
	@GeneratedValue(generator="summaryIdSeq",strategy=GenerationType.AUTO)
	@Column(name="summary_id")
	private Integer summaryId;
	
	@Column(name="batch_name")
	private String batchName;
	
	@Column(name="summary_detail")
	private String summaryDetails;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_Date")
	@CreationTimestamp
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_Date")
	@UpdateTimestamp
	private Date updateDate;
	
	@Column(name="created_by")
	private String createdBy;

	@Column(name="updated_by")
	private String updatedBy;
}
