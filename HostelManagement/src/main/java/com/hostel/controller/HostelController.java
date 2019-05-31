package com.hostel.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hostel.exception.BadRequestException;
import com.hostel.exception.NoDataFoundException;
import com.hostel.pojo.Hostel;
import com.hostel.service.HostelService;

@RestController
public class HostelController {

	@Autowired
	HostelService hostelService;

	//by default it will use get method and spring will 
	//convert to json
	@RequestMapping("/allHostels")
	public List<Hostel> getAllHostel() {
		return hostelService.getAllHostel();
	}
	
	@RequestMapping(method = RequestMethod.POST
			,value = "/saveHostel" )
	public ResponseEntity<Hostel> saveHostel(@RequestBody(required = false) Hostel hostel) {
		
		if(hostel.getName() == null || hostel.getAddress() == null) {
			throw new BadRequestException("request can't get completed as it is not mapped by anything");
		}
		hostelService.saveHostelService(hostel);
		System.out.println("object saved");
		return new ResponseEntity<Hostel>(hostel,HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET,value = "/getHostel/{id}")
	public ResponseEntity<Hostel> getHostelById(@PathVariable("id") int hostelId){
		Hostel hostel = hostelService.getHostelServiceById(hostelId);
		if(hostel == null) {
			throw new NoDataFoundException("data not found by hostelId :"+hostelId);
		}
		return new ResponseEntity<Hostel>(hostel,HttpStatus.OK);
	}
}
