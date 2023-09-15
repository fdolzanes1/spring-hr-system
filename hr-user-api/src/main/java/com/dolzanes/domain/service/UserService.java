package com.dolzanes.domain.service;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.dolzanes.domain.entity.User;
import com.dolzanes.domain.exception.ObjectNotFoundException;
import com.dolzanes.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService implements IUserService {

	private final Environment env;
	private final UserRepository userRepository;

	@Override
	public User findById(Long id) {
		log.info("USER_SERVICE ::: Get Request on "+ env.getProperty("local.server.port")+" port.");
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
}
