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

import bandla.yashwanth.shopping.ResultObject;
import bandla.yashwanth.shopping.cart.Cart;
import bandla.yashwanth.shopping.cart.CartItem;
import bandla.yashwanth.shopping.cart.CartItemRepository;
import bandla.yashwanth.shopping.cart.CartRepository;
import bandla.yashwanth.shopping.cart.DoAddToCart;
import bandla.yashwanth.shopping.cart.DoGetCart;
import bandla.yashwanth.shopping.cart.DoGetCartItem;
import bandla.yashwanth.shopping.cart.DoReduceQuantity;
import bandla.yashwanth.shopping.cart.DoRemoveFromCart;
import bandla.yashwanth.shopping.orders.DoCreateOrder;
import bandla.yashwanth.shopping.orders.DoGetOrders;
import bandla.yashwanth.shopping.orders.OrderItemRepository;
import bandla.yashwanth.shopping.orders.Orders;
import bandla.yashwanth.shopping.orders.OrdersRepository;
import bandla.yashwanth.shopping.product.CategoryRepository;
import bandla.yashwanth.shopping.product.DoAddProduct;
import bandla.yashwanth.shopping.product.DoGetAllProducts;
import bandla.yashwanth.shopping.product.DoGetCategoryAndSubcategoryNames;
import bandla.yashwanth.shopping.product.DoGetProduct;
import bandla.yashwanth.shopping.product.DoGetProductsByCategory;
import bandla.yashwanth.shopping.product.DoGetProductsByFilters;
import bandla.yashwanth.shopping.product.DoGetProductsBySearch;
import bandla.yashwanth.shopping.product.DoUpdateProduct;
import bandla.yashwanth.shopping.product.ProductInfo;
import bandla.yashwanth.shopping.product.ProductInfoRepository;
import bandla.yashwanth.shopping.product.SubCategoryRepository;
import bandla.yashwanth.shopping.user.AddressRepository;
import bandla.yashwanth.shopping.user.CheckLogin;
import bandla.yashwanth.shopping.user.DoSignUp;
import bandla.yashwanth.shopping.user.GetUser;
import bandla.yashwanth.shopping.user.UpdateUser;
import bandla.yashwanth.shopping.user.UserInfo;
import bandla.yashwanth.shopping.user.UserInfoRepository;
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
	
	@Autowired
	private DoSignUp doSignUp;
	
	@Autowired
	private GetUser getUser;
	
	@Autowired
	private UpdateUser updateUser;
	
	@Autowired
	private DoAddProduct doAddProduct;
	
	@Autowired
	private DoUpdateProduct doUpdateProduct;
	
	@Autowired
	private DoGetProduct doGetProduct;
	
	@Autowired
	private DoGetAllProducts doGetAllProducts;
	
	@Autowired
	private DoGetProductsByCategory doGetProductsByCategory;
	
	@Autowired
	private DoGetProductsByFilters doGetProductsByFilters;
	
	@Autowired
	private DoGetProductsBySearch doGetProductsBySearch;
	
	@Autowired
	private DoGetCart doGetCart;
	
	@Autowired
	private DoGetCartItem doGetCartItem;
	
	@Autowired
	private DoCreateOrder doCreateOrder;
	
	@Autowired
	private DoGetOrders doGetOrders;
	
	@Autowired
	private DoAddToCart doAddToCart;
	
	@Autowired
	private DoRemoveFromCart doRemoveFromCart;
	
	@Autowired
	private DoReduceQuantity doReduceQuantity;
	
	@Autowired
	private DoGetCategoryAndSubcategoryNames doGetCategoryAndSubcategoryNames;
	
	@Autowired 
	private CheckLogin checkLogin;
	
	

	
}
