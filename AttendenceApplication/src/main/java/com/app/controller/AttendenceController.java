package com.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AttendenceDto;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.Converterdto;
import com.app.dto.Response;
import com.app.dto.UserDto;
import com.app.pojo.Attendence;
import com.app.pojo.User;
import com.app.service.AttendenceService;
import com.app.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/attendence")
public class AttendenceController {

	@Autowired
	public AttendenceService attendenceService;
	
	@Autowired
	public ModelMapper mapper;
	
	Converterdto con;
	
	@GetMapping("/signin/{id}")
	public String signup(@PathVariable("id") int id) throws ParseException 
	{
		
		
	    Attendence at  = attendenceService.addAttendenceSignInTime(id);
		if(at!=null)
		     return  "user signin data successfully";	
		return null;
	}
	
	@GetMapping("/signout/{id}")
	public String signout(@PathVariable("id") int id) throws ParseException {
		    
		    Attendence at = attendenceService.addAttendenceSignOutInTime(id);
		    if(at != null)
			return "user signout data successfully";	
		    
		    return null;
	}
	
	@GetMapping("allAttendence/{id}")
	public ResponseEntity<?> getAllUser(@PathVariable("id") int id){
		  List<Attendence> list = attendenceService.findAllAtendenceById(id);
		  System.out.println("inside Attendences Controller : "+list.toString());
		  return Response.success(list);
	}
	
	
}
