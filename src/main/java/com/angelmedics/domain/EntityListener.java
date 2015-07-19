package com.angelmedics.domain;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class EntityListener {
    @PrePersist
	public void Persist(BaseDomain domain)
	{
    	domain.setModifiedDate(new Date(System.currentTimeMillis()));
	}
    
    @PreUpdate
	public void preUpdate(BaseDomain domain)
	{
    	domain.setModifiedDate(new Date(System.currentTimeMillis()));
	}
}
