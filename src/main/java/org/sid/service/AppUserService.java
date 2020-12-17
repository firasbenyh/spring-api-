package org.sid.service;

import java.util.List;

import org.sid.form.LoginForm;
import org.sid.form.RegistryForm;
import org.sid.util.ResponseAPI;
import org.springframework.data.jpa.repository.Query;

public interface AppUserService {
	public ResponseAPI login(LoginForm form);
	public ResponseAPI registrypet(RegistryForm form);
	public ResponseAPI registryclt(RegistryForm form);
	//public void addSpecialiteToDoctor(String email,String specialiteTitle);
	public ResponseAPI getPetSitter();
	
	public ResponseAPI getAllRdvPetsitter(String email);
	public ResponseAPI getAllRdvClient(String email);
	

}
