package com.hostel.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.dao.HostelDAO;
import com.hostel.pojo.Hostel;

//stereo type annotations.
@Service
public class HostelService {

	//object created by spring container using reflection
	//default by type is used.
	@Autowired
	HostelDAO hostelDAO;

	public List<Hostel> getAllHostel(){
		return hostelDAO.getAllHostels(); 
	}
	public void saveHostelService(Hostel hostel) {
		 hostelDAO.saveHostel(hostel);
	}
	public Hostel getHostelServiceById(int hostelId) {
		return hostelDAO.getHostelById(hostelId);
	}
}
