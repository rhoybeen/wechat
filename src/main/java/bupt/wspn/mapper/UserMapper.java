package bupt.wspn.mapper;


import java.util.List;

import bupt.wspn.bean.User;

public interface UserMapper {
    int createUser(User user);
    int newUser(User user);
    int registerUserInfo(User user);
    boolean updateUserInfo(User user);
    
    User findByOpenId(String openid);
    boolean update(User user);  
    boolean delete(int id);  
    User findById(int id);  
    List<User> findAll();  
}
