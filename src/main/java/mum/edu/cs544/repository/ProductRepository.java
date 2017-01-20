package mum.edu.cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mum.edu.cs544.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	void delete(int productId);

	List<Product> findAll();

	Product findOne(int productId);

	Product save(Product persisted);
	
//	@Query("select p.name,p.price,p.description,c.categoryName,b.brandName from Product Join Brand b Join Category C")
//	List<Product> findData();

}
