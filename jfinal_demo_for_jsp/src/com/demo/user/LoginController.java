package com.demo.user;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;

public class LoginController extends Controller {
	
	public void index(){
		String username = getPara("param0");
		String password = getPara("param1");
		
		int result = User.user.loginCheck(username, password);
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("result", result);
		renderJson(map);
	}

}
