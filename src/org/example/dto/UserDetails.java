package org.example.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails extends AbstractGenericEntity {
	
	@Column(name="USER_NAME", nullable=false)
	private String userName;
	
	@Column(name="JOIN_DATE")
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="DESCRIPTION")
	@Lob
	private String description;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
