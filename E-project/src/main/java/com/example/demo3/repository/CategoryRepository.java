package com.example.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo3.entity.Category;
import com.example.demo3.entity.Product;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	public Category findById(int pid);
}
