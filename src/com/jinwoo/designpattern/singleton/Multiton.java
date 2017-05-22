package com.jinwoo.designpattern.singleton;

public class Multiton {

	// 생성자를 막는다.
	private Multiton(){}
	// 생성함수를 제공한다.
	public static Multiton newInstance(){
		return new Multiton();
	}
	
	public String name = "";
	
}
