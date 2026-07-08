package com.e_comm.authservice.service;

import com.e_comm.authservice.dto.request.LoginRequest;
import com.e_comm.authservice.dto.request.UserRequest;
import com.e_comm.authservice.dto.response.AuthenticationResponse;
import com.e_comm.authservice.dto.response.UserResponse;

public interface AuthService {
	
	 UserResponse register(UserRequest request);

	 AuthenticationResponse login(LoginRequest request);

	    UserResponse getProfile(String email);

}
