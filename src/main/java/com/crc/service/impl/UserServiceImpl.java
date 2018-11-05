package com.crc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.crc.bean.User;
import com.crc.mapper.UserMapper;
import com.crc.service.UserService;

@ComponentScan({"com.crc.mapper"})
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userDao;
  
  @Override
  public User getUserById(Integer id) {
    return userDao.getUserById(id);
  }

  @Override
  public List<User> getUserList() {
   
    return userDao.getUserList();
  }

  @Override
  public int add(User user) {
   
    return userDao.createUser(user);
  }

  @Override
  public int update(Integer id, User user) {
 
    return userDao.update(id, user);
  }

  @Override
  public int delete(Integer id) {
   
    return userDao.delete(id);
  }



  @Override
  public User selectByLogin(String login) {

    return userDao.selectByLogin(login);
  }

}
