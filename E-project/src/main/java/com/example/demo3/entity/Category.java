package com.example.demo3.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="Category")
public class Category {
  
      @Id
      @GeneratedValue(strategy=GenerationType.AUTO)
      @Column
	private int cid;
	@Column
	private String title;

	//mapping
	@OneToMany(mappedBy ="category",fetch = FetchType.LAZY,cascade = CascadeType.ALL )
	private Set<Product> product;
	
	
	
	
	public Category() {
		super();
	}

	public Category(int cid, String title) {
		super();
		this.cid = cid;
		this.title = title;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public Set<Product>getProduct(Set<Product> product)
	{
		return product;
		
	}
	public void setProduct(Set<Product> product)
	{
		this.product=product;
	}
	
	
	
	
}
