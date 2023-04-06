package bandla.yashwanth.shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bandla.yashwanth.shopping.Cart;
import bandla.yashwanth.shopping.CartItem;
import bandla.yashwanth.shopping.Orders;
import bandla.yashwanth.shopping.ProductInfo;
import bandla.yashwanth.shopping.ResultObject;
import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.AddressRepository;
import bandla.yashwanth.shopping.dao.CartItemRepository;
import bandla.yashwanth.shopping.dao.CartRepository;
import bandla.yashwanth.shopping.dao.CategoryRepository;
import bandla.yashwanth.shopping.dao.OrderItemRepository;
import bandla.yashwanth.shopping.dao.OrdersRepository;
import bandla.yashwanth.shopping.dao.ProductInfoRepository;
import bandla.yashwanth.shopping.dao.SubCategoryRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;
import jakarta.persistence.EntityManager;

@RestController
@CrossOrigin(origins = "*")
public class MainController {
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ProductInfoRepository productInfoRepository;
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired 
	private EntityManager entityManager;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/login")
	public ResponseEntity<UserInfo> userlogin(@RequestBody UserInfo user, UserInfoRepository userInfoRepository) {
		
		userInfoRepository = this.userInfoRepository;
		UserInfo inputUser;
		inputUser = CheckLogin.checkLogin(user, userInfoRepository);
	
		if(inputUser.getName()!=null) {
//			ResultObject successResultObject = new ResultObject();
//			successResultObject.setResult("success");
//			return new ResponseEntity<>(successResultObject, HttpStatus.OK);
			return new ResponseEntity<>(inputUser, HttpStatus.OK);
		} else {
			ResultObject failureResultObject = new ResultObject();
			failureResultObject.setResult("failure");
			return new ResponseEntity<>(inputUser, HttpStatus.UNAUTHORIZED);
		}

	}
	
	@GetMapping("/")
	public String homepage() {
		return "Hello from home page";
	}
	
	@PostMapping("/home")
	public String homepagepost() {
		return "Hello from home page post";
	}
	
	@PostMapping("/signup")
	public ResponseEntity<ResultObject> SignUp(@RequestBody UserInfo user) {
//		ResponseEntity<String>

		DoSignUp.doSignUp(user,userInfoRepository,addressRepository, passwordEncoder);
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
		UserInfo returnedUser=  GetUser.getUser(userId,userInfoRepository);
		return new ResponseEntity<>(returnedUser, HttpStatus.OK);
		
	}
	
	@PostMapping("/updateProfile")
	public ResponseEntity<ResultObject> updateProfile(@RequestBody UserInfo user) {
		UpdateUser.updateUser(user, userInfoRepository);
		ResultObject successResultObject = new ResultObject();
		successResultObject.setResult("success");
		return new ResponseEntity<>(successResultObject, HttpStatus.OK);
		
		
	}
	
	@PreAuthorize("hasRole('admin')")
	@PostMapping("/products/addProduct")
	public ProductInfo addproduct(@RequestBody ProductInfo addedproduct) {
		AddProduct.addProduct(addedproduct, productInfoRepository, categoryRepository, subCategoryRepository);
		return addedproduct;
	}
	
	@PreAuthorize("hasRole('admin')")
	@PostMapping("/products/update")
	public ProductInfo updateproduct(@RequestBody ProductInfo updatedproduct) {
		UpdateProduct.updateProduct(updatedproduct, productInfoRepository);
		return updatedproduct;
	}
	
	@GetMapping("/products/getById/{productId}")
	public ProductInfo requestProduct(@PathVariable("productId") int productId) {
		return GetProduct.getProduct(productId);
//		return requestedProduct;
	}
	
	@GetMapping("/products/getAllProducts")
	public List<ProductInfo> RequestAllProducts() {
		return GetAllProducts.getAllProducts(productInfoRepository);
//		return requestedProduct;
	}
	
//	@PreAuthorize("hasRole('normal')")
	@GetMapping("/products/{category}")
	public List<ProductInfo> productsByCategory(@PathVariable("category") int categoryid){
		return GetProductsByCategory.getProductsByCategory(categoryid, productInfoRepository);
	}
	
	@GetMapping("/products/filter/{category}/{subcategory}")
	public List<ProductInfo> productsByFilters(@PathVariable("category") String category, @PathVariable("subcategory") String subcategory){
		 return GetProductsByFilters.getProductsByFilters(category,subcategory, productInfoRepository, entityManager);
	}
	
//	@PreAuthorize("hasRole('admin')")
	@GetMapping("/products/search/{searchString}")
	public List<ProductInfo> productsBySearchString(@PathVariable("searchString") String searchString){
		return GetProductsBySearch.getProductsBySearch(searchString,productInfoRepository);
	}

	@GetMapping("/cart/{userId}/getCart")
	public Cart getCart(@PathVariable("userId") int userId) {
		return DoGetCart.doGetCart(userId, userInfoRepository);
	}
	
	@GetMapping("/cart/{userId}/getCartItem/{cartitemId}")
	public CartItem getCartItem(@PathVariable("userId") int userId, @PathVariable("cartitemId") int cartitemId) {
		return DoGetCartItem.doGetCartItem(userId, cartitemId, userInfoRepository,cartItemRepository);
	}
	
	@GetMapping("/order/{userId}/createOrder")
	public Orders createOrder(@PathVariable("userId") int userId) {
		return DoCreateOrder.doCreateOrder(userId, userInfoRepository, cartRepository, ordersRepository, orderItemRepository);
	}
	
	@GetMapping("/order/{userId}/getOrders")
	public Orders getOrders(@PathVariable("userId") int userId) {
		return DoGetOrders.doGetOrders(userId, userInfoRepository, cartRepository, ordersRepository, orderItemRepository);
	}
	

	@GetMapping("/cart/{userId}/add/{productId}")
	public CartItem addToCart(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
		return DoAddToCart.doAddToCart(userId,productId,userInfoRepository,productInfoRepository, cartItemRepository, cartRepository);
	}
	
	@GetMapping("/cart/{userId}/remove/{productId}")
	public void removeFromCart(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
		DoRemoveFromCart.doRemoveFromCart(userId,productId,userInfoRepository,productInfoRepository, cartItemRepository, cartRepository);
	}
	
	@GetMapping("/cart/{userId}/reduceQuantity/{productId}")
	public CartItem reduceQuantity(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
		return DoReduceQuantity.doReduceQuantity(userId,productId, userInfoRepository);
	}
	
	
	
	
}
