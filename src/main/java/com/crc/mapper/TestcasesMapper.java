package com.crc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.crc.bean.TestcasesBean;

@Mapper
public interface TestcasesMapper {
  
  public List<TestcasesBean> getAll(Integer typeId,Integer projectId);
  
  public List<TestcasesBean> getPart(@Param("casename") String casename,@Param("classname") String classname);
}