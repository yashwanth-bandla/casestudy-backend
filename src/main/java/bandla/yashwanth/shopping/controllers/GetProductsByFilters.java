package bandla.yashwanth.shopping.controllers;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import bandla.yashwanth.shopping.ProductInfo;
import bandla.yashwanth.shopping.dao.ProductInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class GetProductsByFilters {
	
	
	
	public static List<ProductInfo> getProductsByFilters(String category,String subcategory,ProductInfoRepository productInfoRepository, EntityManager entityManager) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery(); 
		Root<ProductInfo> productInfo = cq.from(ProductInfo.class);
		Predicate categoryPredicate = cb.equal(productInfo.get("category").get("category"), category);
		Predicate subcategoryPredicate = cb.equal(productInfo.get("subCategory").get("name"), subcategory);
		
//		Predicate categoryPredicate = cb.like(productInfo.get("category").get("category"), "%"+category+"%");
//		Predicate subcategoryPredicate = cb.like(productInfo.get("subCategory").get("name"), "%"+subcategory+"%");
		
		
		if(!category.equals("none") && !subcategory.equals("none")) {
			cq.where(categoryPredicate,subcategoryPredicate);
			TypedQuery<ProductInfo> query=entityManager.createQuery(cq);
			return query.getResultList();
		} else if(!category.equals("none") && subcategory.equals("none")) {
			cq.where(categoryPredicate);
			TypedQuery<ProductInfo> query=entityManager.createQuery(cq);
			return query.getResultList();
		} else if(category.equals("none") && !subcategory.equals("none")) {
			cq.where(subcategoryPredicate);
			TypedQuery<ProductInfo> query=entityManager.createQuery(cq);
			return query.getResultList();
		} else {
			return GetAllProducts.getAllProducts(productInfoRepository);
		}


	}
}
