package com.angelmedics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angelmedics.domain.bean.Patient;
import com.angelmedics.repository.PatientRepository;

/**
 * <b> </b>
 * <p>
 * 功能:患者请求控制类
 * </p>
 * 
 * @作者 stone
 * @创建时间 2015年7月19日 上午10:12:01
 * @修改内容
 * @修改时间
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientRepository repo;
	
	@RequestMapping("/login")
	public boolean login(String usercode, String password) {
		if (repo.findPatient(usercode, password) != null) 
			return true;
		return false;
	}
	
	
	@RequestMapping("/register")
	public Patient register(Patient vo) {
		return repo.save(vo);
	}

}
