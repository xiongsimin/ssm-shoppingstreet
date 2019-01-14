package com.ssm.shoppingstreet.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.shoppingstreet.modal.Address;

public interface AddressService {
	/**
	 * 查找用户所有收货地址
	 * 
	 * @param userId
	 * @return
	 */
	List<Address> findAddressByUserId(int userId);

	/**
	 * 查找用户默认收货地址
	 * 
	 * @param userId
	 * @return
	 */
	Address findDefaultAddress(int userId);

	/**
	 * 添加收货地址
	 * 
	 * @param userId
	 * @param title
	 * @param area
	 * @param consigneeName
	 * @param consigneeEmail
	 * @param specifiedAddress
	 * @param consigneeMobilePhone
	 * @param consigneePhone
	 * @param isDefault
	 * @return
	 */
	int addAddress(int userId, String title, String area, String consigneeName, String consigneeEmail,
			String specifiedAddress, int consigneeMobilePhone, String consigneePhone, int isDefault);

	/**
	 * 设置默认地址
	 * 
	 * @param userId
	 * @param addressId
	 * @return
	 */
	int setDefault(int userId, int addressId);

	/**
	 * 删除地址
	 * @param addressId
	 * @return
	 */
	int delAddress(int addressId);
}
