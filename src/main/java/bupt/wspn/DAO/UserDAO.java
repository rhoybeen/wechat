package bupt.wspn.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import bupt.wspn.DAOImpl.UserDaoImpl;
import bupt.wspn.bean.User;

public class UserDAO implements UserDaoImpl{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User select(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		String sql=" insert into user (id,openid,groupid,subscribetime) values(?,?,?,?)";
		return jdbcTemplate.update(sql,new Object[]{
			user.getId(),user.getOpenid(),user.getGroupid(),user.getSubtime()
		});
		
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
