package com.jinwoo.designpattern.strategy;

public class StrategyShield implements Strategy {

	@Override
	public void runStrategy() {
		bothHands();
		System.out.println("막았다");
	}

	private void bothHands(){
		System.out.println("양손으로 방패를 잡고");
	}
}
