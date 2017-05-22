package com.jinwoo.designpattern.proxy;

public class Database {
	public static Bbs readBbs(int bbsno){
		Bbs bbs = new Bbs();
		// �����͸� ������ �Ŀ� �������ش�.
		// ����...........
		bbs.no = bbsno;
		bbs.title = "������1";
		bbs.content = "����1";
		return bbs;
	}

	public static BbsExtend readBbsExtend(int bbsno) {
		// TODO Auto-generated method stub
		BbsExtend bbsExtend = new BbsExtend();
		bbsExtend.no = bbsno;
		bbsExtend.title = "������1";
		bbsExtend.content = "����1";
		bbsExtend.count = 3;
		return bbsExtend;
	}
}
