package com.jinwoo.designpattern.templatemethod;
/**
 * Template Method
 * �θ� Ŭ������ ���ø� �޼��忡 �ִ� �����Լ���
 * �߻��Լ��� ��ӹ��� �ڽ� Ŭ������ ������ �޼��带 ȣ���ϴ� ����.
 * @author JINWOO
 *
 */
public abstract class TemplateMethod {
	
	public void play(){
		System.out.println("�÷��̰� ���۵˴ϴ�.");
		jump();
	}
	
	public abstract void jump();
}
