package com.crc.service;

import com.crc.bean.SequenceBean;

public interface SequenceService {
  public SequenceBean selectByName(String name);
  public int update(String name,String old_version,Integer current_value,String version);

}
