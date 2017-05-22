package com.jinwoo.designpattern;

import com.jinwoo.designpattern.factorymethod.FactoryMethod;
import com.jinwoo.designpattern.factorymethod.Product;
import com.jinwoo.designpattern.factorymethod.TVFactory;
import com.jinwoo.designpattern.observer.KakaoTalkServer;
import com.jinwoo.designpattern.observer.Student;
import com.jinwoo.designpattern.proxy.Bbs;
import com.jinwoo.designpattern.proxy.Proxy;
import com.jinwoo.designpattern.singleton.Multiton;
import com.jinwoo.designpattern.singleton.Singleton;
import com.jinwoo.designpattern.strategy.Soldier;
import com.jinwoo.designpattern.strategy.Strategy;
import com.jinwoo.designpattern.strategy.StrategyGun;
import com.jinwoo.designpattern.strategy.StrategyShield;
import com.jinwoo.designpattern.strategy.StrategySword;
import com.jinwoo.designpattern.templatemethod.Frog;
import com.jinwoo.designpattern.templatemethod.Rabbit;
import com.jinwoo.designpattern.templatemethod.TemplateMethod;

public class MainDesignPattern{
	

	
	public static void main(String[] args){
		
		// 1. ��Ŭ�� ���� ����� ����
		Singleton single1 = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		
		System.out.printf("single1.name = %s  | single2.name = %s \n", single1.name, single2.name);
				
		single1.name = "ȫ�浿";
		
		System.out.printf("single1.name = %s | single2.name = %s \n", single1.name, single2.name);
		
		// 2.  Multiton ����ϱ�		
		Multiton multi1 = Multiton.newInstance();
		Multiton multi2 = Multiton.newInstance();
		
		System.out.printf("multi1.name =  %s | multi2.name = %s \n",multi1.name, multi2.name);
		
		multi1.name = "�����";
		
		System.out.printf("multi1.name =  %s | multi2.name = %s \n",multi1.name, multi2.name);
		
		// 3. ���Ͻ� ������ ����غ��ϴ�.
		Proxy proxy = Proxy.getInstance();
		Bbs bbs = proxy.getBbs(33);
		System.out.printf("no = %d,  title = %s, contnet = %s\n",bbs.no, bbs.title, bbs.content);		
		
		
		// 4. ���ø� �޼ҵ� ������ ����մϴ�.
		TemplateMethod frog = new Frog();
		frog.play();
		TemplateMethod rabbit = new Rabbit();
		rabbit.play();
	
		// 5. ���丮 �޼��� ������ ����մϴ�.
		FactoryMethod factory = new TVFactory();
		Product product = factory.make();
		factory.pack(product);
		
		
		// 6. ���� ������ ����մϴ�. (Main�� Ŭ���̾�Ʈ)
		Strategy strategy = null;
		Soldier context = new Soldier();
		// ���������� �����������̽��� ������ ����ü�� �����Ѵ�.
		context.status = Soldier.NEAR;
		
		if(context.status == Soldier.ATTACKED){
			strategy = new StrategyShield();
		}else if(context.status == Soldier.NEAR){
			strategy = new StrategySword();
		}else {
			strategy = new StrategyGun();
		}
		   
		context.useStrategy(strategy); // ������ ���ؽ�Ʈ�� �Ѱܼ� ����Ѵ�.
		
		// 7. ���� CallBack ������ ����մϴ�.
		// �������ϰ� �������� ������ü�� Ŭ���̾�Ʈ���� �͸���ü�� �����Ѵ�.
		Strategy strategy2 = null;
		Soldier context2 = new Soldier();
		
		context2.status = Soldier.ATTACKED;
		
		 // ���� CallBack�� ����ü�� ������� �ʰ� �͸���ü�� �ڵ�󿡼� �������ش�.
		if(context.status == Soldier.ATTACKED){
			context2.useStrategy(new Strategy(){
				public void runStrategy(){
					useShield();
					System.out.println("���´�");
				}
				private void useShield(){
					System.out.println("���и� ������� ���");
				}
			});
		}
		
		else if(context.status == Soldier.NEAR){
			context2.useStrategy(new Strategy(){
				@Override
				public void runStrategy() {
					System.out.println("���");
				}
			});
		}
		
		
		else {
			context2.useStrategy(new Strategy(){
				@Override
				public void runStrategy() {
					System.out.println("���");

				}
			});
		}
		/*--------------------------------------------------------------------------*/		
		// 8. ������ ����ϱ�
		// 8.1 �������� ����ϱ� ���ؼ��� ������ ���� �����Ǿ�� �Ѵ�.
		
		KakaoTalkServer server = new KakaoTalkServer();
		// server.addObserver(stu1);
		
		new Student(server, "ö��");		
		new Student(server, "����");
		new Student(server, "����");
		
		// 8.2 ������ ���� ������ ����(Stduent �ν��Ͻ��� ��ġ�� �ʰ�)
		server.sendMessage("���ɽð��Դϴ�.~~");
	}
}