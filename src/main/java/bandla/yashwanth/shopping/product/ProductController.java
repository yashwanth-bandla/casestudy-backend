package bandla.yashwanth.shopping.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
import bandla.yashwanth.shopping.orders.OrdersRepository;
import bandla.yashwanth.shopping.user.AddressRepository;
import bandla.yashwanth.shopping.user.DoSignUp;
import bandla.yashwanth.shopping.user.GetUser;
import bandla.yashwanth.shopping.user.UpdateUser;
import bandla.yashwanth.shopping.user.UserInfoRepository;
import jakarta.persistence.EntityManager;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

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
	private DoGetCategoryAndSubcategoryNames doGetCategoryAndSubcategoryNames;

	@PreAuthorize("hasRole('admin')")
	@PostMapping("/products/addProduct")
	public ProductInfo addproduct(@RequestBody ProductInfo addedproduct) {
		doAddProduct.addProduct(addedproduct);
		return addedproduct;
	}

	@PreAuthorize("hasRole('admin')")
	@PostMapping("/products/update")
	public ProductInfo updateproduct(@RequestBody ProductInfo updatedproduct) {
		doUpdateProduct.updateProduct(updatedproduct);
		return updatedproduct;
	}

	@GetMapping("/products/getById/{productId}")
	public ProductInfo requestProduct(@PathVariable("productId") int productId) {
		return doGetProduct.getProduct(productId);
	}

	@GetMapping("/products/getAllProducts")
	public List<ProductInfo> RequestAllProducts() {
		return doGetAllProducts.getAllProducts();
//		return requestedProduct;
	}

	@GetMapping("/products/{category}")
	public List<ProductInfo> productsByCategory(@PathVariable("category") int categoryid) {
		return doGetProductsByCategory.getProductsByCategory(categoryid);
	}

	@GetMapping("/products/filter/{category}/{subcategory}")
	public List<ProductInfo> productsByFilters(@PathVariable("category") String category,
			@PathVariable("subcategory") String subcategory) {
		return doGetProductsByFilters.getProductsByFilters(category, subcategory);
	}

//	@PreAuthorize("hasRole('admin')")
	@GetMapping("/products/search/{searchString}")
	public List<ProductInfo> productsBySearchString(@PathVariable("searchString") String searchString) {
		return doGetProductsBySearch.getProductsBySearch(searchString);
	}

	@GetMapping("/products/getCategoryAndSubcategories")
	public List<List<String>> getCategoriesAndSubcategoriesLists() {
		return doGetCategoryAndSubcategoryNames.getCategoryAndSubcategoryNames();
	}
}
