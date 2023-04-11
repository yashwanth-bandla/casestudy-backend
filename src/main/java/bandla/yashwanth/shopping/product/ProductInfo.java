package bandla.yashwanth.shopping.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	private String imgsrc;
	private String details;
	@ManyToOne
	private Category category;
	@ManyToOne
	private SubCategory subCategory;

	public ProductInfo(int id, String name, int price, String imgsrc, String details, Category category,
			SubCategory subCategory) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgsrc = imgsrc;
		this.details = details;
		this.category = category;
		this.subCategory = subCategory;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", name=" + name + ", price=" + price + ", details=" + details + ", category="
				+ category + ", subCategory=" + subCategory + "]";
	}

	public ProductInfo() {
		super();
	}

}
