package com.ssm.shoppingstreet.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.shoppingstreet.modal.Address;

public interface AddressService {
	/**
	 * �����û������ջ���ַ
	 * 
	 * @param userId
	 * @return
	 */
	List<Address> findAddressByUserId(int userId);

	/**
	 * �����û�Ĭ���ջ���ַ
	 * 
	 * @param userId
	 * @return
	 */
	Address findDefaultAddress(int userId);

	/**
	 * ����ջ���ַ
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
	 * ����Ĭ�ϵ�ַ
	 * 
	 * @param userId
	 * @param addressId
	 * @return
	 */
	int setDefault(int userId, int addressId);

	/**
	 * ɾ����ַ
	 * @param addressId
	 * @return
	 */
	int delAddress(int addressId);
}
