package com.itbulls.learnit.onlinestore.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itbulls.learnit.onlinestore.persistence.entities.Product;


@Repository
public interface SpringDataJpaProductRepo extends CrudRepository<Product, Integer>
{
	List<Product> findAll();
	
	List<Product> findByNameLike(String name);
	
	@Query("SELECT p FROM product p WHERE p.category.id = :categoryId")
	List<Product> findByCategoryId(Integer categoryId);
	
	@Query("SELECT p FROM product p WHERE p.category.id = :categoryId LIMIT :paginationLimit OFFSET :page")
	List<Product> findByCategoryIdPaginationLimit(Integer categoryId, Integer page, Integer paginationLimit);

	@Query("SELECT COUNT(p) FROM product p WHERE p.category.id = :categoryId")
	Integer countForCategory(Integer categoryId);

	
	@Query(value = "SELECT COUNT(*) FROM product WHERE UPPER(product_name) LIKE UPPER(CONCAT('%',:searchQuery,'%'))", nativeQuery = true  )
	Integer getProductCountForSearch(String searchQuery);
	
	@Query(value = "SELECT p.id, p.guid, p.product_name, p.description, p.price, p.category_id, p.img_name, c.id as cat_id, c.category_name, c.img_name as cat_img "
							+ "FROM learn_it_db.product p JOIN category c ON p.category_id = c.id "
							+ "WHERE UPPER(product_name) LIKE UPPER(CONCAT('%',:searchQuery,'%')) LIMIT :offset, :limit", nativeQuery = true)
	 List<Product> getProductsLikeNameForPageWithLimit(String searchQuery, Integer offset, Integer limit);
	
	Product findByGuid(String guid);
}
