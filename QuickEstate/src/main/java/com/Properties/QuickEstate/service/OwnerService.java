package com.Properties.QuickEstate.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Properties.QuickEstate.entity.Owner;
import com.Properties.QuickEstate.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	OwnerRepository ownerRepository;
	
	public Owner createDetails(Owner owner) {
		return ownerRepository.save(owner);
	}

	public List<Owner> getDetailsOfOwner(Long id) {
		return ownerRepository.findAll();
	}

	public Optional<Owner> getDetailsById(Long id) {
		return ownerRepository.findById(id);
	}

	public String DeleteOwnerDetails(Long id) {
		ownerRepository.findById(id);
		return "Deletion Successfully";
	}

	public Owner updateOwnerDetails(Owner currentowner, Long id) {
	Owner owner=ownerRepository.findById(id).get();
		if(owner.getAddress()!=null) {
			owner.setAddress(currentowner.getAddress());
		}
		if(owner.getProperty()!=null) {
			owner.setProperty(currentowner.getProperty());
		}
		return ownerRepository.save(owner);
	}



}
