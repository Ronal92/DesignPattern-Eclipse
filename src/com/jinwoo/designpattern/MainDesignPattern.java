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
		
		// 1. 싱클턴 패턴 사용해 보기
		Singleton single1 = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		
		System.out.printf("single1.name = %s  | single2.name = %s \n", single1.name, single2.name);
				
		single1.name = "홍길동";
		
		System.out.printf("single1.name = %s | single2.name = %s \n", single1.name, single2.name);
		
		// 2.  Multiton 사용하기		
		Multiton multi1 = Multiton.newInstance();
		Multiton multi2 = Multiton.newInstance();
		
		System.out.printf("multi1.name =  %s | multi2.name = %s \n",multi1.name, multi2.name);
		
		multi1.name = "김고은";
		
		System.out.printf("multi1.name =  %s | multi2.name = %s \n",multi1.name, multi2.name);
		
		// 3. 프록시 패턴을 사용해봅니다.
		Proxy proxy = Proxy.getInstance();
		Bbs bbs = proxy.getBbs(33);
		System.out.printf("no = %d,  title = %s, contnet = %s\n",bbs.no, bbs.title, bbs.content);		
		
		
		// 4. 템플릿 메소드 패턴을 사용합니다.
		TemplateMethod frog = new Frog();
		frog.play();
		TemplateMethod rabbit = new Rabbit();
		rabbit.play();
	
		// 5. 팩토리 메서드 패턴을 사용합니다.
		FactoryMethod factory = new TVFactory();
		Product product = factory.make();
		factory.pack(product);
		
		
		// 6. 전략 패턴을 사용합니다. (Main이 클라이언트)
		Strategy strategy = null;
		Soldier context = new Soldier();
		// 전략패턴은 전략인터페이스를 구현한 구현체를 주입한다.
		context.status = Soldier.NEAR;
		
		if(context.status == Soldier.ATTACKED){
			strategy = new StrategyShield();
		}else if(context.status == Soldier.NEAR){
			strategy = new StrategySword();
		}else {
			strategy = new StrategyGun();
		}
		   
		context.useStrategy(strategy); // 전략을 컨텍스트에 넘겨서 사용한다.
		
		// 7. 전략 CallBack 패턴을 사용합니다.
		// 전략패턴과 동일한테 전략자체를 클라이언트에서 익명객체로 생성한다.
		Strategy strategy2 = null;
		Soldier context2 = new Soldier();
		
		context2.status = Soldier.ATTACKED;
		
		 // 전략 CallBack은 구현체를 사용하지 않고 익명객체를 코드상에서 구현해준다.
		if(context.status == Soldier.ATTACKED){
			context2.useStrategy(new Strategy(){
				public void runStrategy(){
					useShield();
					System.out.println("막는다");
				}
				private void useShield(){
					System.out.println("방패를 양손으로 잡고");
				}
			});
		}
		
		else if(context.status == Soldier.NEAR){
			context2.useStrategy(new Strategy(){
				@Override
				public void runStrategy() {
					System.out.println("찌른다");
				}
			});
		}
		
		
		else {
			context2.useStrategy(new Strategy(){
				@Override
				public void runStrategy() {
					System.out.println("쏜다");

				}
			});
		}
		/*--------------------------------------------------------------------------*/		
		// 8. 옵저버 사용하기
		// 8.1 옵저버를 사용하기 위해서는 서버가 먼저 생성되어야 한다.
		
		KakaoTalkServer server = new KakaoTalkServer();
		// server.addObserver(stu1);
		
		new Student(server, "철수");		
		new Student(server, "재인");
		new Student(server, "희정");
		
		// 8.2 서버를 통해 공지를 띄운다(Stduent 인스턴스를 거치지 않고)
		server.sendMessage("점심시간입니다.~~");
	}
}
