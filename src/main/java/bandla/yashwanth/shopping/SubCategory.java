package bandla.yashwanth.shopping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SubCategory {
	@Id
	private int idSubCategory;
	private String name;
	public int getIdSubCategory() {
		return idSubCategory;
	}
	public void setIdSubCategory(int idSubCategory) {
		this.idSubCategory = idSubCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SubCategory [idSubCategory=" + idSubCategory + ", name=" + name + "]";
	}
	public SubCategory(int idSubCategory, String name) {
		super();
		this.idSubCategory = idSubCategory;
		this.name = name;
	}
	public SubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
}
