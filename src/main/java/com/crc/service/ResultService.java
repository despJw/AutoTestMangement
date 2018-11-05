package com.crc.service;

import java.util.List;
import com.crc.bean.ResultBean;

public interface ResultService {
 public int insert(ResultBean resultBean);
  
  public ResultBean selectById(Integer id);
  
  public List<ResultBean> selectAll();
}
