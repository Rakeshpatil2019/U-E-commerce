package com.example.demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.payload.ApiResponse;
import com.example.demo3.payload.CategoryDto;
import com.example.demo3.service.CategotyService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategotyService categotyService;
	
	//create Cateory
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto)
	{
	CategoryDto create	=this.categotyService.create(categoryDto);
		
		return new ResponseEntity<CategoryDto>(create,HttpStatus.CREATED);
	}
	
	//update Category
	@PutMapping("/update/{cid}")
	
	public ResponseEntity<CategoryDto>update(@RequestBody CategoryDto categoryDto,@PathVariable int cid)
	{
		CategoryDto update=this.categotyService.update(categoryDto,cid);
		return new ResponseEntity<CategoryDto>(update,HttpStatus.OK);
	}
	
	//delete Category 
	
	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<ApiResponse>delete(@PathVariable int cid)
	{
		this.categotyService.delete(cid);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category delete Successfully",true),HttpStatus.OK);
	}
	
	//getCategoryByID
	@GetMapping("/getByid/{cid}")
	public ResponseEntity<CategoryDto>getByid(@PathVariable int cid)
	{
		CategoryDto getbyId=this.categotyService.getbyI(cid);
		return new ResponseEntity<CategoryDto>(getbyId,HttpStatus.OK);
	}
	
	//Get All Category
	@GetMapping("/getAll")
	public ResponseEntity<List<CategoryDto>>getAll()
	{
		List<CategoryDto>all=this.categotyService.getAll();
		
		return new ResponseEntity<List<CategoryDto>>(all,HttpStatus.OK);
	}
	
	
	
	
	
}
