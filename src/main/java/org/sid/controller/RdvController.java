package org.sid.controller;

import org.sid.form.RdvForm;
import org.sid.service.RdvService;
import org.sid.util.ResponseAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rdv")
public class RdvController {
	
	@Autowired
	RdvService rdvService;
	
	
	@PostMapping("/create")
	public ResponseAPI create(@RequestBody RdvForm form) {
		return rdvService.createRDV(form);
				
	}
	
	@PatchMapping("/confirmed/{id}")
	public ResponseAPI confirmed(@PathVariable  Long id) {
		return rdvService.accepterRDV(id);
	}
	
	
	
	
	
	
	

}
