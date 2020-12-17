package org.sid.service;

import javax.transaction.Transactional;

import org.sid.dao.RdvRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.AppUser;
import org.sid.entities.Rdv;
import org.sid.form.RdvForm;
import org.sid.util.ResponseAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RdvServiceImpl implements RdvService{

	
	
	@Autowired
	RdvRepository rdvRepository;
	
	@Autowired
	UserRepository userRepository;
	
	ResponseAPI response;
	
	
	@Override
	public ResponseAPI createRDV(RdvForm form) {
		 response = new ResponseAPI();
		
		Rdv rdv =new Rdv();
		

		rdv.setDateDebut(form.getDateDebut());
		rdv.setDateFin(form.getDateFin());
		
		rdv.setDescription(form.getDescription());
		rdv.setConfirmed(false);
		
		AppUser petsitter=userRepository.LoadUserByEmail(form.getEmailPetSitter());
		AppUser client=userRepository.LoadUserByEmail(form.getEmailclient());
		rdv.setPetsitter(petsitter);
		rdv.setClient(client);
		System.out.println(client.toString());
		
		response.setStatus(200);
		response.setData(rdvRepository.save(rdv));
		response.setError(null);
		
		
		return response;
	}

	@Override
	public ResponseAPI accepterRDV(Long id) {
		Rdv rdv=rdvRepository.findById(id).get();
		rdv.setConfirmed(true);
		 response = new ResponseAPI();
		 response.setStatus(200);
		 response.setData(rdv);
		return response;
	}

	

}
