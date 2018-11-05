package com.crc.bean;

import java.io.Serializable;
import org.slf4j.LoggerFactory;


public class User implements Serializable {

  private static final long serialVersionUid = 8809101560720973267L;
  private org.slf4j.Logger logger = LoggerFactory.getLogger(User.class);
  private Integer id;
  private String login;
  private String userName;
  private String password;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  @Override
  public String toString() {
    return "[id=" + id + ", login=" + login + ", username=" + userName + ", password="
        + password + "]";
  }
  public User(Integer id, String login, String username, String password) {
    super();
    this.id = id;
    this.login = login;
    this.userName = username;
    this.password = password;
  }
  public User() {
    // TODO Auto-generated constructor stub
  }
  
}
