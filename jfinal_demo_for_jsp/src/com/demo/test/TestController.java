package com.demo.test;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;

public class TestController extends Controller{
	
	public void index(){
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("msg", "测试成功");
		map.put("data",getPara(0));
		
		renderJson(map);
	}
	
	public void testObj(){
		renderJson();
	}

}
