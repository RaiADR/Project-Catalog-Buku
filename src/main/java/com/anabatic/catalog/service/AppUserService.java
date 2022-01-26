package com.anabatic.catalog.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.anabatic.catalog.dto.UserDetailResponseDTO;

public interface AppUserService extends UserDetailsService {
	
	public UserDetailResponseDTO findUserDetail();

}
