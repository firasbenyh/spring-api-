package org.sid.controller;

import org.sid.form.FormEmail;
import org.sid.form.LoginForm;
import org.sid.form.RegistryForm;
import org.sid.service.AppUserService;

import org.sid.util.ResponseAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	@Autowired 
	AppUserService appUserService;
	
	@GetMapping("/all")
	public ResponseAPI getAll() {
		return appUserService.getPetSitter();
	}
	
	
	
	
	@PostMapping("/petsitter/registry")
	public ResponseAPI registry(@RequestBody RegistryForm form) {
		return appUserService.registrypet(form);
	}
	
	@PostMapping("/client/registry")
	public ResponseAPI registryclt(@RequestBody RegistryForm form) {
		return appUserService.registryclt(form);
	}
	
	@PostMapping("/login")
	public ResponseAPI login(@RequestBody LoginForm form) {
		return appUserService.login(form);
	}
	
	@GetMapping("/petsitter/rdvs")
	public ResponseAPI getRdvsPS(@RequestBody FormEmail form ) {
		return appUserService.getAllRdvPetsitter(form.getEmail());
	}
	
	@GetMapping("/client/rdvs")
	public ResponseAPI getRdvsCLT(@RequestBody FormEmail form ) {
		return appUserService.getAllRdvClient(form.getEmail());
	}
	
	
	

}


