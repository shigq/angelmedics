package com.angelmedics.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.angelmedics.domain.bean.Patient;


/**
 * <b> </b>
 * <p>
 * 功能:
 * </p>
 * 
 * @作者 stone
 * @创建时间 2015年7月19日 上午10:16:12
 * @修改内容
 * @修改时间
 */
public interface PatientRepository extends CrudRepository<Patient, String>{
	
	@Query("from Patient p where p.usercode=?1 and p.password=?2 ")
	public Patient findPatient(String usercode, String password);

}
