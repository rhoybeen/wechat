package bupt.wspn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.bind.annotation.RequestMapping;

import bupt.wspn.DAO.UserDAO;
import bupt.wspn.bean.User;
import bupt.wspn.mapper.UserMapper;
import ch.qos.logback.core.encoder.EchoEncoder;

@Controller
public class DBController {
	
	@Autowired
	UserMapper userOperation;

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@RequestMapping("login.do")
	public String Login(HttpServletRequest request,
			HttpServletResponse response){
		
		int userId=Integer.valueOf(request.getParameter("userName"));
		String userOpenid=request.getParameter("userPwd");
		User user = new User();
		user.setId(userId);
		user.setOpenid(userOpenid);
		user.setSubtime(null);
		
		
//		SqlSession session = sqlSessionFactory.openSession();
//		try{
//			UserMapper userMapper = session.getMapper(UserMapper.class);
//			int result = userMapper.save(user);
//			System.out.println("Result:" + Integer.toString(result));
//			return result!=0?"success":"error";
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			System.out.println("Session Error");
//		}finally{
//			session.close();
//		}
		
		try{
			int result = userOperation.createUser(user);
			System.out.println("Result:" + Integer.toString(result));
			return result!=0?"success":"error";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "error";
		
	}
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
