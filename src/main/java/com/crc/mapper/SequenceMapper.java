package com.crc.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.crc.bean.SequenceBean;
@Mapper
public interface SequenceMapper {
  public SequenceBean selectByName(String name);
  public int update(String name,String old_version ,int current_value,String version);

}
