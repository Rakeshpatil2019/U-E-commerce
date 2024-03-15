package com.example.demo3.service;

import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo3.entity.Category;
import com.example.demo3.payload.CategoryDto;
import com.example.demo3.repository.CategoryRepository;
@Service
public class CategotyService {
    
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public CategoryDto create(CategoryDto dto)
	{
		//CateoryDto to Category
	    Category cat=this.mapper.map(dto,Category.class);
        
	   Category save =this.categoryRepository.save(cat);
	    
	   
		return this.mapper.map(save, CategoryDto.class);
	}
	
	
	public CategoryDto update(CategoryDto newcat,int cid)
	{
		Category oldcat=this.categoryRepository.findById(cid);
		oldcat.setTitle(newcat.getTitle());
		Category save=this.categoryRepository.save(oldcat);
		return this.mapper.map(save, CategoryDto.class);
	}
	
	
	public void delete(int cid)
	{
		Category cat=this.categoryRepository.findById(cid);
		this.categoryRepository.delete(cat);
		
		
	}
	
	
	public CategoryDto getbyI(int cid)
	{
		
		Category getByid=this.categoryRepository.findById(cid);
		
		return this.mapper.map(getByid, CategoryDto.class);
	}
	
	
	public List<CategoryDto> getAll()
	{
		
		
		List<Category> findAll=this.categoryRepository.findAll();
		
		List<CategoryDto> allDto=findAll.stream().map(cat->this.mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return allDto;
	}
	
	
	
	
}
