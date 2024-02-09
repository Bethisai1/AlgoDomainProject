package com.task.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.charges.ProductCharges;
import com.task.product.Products;
import com.task.repo.ProductRepo;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductRepo repo;

	@Override
	public Products saveProducts(Products products) {
 
	double price = products.getProductprice();
	double discount = 0.0;
	double serviceCharge = 0.0;
	if(price<10000) {
		discount = price*0.1;
		serviceCharge = 100;
	}
	else if ((price>=10000)&&(price<20000)) {
		discount = price*0.15;
		serviceCharge = 200;
	}
	else if (price>=20000) {
		discount = price*0.3;
		serviceCharge = 300;
	}
	
	double amount = price-discount;
	double gst = amount*0.12;    
    double finalPrice = amount+gst+serviceCharge;
    
    ProductCharges charges = new ProductCharges();
    
    charges.setDiscount(discount);
    charges.setGst(gst);
    charges.setDeliveryCharge(serviceCharge);
    
    products.setCharges(charges);
    
    products.setFinalPrice(finalPrice);
    
    Products save = repo.save(products);
		return save;
	}

	@Override
	public List<Products> getAllProducts() {
		List<Products>get = repo.findAll();
		return get;
	}

	@Override
	public void deleteProduct(int productid) {

		repo.deleteById(productid);
		
	}

	@Override
	public Products updateProducts(Products products, int productid) {

		Products oldRecord = repo.findById(productid).get();
		
		oldRecord.setProductname(products.getProductname());
		oldRecord.setProductType(products.getProductType());
		oldRecord.setProductCategory(products.getProductCategory());
		oldRecord.setProductprice(products.getProductprice());
		
		double price = products.getProductprice();
		double discount = 0.0;
		double serviceCharge = 0.0;
		if(price<10000) {
			discount = price*0.1;
			serviceCharge = 100;
		}
		else if ((price>=10000)&&(price<20000)) {
			discount = price*0.15;
			serviceCharge = 200;
		}
		else if (price>=20000) {
			discount = price*0.3;
			serviceCharge = 300;
		}
		
		double amount = price-discount;
		double gst = amount*0.12;    
	    double finalPrice = amount+gst+serviceCharge;
	    
	    ProductCharges charges = new ProductCharges();
	    
	    charges.setDiscount(discount);
	    charges.setGst(gst);
	    charges.setDeliveryCharge(serviceCharge);
	    
	    oldRecord.setCharges(charges);
	    
	    oldRecord.setFinalPrice(finalPrice);
		
		Products update = repo.save(oldRecord);
	    
		return update;
	}
	
	

}
