package com.task.service;

import java.util.List;


import com.task.product.Products;

public interface ProductService {
	
	public Products saveProducts(Products products);
	public List<Products>getAllProducts();
	public void deleteProduct(int productid);
	public Products updateProducts(Products products, int productid);

}
