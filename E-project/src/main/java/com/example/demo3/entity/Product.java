package com.example.demo3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Productdetails")
public class Product {

	@Id
private long pid;
@Column
private String pname;
@Column
private int pprice;
@Column
private int pquantity;


//mapping
@ManyToOne(fetch=FetchType.EAGER)
private Category category;


public Category getCategory() {
	return category;
}


public void setCategory(Category category) {
	this.category = category;
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


public Product(long pid, String pname, int pprice, int pquantity) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.pprice = pprice;
	this.pquantity = pquantity;
}


public Product() {
	super();
}


public boolean isLive() {
	// TODO Auto-generated method stub
	if(true)
	return true;
	else
	return false;
}






	
	
	
	

}
