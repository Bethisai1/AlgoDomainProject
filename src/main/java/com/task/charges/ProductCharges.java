package com.task.charges;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductCharges {

	private double discount;
	private double gst;
	private double deliveryCharge;
	public ProductCharges() {
		System.out.println("ProductChargeClassStarted");
	}
	public ProductCharges( double discount, double gst, double deliveryCharge) {
		super();
		this.discount = discount;
		this.gst = gst;
		this.deliveryCharge = deliveryCharge;
	}
	@Override
	public String toString() {
		return "ProductCharges [discount=" + discount + ", gst=" + gst
				+ ", deliveryCharge=" + deliveryCharge + "]";
	}

	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
	
	
	
	
}
