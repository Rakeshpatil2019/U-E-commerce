package com.example.demo3.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo3.entity.Product;
import com.example.demo3.payload.ProductDto;
import com.example.demo3.payload.ProductResponse;
import com.example.demo3.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public ProductDto createProduct(ProductDto product)
	{
		//ProductDto to Product
		Product entity=toEntity(product);
		
		Product save=productRepository.save(entity);
		
		//Product to ProductDto
		ProductDto dto=toDto(save);
		
		return dto;
	}
	
	
	public ProductResponse viewAll(int pageNumber,int pageSize,String sortBy,String sortDir)
	{
		Sort sort=null;
		if(sortDir.trim().toLowerCase().equals("asc"))
		{
			sort =Sort.by(sortBy).ascending();
     		System.out.println(sort);
		}
		else
		{
			sort=Sort.by(sortBy).descending();
		}
		
		Pageable pageable=PageRequest.of(pageNumber, pageSize,sort);
		 Page<Product> page= this.productRepository.findAll(pageable);
  	     List<Product> pageProduct=page.getContent();
		  List<Product> product=pageProduct.stream().filter(p->p.isLive()).collect(Collectors.toList());
          
		  List<ProductDto> productDto=product.stream().map(p->this.toDto(p)).collect(Collectors.toList());
		  
	
	     	 
		 ProductResponse response=new ProductResponse();
		 response.setContent(productDto);
		 response.setPageNumber(page.getNumber());
		 response.setPageSize(page.getSize());
		 response.setTotalPages(page.getTotalPages());
		 response.setLastPage(page.isLast());
		  
		//ProductDto to Product
//		List<Product> findAll=productRepository.findAll();
//		  List<ProductDto> findAllDtos=findAll.stream().map(product->this.toDto(product)).collect(Collectors.toList());
		return response;
	}
	
	
	
//	


	public ProductDto viewProductById(long pid)
	{
	    Product findbyid=productRepository.findById(pid);
	    ProductDto dto=this.toDto(findbyid);
		return dto;
	}
	
	public void deleteProduct(long pid)
	{
		productRepository.deleteById(pid);
		
	}
	
	public ProductDto updateProduct(long pid,ProductDto newproduct)
	{
		Product oldproduct=productRepository.findById(pid);
		
		oldproduct.setPname(newproduct.getPname());
		oldproduct.setPprice(newproduct.getPprice());
		oldproduct.setPquantity(newproduct.getPquantity());
		oldproduct.setCategory(newproduct.getCategory());
	    Product save= productRepository.save(oldproduct);
	    ProductDto dto=toDto(save);
		return dto;
	}
	
	//ProductDto to Product
	public Product toEntity(ProductDto pDto)
	{
		
		Product p=new Product();
		p.setPid(pDto.getPid());
		p.setPname(pDto.getPname());
		p.setPprice(pDto.getPprice());
		p.setPquantity(pDto.getPquantity());
		p.setCategory(pDto.getCategory());
		
		return p;
		
		
	}
	
	//Product to ProductDTO
	
	
	public ProductDto toDto(Product product)
	{
		ProductDto pDTO=new ProductDto();
		
		pDTO.setPid(product.getPid());
		pDTO.setPname(product.getPname());
		pDTO.setPprice(product.getPprice());
		pDTO.setPquantity(product.getPquantity());
		pDTO.setCategory(product.getCategory());
		
		return pDTO;
		
		
		
		
		
	}
	
	
}
