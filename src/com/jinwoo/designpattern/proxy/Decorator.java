package com.jinwoo.designpattern.proxy;
/**
 * 
 * Decorator
 * Proxy와 비슷한 형태의 패턴이지만
 * 클라이언트 요청에 대한 원본데이터를 가공한 후 전달한다.
 *
 *
 */
public class Decorator {
	// 1. 나를 담을 변수를 선언.
		private static Decorator instance = null;
		// 2. 생성을 금지
		private Decorator(){}
		// 3. instance를 체크해서 넘겨준다.
		public static Decorator getInstance(){

			if(instance == null){
				instance = new Decorator();
			}
			return instance;
		}		
		public BbsExtend getBbs(int bbsno){
		
			BbsExtend bbsExtend = Database.readBbsExtend(bbsno); // 데이터 베이스를 통해 가져온다는 가정......
			//원본 데이터를 수정한 후 리턴한다.
			bbsExtend.count = bbsExtend.count + 1;
			bbsExtend.title = "제목:" + bbsExtend.title;
			return bbsExtend;
		}
}
