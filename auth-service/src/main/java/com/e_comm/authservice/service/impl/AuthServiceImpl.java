package com.e_comm.authservice.service.impl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e_comm.authservice.dto.request.LoginRequest;
import com.e_comm.authservice.dto.request.UserRequest;
import com.e_comm.authservice.dto.response.AuthenticationResponse;
import com.e_comm.authservice.dto.response.UserResponse;
import com.e_comm.authservice.entity.User;
import com.e_comm.authservice.exception.InvalidCredentialsException;
import com.e_comm.authservice.exception.UserAlreadyExistsException;
import com.e_comm.authservice.exception.UserNotFoundException;
import com.e_comm.authservice.mapper.UserMapper;
import com.e_comm.authservice.repository.UserRepository;
import com.e_comm.authservice.security.JwtService;
import com.e_comm.authservice.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	
	public AuthServiceImpl(UserRepository userRepository, UserMapper userMapper,PasswordEncoder passwordEncoder,JwtService jwtService) {
		this.userRepository=userRepository;
		this.userMapper=userMapper;
		this.passwordEncoder=passwordEncoder;
		this.jwtService = jwtService;
		
	}
    @Transactional
    @Override
	public UserResponse register(UserRequest request) {
		if(userRepository.existsByEmail(request.getEmail())) {
			throw new UserAlreadyExistsException("User already exist with this"+request.getEmail());
		}
		
		User user=userMapper.toEntity(request);
		user.setPassword(
		        passwordEncoder.encode(request.getPassword()));
		User saveUser=userRepository.save(user);
		UserResponse response=userMapper.toResponse(saveUser);
		return response;
		
	}

	@Override
	public AuthenticationResponse login(LoginRequest request){
		User res=userRepository.findByEmail(request.getEmail()).orElseThrow(()->new InvalidCredentialsException("UserName not found"));
		
			if(!passwordEncoder.matches(
			        request.getPassword(),
			        res.getPassword())){
				throw new InvalidCredentialsException("Invalid username and password");
			}
		else {
			String token = jwtService.generateToken(res);

			AuthenticationResponse response = new AuthenticationResponse();
			response.setToken(token);
			response.setUser(userMapper.toResponse(res));

			return response;
		}
	
		 
	}

	@Override
	@Transactional(readOnly = true)
	public UserResponse getProfile(String email) {
		User res=userRepository.findByEmail(email).orElseThrow(()->new UserNotFoundException("UserName not found"));
		// TODO Auto-generated method stub
		UserResponse response=userMapper.toResponse(res);
		return response;
	}

}
