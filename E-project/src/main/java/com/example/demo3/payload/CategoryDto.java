package com.example.demo3.payload;

import java.util.ArrayList;
import java.util.List;

import com.example.demo3.entity.Category;

import jakarta.persistence.Column;


public class CategoryDto {

	private Category category;
	List<CategoryDto> categoryDtos=new ArrayList<>();

	public String getTitle() {
		String title=category.getTitle();
		return title;
	}
	

}
