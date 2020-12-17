package org.sid.service;

import java.util.ArrayList;
import java.util.List;

import org.sid.dao.RdvRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.AppUser;
import org.sid.form.LoginForm;
import org.sid.form.RegistryForm;
import org.sid.util.ResponseAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl  implements AppUserService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	RdvRepository rdvRepository;
	ResponseAPI responseAPI;
	@Override
	public ResponseAPI login(LoginForm form) {
		AppUser user = userRepository.getUserByEmailAndPassword(form.getEmail(), form.getPassword());
		responseAPI = new ResponseAPI();
		if(user==null) {
			responseAPI.setStatus(404);
			responseAPI.setError("not found");
			
			
		}else {
			
				responseAPI.setStatus(200);
				responseAPI.setData(user);
			
		}
		return responseAPI;
	}

	@Override
	public ResponseAPI registrypet(RegistryForm form) {
		AppUser user = userRepository.LoadUserByEmail(form.getEmail());
		responseAPI = new ResponseAPI();
		if( user !=null) {
			responseAPI.setStatus(500);
			responseAPI.setError("already exist");
		}else {
			AppUser user2= new AppUser();
			user2.setActived(true);
			user2.setPetsitter(true);
			user2.setClient(false);
			user2.setNom(form.getNom());
			user2.setPrenom(form.getPrenom());
			user2.setNumTel(form.getNumTel());
			user2.setEmail(form.getEmail());
			user2.setPassword(form.getPassword());
			responseAPI.setData(userRepository.save(user2));
			responseAPI.setStatus(200);
			
		}
		return responseAPI;
	}

	
	public ResponseAPI registryclt(RegistryForm form) {
		AppUser user = userRepository.LoadUserByEmail(form.getEmail());
		responseAPI = new ResponseAPI();
		if( user !=null) {
			responseAPI.setStatus(500);
			responseAPI.setError("already exist");
		}else {
			AppUser user2= new AppUser();
			user2.setActived(true);
			user2.setPetsitter(false);
			user2.setClient(true);
			user2.setNom(form.getNom());
			user2.setPrenom(form.getPrenom());
			user2.setNumTel(form.getNumTel());
			user2.setEmail(form.getEmail());
			user2.setPassword(form.getPassword());
			responseAPI.setData(userRepository.save(user2));
			responseAPI.setStatus(200);
			
		}
		return responseAPI;
	}

	@Override
	public ResponseAPI getPetSitter() {
		
		ResponseAPI responseAPI= new ResponseAPI();
		
		responseAPI.setStatus(200);
		responseAPI.setData(userRepository.getAllPet());
		return responseAPI;
		
	}

	@Override
	public ResponseAPI getAllRdvPetsitter(String email) {
		responseAPI = new ResponseAPI();
		responseAPI.setData(rdvRepository.getAllRdvByPetSitter(email));
		return responseAPI;
	}

	@Override
	public ResponseAPI getAllRdvClient(String email) {
		responseAPI = new ResponseAPI();
		responseAPI.setData(rdvRepository.getAllRdvByClient(email));
		return responseAPI;
	}

}
