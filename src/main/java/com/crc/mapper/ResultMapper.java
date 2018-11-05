package com.crc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.crc.bean.ResultBean;

@Mapper
public interface ResultMapper {

  public int insert(ResultBean resultBean);
  
  public ResultBean selectById(@Param("id") Integer id);
  
  public List<ResultBean> selectAll();
}
