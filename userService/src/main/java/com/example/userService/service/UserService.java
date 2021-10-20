package com.example.userService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userService.VO.Department;
import com.example.userService.VO.ResponseTemplateVO;
import com.example.userService.entity.User;
import com.example.userService.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		
		log.info("Inside saveUser method in UserService ");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(int userId) {
		log.info("Inside getUserWithDepartment method in UserService ");

		ResponseTemplateVO vo=new ResponseTemplateVO();
		User user =userRepository.findByUserId(userId);
		
		
		Department department= 
				restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		
		return vo;
	}
}
