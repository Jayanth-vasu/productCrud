package com.niit.shopping.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopping.dao.ProductDAO;
import com.niit.shopping.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired ProductDAO productDAO;
	
	@Override
	public void add(Product product) {
	      productDAO.add(product);

	}

	@Override
	public void edit(Product product) {
		productDAO.add(product);

	}

	@Override
	public void delete(int product_id) {
		productDAO.delete(product_id);

	}

	@Override
	public Product getProduct(int product_id) {
		
		return productDAO.getProduct(product_id);
	}

	@Override
	public List getAllProducts() {
		
		return productDAO.getAllProducts();
	}

}
