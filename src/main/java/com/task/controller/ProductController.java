package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.product.Products;
import com.task.service.ProductServiceImp;

@RestController
public class ProductController {
    @Autowired
	private ProductServiceImp serviceImp;
    
    @PostMapping("/save")
    public String save(@RequestBody Products products) {
    	
    Products products2 = serviceImp.saveProducts(products);
    	
    	String status = null;
    	
    	if(products2!=null) {
    		status ="RecordSaved";
    	}
    	else {
    		status = "RecordNotSaved";
    	}
    	return status;
    }
	
    @GetMapping("/getall")
    public List<Products> GetAll() {
		List<Products> get = serviceImp.getAllProducts();
		
		return get;
	}
    
    @DeleteMapping("/delete/{productid}")
    public String delete(@PathVariable int productid) {
		serviceImp.deleteProduct(productid);
		return "["+productid+"]"+"..RecordDeleted" ;
	}
    
    @PutMapping("/update/{productid}")
    public Products update(@RequestBody Products products, @PathVariable int productid) {
    	
    	Products update = serviceImp.updateProducts(products, productid);
		
    	return update;
	}
}
