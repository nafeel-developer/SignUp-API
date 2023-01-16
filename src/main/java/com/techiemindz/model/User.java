package com.techiemindz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
public class User {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;

@Column(name="first_name",nullable=false)
private String firstName;
@Column(name="last_name",nullable=false)
private String lastName;
@Column(name="email_id",nullable=false)
private String emailId;
@Column(name="mobile_number",nullable=false)
private long mobileNumber;

@CreationTimestamp
@Temporal(TemporalType.TIMESTAMP)
@Column(name="created_at",nullable=false)
private Date createdAt;

@UpdateTimestamp
@Temporal(TemporalType.TIMESTAMP)
@Column(name="updated_at",nullable=false)
private Date updatedAt;


@Column(name="created_by",nullable=false)
@CreatedBy
private String createdBy;

@Column(name="updated_by",nullable=false)
@LastModifiedBy
private String updatedBy;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public long getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

public String getUpdatedBy() {
	return updatedBy;
}

public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
}

@Override
public String toString() {
	return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
			+ ", mobileNumber=" + mobileNumber + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
			+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
}

}
