package com.niit.shopping.dao;

import java.util.List;

import com.niit.shopping.model.Product;

public interface ProductDAO {

	public void add(Product product);
	public void edit(Product product);
	public void delete(int product_id);
	public Product getProduct(int product_id);
	public List getAllProducts();
	
}
