package com.jinwoo.designpattern.factorymethod;

// 생산라인에서 막 나온 제품
public abstract class Packed {
	Product product;
	
	public void setProduct(Product product){
		this.product  = product;
	}
}
