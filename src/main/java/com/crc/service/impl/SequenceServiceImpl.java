package com.crc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.crc.bean.SequenceBean;
import com.crc.mapper.SequenceMapper;
import com.crc.service.SequenceService;

@ComponentScan({"com.crc.mapper"})
@Service
public class SequenceServiceImpl implements SequenceService{
  
  @Autowired
  SequenceMapper mapper;

  @Override
  public SequenceBean selectByName(String name) {
    // TODO Auto-generated method stub
    return mapper.selectByName(name);
  }

  @Override
  public int update(String name, String old_verison,Integer current_value,String version) {
    // TODO Auto-generated method stub
    return mapper.update(name,old_verison, current_value,version);
  }
}
