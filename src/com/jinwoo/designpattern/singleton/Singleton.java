package com.jinwoo.designpattern.singleton;


/**
 * 
 * Singleton
 * �̱��� ������ �ڿ��� �����ϱ� ���� �������� ����Ѵ�.
 * Multi Thread ȯ�濡���� �Ʒ� ������ ����ȭ�� �߰��ؾ� �մϴ�.
 *
 */

public class Singleton {

	// ��Ŭ�� �ڽ��� ��Ƶδ� ��������
	public static Singleton instance = null;
	// ��Ŭ���� ��Ʈ�� ��� ����
	public String name = "";	
	// new ����� ���ϰ� �Ѵ�. 
	private Singleton(){} 	
	// ��ü ������ �ϳ��� �ϰ� �Ѵ�.
	public static Singleton getInstance(){		
		// 1. instance ������ ���� �ִ����� üũ�ϰ� ������ �����Ѵ�.
		if(instance == null){
			instance = new Singleton();
		}
		// 2. instance�� �����Ѵ�.
		return instance;	
	}	
	
}
