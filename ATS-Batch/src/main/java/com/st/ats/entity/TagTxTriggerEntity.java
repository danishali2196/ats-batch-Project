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
@Table(name="ats_tag_tx_trigger")
public class TagTxTriggerEntity {

	@Id
	@SequenceGenerator(name="txSeq",sequenceName="tx_seq",initialValue=1)
	@GeneratedValue(generator="txSeq",strategy=GenerationType.AUTO)
	@Column(name="trg_id")
	private Integer trgId;
	
	@Column(name="tag_id")
	private Integer tagId;
	
	@Column(name="vhcl_reg_no")
	private String vhclRegNo;
	
	@Column(name="toll_plaza_id")
	private Integer tollPlazaId;
	
	@Column(name="toll_amt")
	private Float tollAmt;
	
	@Column(name="tx_status")
	private String txStatus;
	
	@Column(name="tx_failure_rsn")
	private String txFailureRsn;
	
	@Column(name="reminder_msg_st")
	private String reminderMsgSt;
	
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
