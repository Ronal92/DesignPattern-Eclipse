package com.jinwoo.designpattern.proxy;

public class Visit {
	int no;
	int count = 0;
	public void increase(int bbsno) {
		// TODO Auto-generated method stub
		no  = bbsno;
		count = count+1;
		//�ڿ� ���� �� ����.
		// ��ȸ�� ������ �����ͺ��̽� ���� ��....
	}
}
