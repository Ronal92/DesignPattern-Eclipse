package com.jinwoo.designpattern.singleton;

public class Multiton {

	// �����ڸ� ���´�.
	private Multiton(){}
	// �����Լ��� �����Ѵ�.
	public static Multiton newInstance(){
		return new Multiton();
	}
	
	public String name = "";
	
}
