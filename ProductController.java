package com.niit.shopping.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.shopping.model.Product;
import com.niit.shopping.service.ProductService;

@Controller
public class ProductController {

	@Autowired 
	ProductService productService;
	
	/*@Autowired
	Product product;*/
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String productForm(Map<String, Object> map){
		Product product =new Product();
		map.put("product", product);
		map.put("productList",productService.getAllProducts());
		return "product";
	}
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String productbind(@ModelAttribute Product product,BindingResult result,@RequestParam String action,Map<String, Object> map){
		Product productcrud =new Product();
		switch(action){
		
		case "add":
			productService.add(product);
			productcrud=product;
			break;
			
		case "edit":
			productService.edit(product);
			productcrud=product;
			break;
			
		case "delete":
			productService.delete(product.getProduct_id());
			productcrud=new Product();
			break;
			
		case "search":
			Product searchedProduct= productService.getProduct(product.getProduct_id());
			productcrud=searchedProduct!=null ? searchedProduct: new Product() ;
			break;
				}
		map.put("product", productcrud);
		map.put("productList", productService.getAllProducts());
		
				
		return "product";
		
	}
	
}
