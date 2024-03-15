package com.example.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo3.entity.Product;
import com.example.demo3.payload.ProductDto;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
//	public Product findByID(long pid);
	
	public Product findById(long id);

}
