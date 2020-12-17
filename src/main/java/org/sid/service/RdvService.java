package org.sid.service;

import org.sid.form.RdvForm;

import org.sid.util.ResponseAPI;



public interface RdvService {
	
public ResponseAPI createRDV(RdvForm form);
	
	public ResponseAPI accepterRDV(Long id);
	
	

}
