package com.smb.MMUtil.testcase.framework;

import java.util.Map;

 
public class RequestTestCase {

	/**
	 * @param args
	 * @throws Exception 
	 * 此程序 示例为 Action  
	 * 在Action 中 加入 ObjectFactory.getObjectFactory( pojo,map  ); 方法
	 * pojo 表示在 handleModelAndPage()方法中 new的对象
	 * map 表示 在 handleModelAndPage 方法中 传递过来的  HttpServletRequest  对象
	 * 得到 运行返回值 对象，在传入 Service 中。
	 */
	public static void main(String[] args) throws Exception {
		RequestPojo  pojo= new RequestPojo();
		
		Map<?, ?> map =  RequestDataSource.getRequestDataSourceE();
		
		// 放入 Service方法中需要的 new pojo对象，放入 request 对象 
		Object ee=ObjectFactory.getObjectFactory( pojo,map  );   
	
		System.out.println (ee);

	}

}
