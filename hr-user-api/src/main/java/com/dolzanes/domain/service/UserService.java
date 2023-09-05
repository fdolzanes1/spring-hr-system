package com.dolzanes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dolzanes.domain.entity.User;
import com.dolzanes.domain.exception.ObjectNotFoundException;
import com.dolzanes.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

	private final UserRepository userRepository;

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
}
