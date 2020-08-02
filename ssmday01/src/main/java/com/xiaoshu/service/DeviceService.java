package com.xiaoshu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.DeviceMapper;
import com.xiaoshu.entity.Device;

@Service
@Transactional
public class DeviceService {

	@Autowired
	DeviceMapper deviceMapper;

	public PageInfo<Device> findDevicePage(Device device, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Device> userList = deviceMapper.findAll(device);
		PageInfo<Device> pageInfo = new PageInfo<Device>(userList);
		return pageInfo;
	}

	public Device existDeviceWithDeviceName(String deviceName) {
		List<Device> deviceList = deviceMapper.findByName(deviceName);
		return deviceList.isEmpty()?null:deviceList.get(0);
	}
	public void addDevice(Device device) {
		// TODO Auto-generated method stub
		deviceMapper.insert(device);
	}

	public void updateDevice(Device device) {
		// TODO Auto-generated method stub
		deviceMapper.updateByPrimaryKeySelective(device);
	}

	public void deleteDevice(int parseInt) {
		// TODO Auto-generated method stub
		deviceMapper.deleteByPrimaryKey(parseInt);
	}

}
