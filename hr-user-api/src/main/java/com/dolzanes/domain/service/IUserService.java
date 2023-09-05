package com.dolzanes.domain.service;

import java.util.List;

import com.dolzanes.domain.entity.User;

public interface IUserService {
	User findById(Long id);
	List<User> findAll();
}
