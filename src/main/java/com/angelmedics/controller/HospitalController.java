package com.angelmedics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angelmedics.domain.bean.Hospital;
import com.angelmedics.repository.HospitalRepository;
/**
 * <b> </b>
 * <p>
 * 功能:医院控制器
 * </p>
 * 
 * @作者 stone
 * @创建时间 2015年7月23日 下午10:26:14
 * @修改内容
 * @修改时间
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalRepository repo;
	
	@RequestMapping("/query")
	public Iterable<Hospital> findAll() {
		return repo.findAll();
	}

}
