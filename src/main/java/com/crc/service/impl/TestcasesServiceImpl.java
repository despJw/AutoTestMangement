package com.crc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.crc.bean.TestcasesBean;
import com.crc.mapper.TestcasesMapper;
import com.crc.service.TestcasesService;

@Service
@ComponentScan({"com.crc.mapper"})
public class TestcasesServiceImpl implements TestcasesService{
  
   @Autowired
   TestcasesMapper caseDao;
   
  @Override
  public List<TestcasesBean> getAll(Integer typeId,Integer projectId) {
    return caseDao.getAll(typeId,projectId);
  }
  
  @Override
  public List<TestcasesBean> getPart(String casename,String classname) {
	  return caseDao.getPart(casename,classname);
  }

}