package com.angelmedics.config;

import org.hibernate.cfg.DefaultNamingStrategy;
import org.hibernate.internal.util.StringHelper;



public class AngelMedicsNamingStrategy extends DefaultNamingStrategy{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	public String classToTableName(String className)
   {
	    return "HRYS_" +StringHelper.unqualify(className);
  }
}
