package com.jinwoo.designpattern.observer;

/** 
 * Observer
 * 옵저버 인터페이스를 구현한 구현체들에게
 * 업데이트 사항을 자동으로 알려주는 패턴.    
 */
public interface Observer {
	// 옵저버를 제공하는 서버측에서 변경사항이 있을경우 호출하는 함수.
	public void update();
	
}
