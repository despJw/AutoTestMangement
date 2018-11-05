package com.crc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.crc.bean.User;

@Mapper
public interface UserMapper {

  public User getUserById(Integer id);
  public int createUser(User user); 
  public int update(@Param("id") Integer id, @Param("user") User user);
 
  public int delete(Integer id);

  public List<User> getUserList();
  public User selectByLogin(@Param("login") String login);
}
