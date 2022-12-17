package com.masai.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.exception.AddressException;
import com.masai.module.Address;
import com.masai.repository.AddressDao;

@Service

public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao aDao;


	@Override
	public Address addAddress(Address add) throws AddressException {
		if (add!=null) {
//			add.getCustomer().setAddress(add);
			return aDao.save(add);
		}

		
		else throw new AddressException("Please enter the correct Address details");
	}

	@Override
	public Address updateAddress(Address add) throws AddressException {
		Optional<Address> existingAddress = aDao.findById(add.getAddressId());

		if (existingAddress.isPresent()) {

			return aDao.save(add);

		} else {
			throw new AddressException("Address Not Found...");
		}

	}

	@Override
	public Address removeAddress(int id) throws AddressException {
		Address existingAddress = aDao.findById(id).orElseThrow(() -> new AddressException("Address Not Found..."));
		aDao.delete(existingAddress);
		return existingAddress;
	}

	@Override
	public Address viewAddressbyId(int id) throws AddressException {

		Address existingAddress = aDao.findById(id).orElseThrow(() -> new AddressException("Address Not Found..."));

		return existingAddress;
	}

	@Override
	public List<Address> viewAllAddress() throws AddressException {
		List<Address> addresses = aDao.findAll();

		if(addresses.size()==0){
			throw new  AddressException("Addresses Not Found...");
		}
		
		return addresses;
	}
}
