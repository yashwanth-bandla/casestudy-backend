package bandla.yashwanth.shopping.helper;

public class JwtResponse {
	String token;
	int id;

	public JwtResponse() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JwtResponse(String token, int id) {
		super();
		this.token = token;
		this.id = id;
	}


}
