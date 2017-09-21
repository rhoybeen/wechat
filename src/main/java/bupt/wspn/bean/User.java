package bupt.wspn.bean;

import java.sql.Timestamp;

public class User {
	private int id;
	private String openid;
	private String username;
	private String password;
	private String telephone;
	private String province;
	private String city;
	private String gender;
	private String address;
	private String email;
	private String alipay;
	private String school;
	private int groupid;
	private String network_mnc;
	private Timestamp subtime;
	private Timestamp createTime;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAlipay() {
		return alipay;
	}
	
	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}
	
	public String getSchool() {
		return school;
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOpenid() {
		return openid;
	}
	
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public Timestamp getSubtime() {
		return subtime;
	}
	
	public void setSubtime(Timestamp subtime) {
		this.subtime = subtime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// public int getIsAdmin() {
	// return isAdmin;
	// }
	// public void setIsAdmin(int isAdmin) {
	// this.isAdmin = isAdmin;
	// }
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	
	public int getGroupid() {
		return groupid;
	}

	public String getNetwork_mnc() {
		return network_mnc;
	}

	public void setNetwork_mnc(String network_mnc) {
		this.network_mnc = network_mnc;
	}

}
