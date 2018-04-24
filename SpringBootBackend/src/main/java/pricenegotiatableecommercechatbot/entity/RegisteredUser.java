package pricenegotiatableecommercechatbot.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.json.simple.JSONObject;

@Entity
public class RegisteredUser implements Serializable {
	private static final long serialVersionUID = 2714940250492913562L;

	private String contactNumber;

	private String email;

	private String userName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private JSONObject interests;

	private String name;
	
	private String address;

	private String password;

	public RegisteredUser() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public RegisteredUser(String contactNumber, String email, String userName, Integer id, JSONObject interests,
			String name, String address, String password) {
		super();
		this.contactNumber = contactNumber;
		this.email = email;
		this.userName = userName;
		this.id = id;
		this.interests = interests;
		this.name = name;
		this.address = address;
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public Integer getId() {
		return id;
	}

	public JSONObject getInterests() {
		return interests;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInterests(JSONObject interests) {
		this.interests = interests;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
