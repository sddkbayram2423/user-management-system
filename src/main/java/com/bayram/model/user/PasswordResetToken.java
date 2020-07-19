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
	@NamedQuery(name = "PasswordResetToken.findByToken",query = "FROM PasswordResetToken WHERE token=:token"),
	@NamedQuery(name = "PasswordResetToken.findByUserId",query = "FROM PasswordResetToken WHERE user.id=:id"),
	@NamedQuery(name = "PasswordResetToken.deleteExpireyDateToken",query = "DELETE FROM PasswordResetToken WHERE expiryDate <= :expiryDate"),
	@NamedQuery(name = "PasswordResetToken.findAllExpiredDateLessThan",query = "FROM PasswordResetToken WHERE expiryDate <= :expiryDate"),
})
public class PasswordResetToken implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Transient
	private final int EXPÝRY_DATE=24*60;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String token;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
	
	public PasswordResetToken() {
		this.expiryDate=calculateDate(EXPÝRY_DATE);
	}
	

	public PasswordResetToken(String token, User user) {
		this.token = token;
		this.user = user;
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


	public String getToken() {
		return token;
	}


	public User getUser() {
		return user;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public void setUser(User user) {
		this.user = user;
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
		PasswordResetToken other = (PasswordResetToken) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PasswordResetToken [EXPÝRY_DATE=" + EXPÝRY_DATE + ", id=" + id + ", token=" + token 
				+ ", expiryDate=" + expiryDate + "]";
	}
	
	
	
	

}
