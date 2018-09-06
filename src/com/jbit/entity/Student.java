package com.jbit.entity;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Student {

	private Integer id;
	@NotEmpty(message="用户名必填.")
	private String name;
	@Length(max=16,min=6,message="密码必须在{2}-{1}之间.")
	@NotEmpty(message="密码必填.")
	private String password;
	@NotEmpty(message="邮箱必填.")
	@Pattern(regexp="([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})",message="邮箱不合法")
	private String email;
	@NotNull(message="出生日期必填.")
	@Past(message="日期必须是过去日期")
	//@DateTimeFormat(pattern="yyyy-MM-dd") //form -- > controller
	private Date birthday;
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password="
				+ password + ", email=" + email + ", birthday=" + birthday
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
