package com.task.product;

import com.task.charges.ProductCharges;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productid;
	private String productname;
	private String productType;
	private String productCategory;
	private double productprice;
	
	@Embedded
	private ProductCharges charges;
	
	private double finalPrice;

	public Products() {

		System.out.println("ProductsCreated");
           
	}

	public Products(int productid, String productname, String productType, String productCategory, double productprice,
			ProductCharges charges, double finalPrice) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productType = productType;
		this.productCategory = productCategory;
		this.productprice = productprice;
		this.charges = charges;
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return "Products [productid=" + productid + ", productname=" + productname + ", productType=" + productType
				+ ", productCategory=" + productCategory + ", productprice=" + productprice + ", charges=" + charges
				+ ", finalPrice=" + finalPrice + "]";
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	public ProductCharges getCharges() {
		return charges;
	}

	public void setCharges(ProductCharges charges) {
		this.charges = charges;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}


	
	
	
	
}
