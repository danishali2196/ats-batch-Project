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
@Table(name="ats_batch_run_dtle")
public class BatchRunDetailsEntity {

	@Id
	@SequenceGenerator(name="runIdSeq",sequenceName="run_id_seq", initialValue=1)
	@GeneratedValue(generator="runIdSeq",strategy=GenerationType.AUTO)
	@Column(name="run_id")
	private Integer runId;
	@Column(name="batch_name")
	private String batchName;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="run_status")
	private String runStatus;
	@Column(name="end_date")
	private Date endDate;
	
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
