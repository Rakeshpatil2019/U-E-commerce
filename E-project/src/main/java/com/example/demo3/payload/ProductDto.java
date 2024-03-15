package com.example.demo3.payload;

import com.example.demo3.entity.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ProductDto {

	
private long pid;

private String pname;
private int pprice;

private int pquantity;
private Category category;


public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public ProductDto() {
	super();
	// TODO Auto-generated constructor stub
}

public ProductDto(long pid, String pname, int pprice, int pquantity) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.pprice = pprice;
	this.pquantity = pquantity;
}

public long getPid() {
	return pid;
}

public void setPid(long pid) {
	this.pid = pid;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}

public int getPprice() {
	return pprice;
}

public void setPprice(int pprice) {
	this.pprice = pprice;
}

public int getPquantity() {
	return pquantity;
}

public void setPquantity(int pquantity) {
	this.pquantity = pquantity;
}
	
	
	
}
