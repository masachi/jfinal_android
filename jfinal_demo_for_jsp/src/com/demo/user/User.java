package com.demo.user;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class User extends Model<User> {

	public static User user = new User();

	public int loginCheck(String userName, String password) {
		int flag = 0;
		List<User> list = user.find("select * from user where username=?",
				userName);
		if (list != null && list.size() > 0) {
			// 存在
			User result = user.findFirst(
					"select * from user where username=? and password=?",
					userName, password);
			if (result != null) {
				flag = 1; // 登录成功
			} else {
				flag = 2; // 密码错误
			}
		} else {
			flag = 3; // 账号不存在
		}
		return flag;
	}
	
	public String registUser(String userName, String password, String realName){
		String sql = "SELECT * FROM user WHERE username=?";
		User result = user.findFirst(sql,userName);
		String msg = "";
		if(result == null){
			//可以注册
			User save_user = new User();
			save_user.set("username", userName);
			save_user.set("password", password);
			save_user.set("role",1);	//默认是乘客
			save_user.set("realname", realName);
			boolean flag = save_user.save();
			if(flag) {
				msg = "注册成功！";
			}else {
				msg = "网络异常，稍后重试！";
			}
		}else {
			msg = "该用户名已被注册！";
		}
		
		return msg;
	}
}
