package bandla.yashwanth.shopping;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.context.annotation.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserInfo implements Serializable {

	private String name;
	@Column(unique=true)
	private String email;
	private String password;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private int phone;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@OneToOne
	private Cart cart;
	
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@OneToOne
	private Address address;
	public UserInfo() {
		super();
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
//	@Override
//	public String toString() {
//		return "UserInfo [name=" + name + ", email=" + email  + ", userId=" + userId
//				+ ", phone=" + phone + ", cart=" + cart + ", address=" + address + "]";
//	}
//	public UserInfo(String name, String email, String password, int userId, int phone, Cart cart, Address address) {
//		super();
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.userId = userId;
//		this.phone = phone;
//		this.cart = cart;
//		this.address = address;
//	}
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", email=" + email + ", userId=" + userId + ", phone=" + phone + ", role="
				+ role + ", cart=" + cart + ", address=" + address + "]";
	}
	public UserInfo(String name, String email, String password, int userId, int phone, String role, Cart cart,
			Address address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userId = userId;
		this.phone = phone;
		this.role = role;
		this.cart = cart;
		this.address = address;
	}
	

	
}
