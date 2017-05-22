package com.jinwoo.designpattern.strategy;


// ������ ����ϴ� Context ��ü
public class Soldier {

	public static final int NEAR = 0;
	public static final int FAR = 0;
	public static final int ATTACKED = 0;
	
	public int status = FAR;
	
	public void useStrategy(Strategy strategy){
		System.out.println("---��������---");
		
		strategy.runStrategy();
		
		System.out.println("---��������---");
		
	}
}


