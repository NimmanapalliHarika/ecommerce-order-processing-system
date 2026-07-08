package com.e_comm.authservice.mapper;

import org.springframework.stereotype.Component;

import com.e_comm.authservice.dto.request.UserRequest;
import com.e_comm.authservice.dto.response.UserResponse;
import com.e_comm.authservice.entity.User;

@Component
public class UserMapper {
	
	public User toEntity(UserRequest request) {
		
		if(request==null) {
			return null;
		}
		User user=new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setRole(request.getRole());
		return user;
		
	}
	
public UserResponse toResponse(User user) {
		
		if(user==null) {
			return null;
		}
		UserResponse response=new UserResponse();
		response.setUserId(user.getUserId());
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setEmail(user.getEmail());
		response.setPassword(user.getPassword());
		response.setPhoneNumber(user.getPhoneNumber());
		response.setRole(user.getRole());
		response.setCreatedAt(user.getCreatedAt());
		response.setLastupdatedAt(user.getLastupdatedAt());
		return response;
		
	}


}
