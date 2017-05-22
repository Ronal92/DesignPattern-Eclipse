package com.jinwoo.designpattern.singleton;


/**
 * 
 * Singleton
 * 싱글턴 패턴은 자원을 공유하기 위한 목적으로 사용한다.
 * Multi Thread 환경에서는 아래 로직에 동기화를 추가해야 합니다.
 *
 */

public class Singleton {

	// 싱클턴 자신을 담아두는 변수공간
	public static Singleton instance = null;
	// 싱클턴의 스트링 멤버 변수
	public String name = "";	
	// new 사용을 못하게 한다. 
	private Singleton(){} 	
	// 객체 생성을 하나만 하게 한다.
	public static Singleton getInstance(){		
		// 1. instance 변수에 값이 있는지를 체크하고 없으면 생성한다.
		if(instance == null){
			instance = new Singleton();
		}
		// 2. instance를 리턴한다.
		return instance;	
	}	
	
}
