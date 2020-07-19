package com.bayram.model.user;

import java.io.Serializable;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@NamedQueries({
	@NamedQuery(name = "VerificicationToken.findByToken",query = "SELECT v FROM VerificicationToken v WHERE v.token=:token"),
	@NamedQuery(name = "VerificicationToken.findByUserId",query ="SELECT v FROM VerificicationToken v WHERE v.user.id=:id"),
	@NamedQuery(name = "VerificicationToken.findAllByExpiredDataLessThan",query = "SELECT v FROM VerificicationToken v WHERE v.expiryDate <= :expiryDate"),
	@NamedQuery(name = "VerificicationToken.deleteAllByExpiredSince",query ="DELETE FROM VerificicationToken v WHERE v.expiryDate >= :expiryDate")
})
public class VerificicationToken implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Transient
	private final int EXPÝRY_DATE=60*24;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column
	private String token;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
	
	
	public VerificicationToken() {
		this.expiryDate=calculateDate(EXPÝRY_DATE);
	}

	public VerificicationToken(User user, String token) {
		this.user = user;
		this.token = token;
		this.expiryDate=calculateDate(EXPÝRY_DATE);
	}


	private Date calculateDate(int expiry_Date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		calendar.add(Calendar.MINUTE, expiry_Date);
		return new Date(calendar.getTime().getTime());
	}

	public long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public String getToken() {
		return token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VerificicationToken other = (VerificicationToken) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificicationToken [EXPÝRY_DATE=" + EXPÝRY_DATE + ", id=" + id + ", user=" + user + ", token=" + token
				+ ", expiryDate=" + expiryDate + "]";
	}
	
	
}
