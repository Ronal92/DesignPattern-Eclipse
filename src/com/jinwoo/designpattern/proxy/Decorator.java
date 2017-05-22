package com.jinwoo.designpattern.proxy;
/**
 * 
 * Decorator
 * Proxy�� ����� ������ ����������
 * Ŭ���̾�Ʈ ��û�� ���� ���������͸� ������ �� �����Ѵ�.
 *
 *
 */
public class Decorator {
	// 1. ���� ���� ������ ����.
		private static Decorator instance = null;
		// 2. ������ ����
		private Decorator(){}
		// 3. instance�� üũ�ؼ� �Ѱ��ش�.
		public static Decorator getInstance(){

			if(instance == null){
				instance = new Decorator();
			}
			return instance;
		}		
		public BbsExtend getBbs(int bbsno){
		
			BbsExtend bbsExtend = Database.readBbsExtend(bbsno); // ������ ���̽��� ���� �����´ٴ� ����......
			//���� �����͸� ������ �� �����Ѵ�.
			bbsExtend.count = bbsExtend.count + 1;
			bbsExtend.title = "����:" + bbsExtend.title;
			return bbsExtend;
		}
}
