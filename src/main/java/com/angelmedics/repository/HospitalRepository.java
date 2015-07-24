package com.angelmedics.repository;

import org.springframework.data.repository.CrudRepository;

import com.angelmedics.domain.bean.Hospital;


/**
 * <b> </b>
 * <p>
 * 功能:
 * </p>
 * 
 * @作者 stone
 * @创建时间 2015年7月23日 下午10:27:50
 * @修改内容
 * @修改时间
 */
public interface HospitalRepository extends CrudRepository<Hospital, String> {

}
