package bandla.yashwanth.shopping.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bandla.yashwanth.shopping.ResultObject;

@RestController
@CrossOrigin(origins = "*")
public class UserController {


	@Autowired
	private DoSignUp doSignUp;

	@Autowired
	private GetUser getUser;

	@Autowired
	private UpdateUser updateUser;

	@Autowired
	private CheckLogin checkLogin;

	@GetMapping("/")
	public String homepage() {
		return "Hello from home page";
	}

	@PostMapping("/home")
	public String homepagepost() {
		return "Hello from home page post";
	}

	@PostMapping("/login")
	public ResponseEntity<UserInfo> userlogin(@RequestBody UserInfo user) {

		UserInfo inputUser;
		inputUser = checkLogin.checkLogin(user);

		if (inputUser.getName() != null) {
			return new ResponseEntity<>(inputUser, HttpStatus.OK);
		} else {
			ResultObject failureResultObject = new ResultObject();
			failureResultObject.setResult("failure");
			return new ResponseEntity<>(inputUser, HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<ResultObject> SignUp(@RequestBody UserInfo user) {
//		ResponseEntity<String>

		doSignUp.signUp(user);
//		DoSignUp.doSignUp(user,userInfoRepository,addressRepository, passwordEncoder, cartRepository, ordersRepository);
		ResultObject successResultObject = new ResultObject();
		successResultObject.setResult("successfully signed up!");
		return new ResponseEntity<>(successResultObject, HttpStatus.OK);

	}

	@PostMapping("/logout")
	public ResponseEntity<ResultObject> LogOut(@RequestBody UserInfo user) {
		ResultObject successResultObject = new ResultObject();
		successResultObject.setResult("success");
		return new ResponseEntity<>(successResultObject, HttpStatus.OK);
	}

	@GetMapping("/getProfile/{userId}")
	public ResponseEntity<UserInfo> getProfile(@PathVariable("userId") int userId) {
		UserInfo returnedUser = getUser.getProfile(userId);
		return new ResponseEntity<>(returnedUser, HttpStatus.OK);

	}

	@PostMapping("/updateProfile")
	public ResponseEntity<ResultObject> updateProfile(@RequestBody UserInfo user) {
		updateUser.updateProfile(user);
		ResultObject successResultObject = new ResultObject();
		successResultObject.setResult("success");
		return new ResponseEntity<>(successResultObject, HttpStatus.OK);

	}
}
