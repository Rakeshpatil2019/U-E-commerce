package com.example.demo3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.entity.Product;
import com.example.demo3.payload.AppConstants;
import com.example.demo3.payload.ProductDto;
import com.example.demo3.payload.ProductResponse;
import com.example.demo3.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/create")
	public ProductDto createProuct(@RequestBody ProductDto product)
	{
		//System.out.println(product.getPname());
		ProductDto createProduct=productService.createProduct(product);
		return createProduct;
		
	}
	//view Product
	@GetMapping("/View")
	public ProductResponse viewAllProduct(@RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER_STRING,required = false) int pageNumber,
			      @RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE_STRING,required = false)int pageSize,
			      @RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY_STRING,required = false) String sortBy,
			      @RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR_STRING,required = false)String sortDir)
	{
		 ProductResponse viewAll=productService.viewAll(pageNumber, pageSize, sortBy, sortDir);
		 
		 return viewAll;
	}
	
		//view ProductBy id
	@GetMapping("view/{pid}")
	public ProductDto  viewProuctById(@PathVariable long pid )
	{
		ProductDto viewProuctById = productService.viewProductById(pid);
		return viewProuctById;
	}
	
	//delete Product
	@DeleteMapping("del/{pid}")
	public void deleteProduct(@PathVariable long pid)
	{
		productService.deleteProduct(pid);
	}
	
	//update product
	
	@PutMapping("/update/{pid}")
	public ProductDto updateProduct(@PathVariable long pid, @ RequestBody ProductDto newproduct)
	{
	ProductDto updateProduct=productService.updateProduct(pid,newproduct);
	
	return updateProduct;
		
		
		
	
	}
	
	
	
	
}
