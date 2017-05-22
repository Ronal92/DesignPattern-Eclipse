package com.jinwoo.designpattern.proxy;

public class Database {
	public static Bbs readBbs(int bbsno){
		Bbs bbs = new Bbs();
		// 데이터를 세팅한 후에 리턴해준다.
		// 로직...........
		bbs.no = bbsno;
		bbs.title = "글제목1";
		bbs.content = "내용1";
		return bbs;
	}

	public static BbsExtend readBbsExtend(int bbsno) {
		// TODO Auto-generated method stub
		BbsExtend bbsExtend = new BbsExtend();
		bbsExtend.no = bbsno;
		bbsExtend.title = "글제목1";
		bbsExtend.content = "내용1";
		bbsExtend.count = 3;
		return bbsExtend;
	}
}
