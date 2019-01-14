package com.ssm.shoppingstreet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.shoppingstreet.dao.AddressDao;
import com.ssm.shoppingstreet.modal.Address;
import com.ssm.shoppingstreet.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;

	public List<Address> findAddressByUserId(int userId) {
		return this.addressDao.findAddressByUserId(userId);
	}

	public Address findDefaultAddress(int userId) {
		// TODO Auto-generated method stub
		return this.addressDao.findDefaultAddress(userId);
	}

	public int addAddress(int userId, String title, String area, String consigneeName, String consigneeEmail,
			String specifiedAddress, int consigneeMobilePhone, String consigneePhone, int isDefault) {
		// TODO Auto-generated method stub
		return this.addressDao.addAddress(userId, title, area, consigneeName, consigneeEmail, specifiedAddress,
				consigneeMobilePhone, consigneePhone, isDefault);
	}

	@Transactional(rollbackFor = Exception.class)
	public int setDefault(int userId, int addressId) {
		// TODO Auto-generated method stub
		return ((this.addressDao.unSetDefault(userId) + this.addressDao.setDefault(addressId) >= 1) ? 1 : 0);
	}

	public int delAddress(int addressId) {
		// TODO Auto-generated method stub
		return this.addressDao.delAddress(addressId);
	}

}
