package com.st.ats.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Strategy;

import lombok.Data;

@Data
@Entity
@Table(name="ATS_TAG_DETAILS")
public class TagDetailsEntity {
	@Id
	@SequenceGenerator(name="tagSeq", sequenceName="tag_seq",initialValue=1)
	@GeneratedValue(generator="tagSeq",strategy=GenerationType.AUTO)
	@Column(name="TAG_SEQ")
	private Integer tagSeq;
	
	@Column(name="TAG_ID")
	private Integer tagId;
	
	@Column(name="VHCL_REG_NO")
	private String vchlRegNo;
	
	@Column(name="VHCL_TYPE")
	private String vhclType;
	
	@Column(name="TAG_START_DATE")
	private Date tagStartDate;
	
	@Column(name="TAG_EXP_DATE")
	private Date tagExpDate;
	
	@Column(name="TAG_BAL")
	private float tagBal;
	
	@Column(name="userId")
	private Integer userId;
		
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
