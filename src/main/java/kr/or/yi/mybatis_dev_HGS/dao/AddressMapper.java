package kr.or.yi.mybatis_dev_HGS.dao;

import org.apache.ibatis.annotations.Select;

import kr.or.yi.mybatis_dev_HGS.dto.Address;

public interface AddressMapper {
	@Select("select addr_id as addrId, street, city, state, zip, country from address where addr_id=#{id}")
	Address selectAddressByid(int id);
}
