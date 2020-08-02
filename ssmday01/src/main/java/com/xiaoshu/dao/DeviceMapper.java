package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Device;
import java.util.List;

public interface DeviceMapper extends BaseMapper<Device> {
  

	List<Device> findByName(String deviceName);

	List<Device> findAll(Device device);

}