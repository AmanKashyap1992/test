package test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  
@Entity  
@Table(name= "USER_INFORMATION")   
public class User {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(generator = "increment")
	private int userid;
	@Column(name = "USER_NAME")
	private String uName;
	@Column(name = "USER_EMAIL")
	private String uEmail;
	@Column(name = "PASSWORD")
	private String password;
	
	public int getUserid() {
		return userid;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
