package bupt.wspn.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bupt.wspn.bean.User;
import bupt.wspn.mapper.UserMapper;

@Controller
public class LoginRegistryController {

	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(value = "/registry",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String registry(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		User user = new User();
		String openid = request.getParameter("openid");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("address");
		String alipay = request.getParameter("alipay");
		String gender = request.getParameter("gender");
		String school = request.getParameter("school");
		String email = request.getParameter("email");
		user.setUsername(name);
		user.setAddress(addr);
		user.setTelephone(phone);
		user.setAlipay(alipay);
		user.setGender(gender);
		user.setSchool(school);
		user.setEmail(email);
		user.setOpenid(openid);
		System.out.println("Registry request from user "+openid);
		
		if(user.getUsername()!=null){
			try{
				int result = userMapper.registerUserInfo(user);
				if(result>0){
					return "您的信息已成功添加~！";
				}
			}catch (DuplicateKeyException e) {
				System.out.println("用户已经存在,执行更新");
				boolean result = userMapper.updateUserInfo(user);
				return result?"已成功为您更新信息！":"信息更新失败！";
			}
		}

		
		return "信息录入失败，请重试！";
	}
}
