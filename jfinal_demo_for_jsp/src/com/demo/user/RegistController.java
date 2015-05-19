package com.demo.user;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;

public class RegistController extends Controller{
	
	public void index(){
		
	}
	
	
	/**
	 * 注册的方法
	 * 传入的参数为/v0-v1-v2  v0：用户名 	v1：密码	  v2：姓名
	 */
	public void regist(){
		String userName = getPara(0);
		String password = getPara(1);
		String realName = getPara(2);
		String msg = User.user.registUser(userName, password, realName);
		Map<String,String> map = new HashMap<String,String>();
		map.put("result",msg);
		System.out.println(msg);
		renderJson(map);
	}

}
