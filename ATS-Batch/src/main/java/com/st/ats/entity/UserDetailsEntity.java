package com.st.ats.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="ATS_USER")
public class UserDetailsEntity {
	@Id
	@Column(name="USERID",length=10)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
	@Column(name="fname",length=20)
	private String fname;
	@Column(name="lname",length=20)
	private String lname;
	@Column(name="gender",length=7)
	private String gender;
	@Column(name="dob")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date dob;
	@Column(name="email")
	private String email;
	@Column(name="phno",length=12)
	private Long phno;
	@Column(name="role",length=20)
	private String role;
	@Column(name="accStatus",length=15)
	private String accStatus;
	
	@Column(name="password")
	private String password;
	
	@Column(name="activeSwitch")
	private String activeSwitch;
	
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
