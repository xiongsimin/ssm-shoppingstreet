package com.ssm.shoppingstreet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.shoppingstreet.modal.Address;

public interface AddressDao {
	List<Address> findAddressByUserId(@Param("userId") int userId);

	Address findDefaultAddress(@Param("userId") int userId);

	int addAddress(@Param("userId") int userId, @Param("title") String title, @Param("area") String area,
			@Param("consigneeName") String consigneeName, @Param("consigneeEmail") String consigneeEmail,
			@Param("specifiedAddress") String specifiedAddress, @Param("consigneeMobilePhone") int consigneeMobilePhone,
			@Param("consigneePhone") String consigneePhone, @Param("isDefault") int isDefault);

	int unSetDefault(@Param("userId") int userId);

	int setDefault(@Param("addressId") int addressId);

	int delAddress(@Param("addressId") int addressId);
}
