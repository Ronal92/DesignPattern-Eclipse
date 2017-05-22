package com.jinwoo.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Student implements Observer {

	KakaoTalkServer server;
	String name = "";
	
	public Student(KakaoTalkServer server, String name){
		this.name = name;
		this.server = server; // ��ȣ���� ������ ������ ���!
		server.addObserver(this); // ��ȣ���� ���� ������ ���!
	}
	
	// �޽����� �����ϴ� �����
	List<String> messages = new ArrayList<String>();
	
	@Override
	public void update(){
		// ������Ʈ�� �Ͼ�� �ٶ󺸰� �ִ� ������ �����͸� ����Ѵ�.
		String msg = server.data;
		messages.add(msg);
		showMessage();
	}	
	
	public void showMessage(){
		System.out.println(name + "���� �� �޽���: " + messages.get(messages.size()-1));
	}

}
