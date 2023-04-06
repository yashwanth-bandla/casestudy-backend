package bandla.yashwanth.shopping.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.ProductInfo;
import bandla.yashwanth.shopping.dao.ProductInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
@Service
public class GetProductsByFilters {

	public static List<ProductInfo> getProductsByFilters(String category, String subcategory,
			ProductInfoRepository productInfoRepository, EntityManager entityManager) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductInfo> cq = cb.createQuery(ProductInfo.class);
		Root<ProductInfo> productInfo = cq.from(ProductInfo.class);
		
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(!category.equals("none")) {
			predicates.add(cb.equal(productInfo.get("category").get("category"), category));
		}
		if(!subcategory.equals("none")) {
			predicates.add(cb.equal(productInfo.get("subCategory").get("name"), subcategory));
		}
		

		if(predicates.isEmpty()) {
			return GetAllProducts.getAllProducts(productInfoRepository);
		} else {
			cq.select(productInfo).where(predicates.toArray(new Predicate[]{}));
			TypedQuery<ProductInfo> query = entityManager.createQuery(cq);
			return query.getResultList();
			
		}
			
		//OLD CODE:-
		
		
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery cq = cb.createQuery(); 
//		Root<ProductInfo> productInfo = cq.from(ProductInfo.class);
//		Predicate categoryPredicate = cb.equal(productInfo.get("category").get("category"), category);
//		Predicate subcategoryPredicate = cb.equal(productInfo.get("subCategory").get("name"), subcategory);

//		if(!category.equals("none") && !subcategory.equals("none")) {
//			cq.where(categoryPredicate,subcategoryPredicate);
//			TypedQuery<ProductInfo> query=entityManager.createQuery(cq);
//			return query.getResultList();
//		} else if(!category.equals("none") && subcategory.equals("none")) {
//			cq.where(categoryPredicate);
//			TypedQuery<ProductInfo> query=entityManager.createQuery(cq);
//			return query.getResultList();
//		} else if(category.equals("none") && !subcategory.equals("none")) {
//			cq.where(subcategoryPredicate);
//			TypedQuery<ProductInfo> query=entityManager.createQuery(cq);
//			return query.getResultList();
//		} else {
//			return GetAllProducts.getAllProducts(productInfoRepository);
//		}

	}
}
