package com.crc.service.impl;

import java.util.List;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.crc.bean.ResultBean;
import com.crc.mapper.ResultMapper;
import com.crc.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;

@ComponentScan({"com.crc.mapper"})
@Service
public class ResultServiceImpl implements ResultService{
  
   @Autowired
   ResultMapper resultMapper;
   

  @Override
  public int insert(ResultBean resultBean) {
    // TODO Auto-generated method stub
    return resultMapper.insert(resultBean);
  }

  @Override
  public ResultBean selectById(Integer id) {
    // TODO Auto-generated method stub
    return resultMapper.selectById(id);
  }

  @Override
  public List<ResultBean> selectAll() {
    // TODO Auto-generated method stub
    return resultMapper.selectAll();
  }
   
}
