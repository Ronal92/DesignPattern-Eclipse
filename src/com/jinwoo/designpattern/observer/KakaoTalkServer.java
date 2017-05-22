package com.jinwoo.designpattern.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * �������� �����ϴ� ���μ���
 *
 */
public class KakaoTalkServer {
	
	// ���������� �����صδ� �����
	List<Observer> observers = new ArrayList<>();
	
	// ������ �����
	public String data="";
	
	// ������ ����ҿ� �������� �����ϴ� ����
	public void addObserver(Observer observers){
		this.observers.add(observers);
	}
	
	// ��������� �߻����� �� �������鿡�� �����ϴ� ����.
	private void notification(){
		for(Observer observer : observers){
			observer.update();
		}
	}
	
	// Student�� ����ϴ� �޽��� ���� �Լ�
	public void sendMessage(String msg){
		// �����ؾ� �Ǵ� �޽����� �߻��ϸ� notification���� ��� ���������� �˸���.
		data = msg;
		notification();
	}
}
