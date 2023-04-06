package bandla.yashwanth.shopping;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserInfo implements Serializable {

	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private int phone;
	private String role;
	@OneToOne
	private Cart cart;
	@OneToOne
	private Orders orders;

	@OneToOne
	private Address address;
	
	public UserInfo(String name, String email, String password, int userId, int phone, String role, Cart cart,
			Orders orders, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userId = userId;
		this.phone = phone;
		this.role = role;
		this.cart = cart;
		this.orders = orders;
		this.address = address;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

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

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", email=" + email + ", password=" + password + ", userId=" + userId
				+ ", phone=" + phone + ", role=" + role + ", cart=" + cart + ", orders=" + orders + ", address="
				+ address + "]";
	}


}
