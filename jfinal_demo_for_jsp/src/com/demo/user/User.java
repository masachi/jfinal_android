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
}
