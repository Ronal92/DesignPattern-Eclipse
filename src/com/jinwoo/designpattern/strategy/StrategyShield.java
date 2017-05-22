package com.jinwoo.designpattern.strategy;

public class StrategyShield implements Strategy {

	@Override
	public void runStrategy() {
		bothHands();
		System.out.println("���Ҵ�");
	}

	private void bothHands(){
		System.out.println("������� ���и� ���");
	}
}
