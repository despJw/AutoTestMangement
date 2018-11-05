package com.crc.service;

import java.util.List;
import com.crc.bean.User;

public interface UserService {
  
  public User getUserById(Integer id);  
  public List<User> getUserList();  
  public int add(User user);  
  public int update(Integer id, User user); 
  public int delete(Integer id);
  public User selectByLogin(String login);
}
