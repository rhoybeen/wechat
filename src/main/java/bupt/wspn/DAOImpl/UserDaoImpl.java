package bupt.wspn.DAOImpl;

import java.util.List;

import bupt.wspn.bean.User;

public interface UserDaoImpl {
	public int insert(User user);
	public void delete(int id);
	public void update(User user);
	public User select(int id);
	public List find();
}
