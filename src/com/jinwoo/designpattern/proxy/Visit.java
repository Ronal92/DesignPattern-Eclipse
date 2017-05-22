package com.jinwoo.designpattern.proxy;

public class Visit {
	int no;
	int count = 0;
	public void increase(int bbsno) {
		// TODO Auto-generated method stub
		no  = bbsno;
		count = count+1;
		//뒤에 로직 또 있음.
		// 조회수 증가값 데이터베이스 저장 등....
	}
}
