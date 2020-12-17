package org.sid;

import org.sid.dao.UserRepository;
import org.sid.entities.AppUser;
import org.sid.form.RdvForm;
import org.sid.service.AppUserService;
import org.sid.service.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PetSitterApiApplication {

	
	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(PetSitterApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(RdvService rdvService){
		return args->{
			AppUser user =new AppUser();
			user.setNom("Gallali");
			user.setPrenom("Saif");
			user.setEmail("saif@gmail.com");
			user.setPassword("1234");
			user.setNumTel("54204652");
			user.setPetsitter(true);
			user.setActived(true);
			
			
			userRepository.save(user);
			AppUser user1 =new AppUser();
			user1.setNom("Admin");
			user1.setPrenom("Admin");
			user1.setEmail("admin@gmail.com");
			user1.setPassword("1234");
			user1.setNumTel("54204652");
			user1.setPetsitter(false);
			user1.setActived(true);
			userRepository.save(user1);
			
			AppUser client =new AppUser();
			client.setNom("Client");
			client.setPrenom("Client");
			client.setEmail("client@gmail.com");
			client.setPassword("1234");
			client.setNumTel("54204652");
			client.setPetsitter(false);
			client.setClient(true);
			client.setActived(true);
			userRepository.save(client);
			
			RdvForm fr=new RdvForm();
			
			fr.setDateDebut("11/11/2020");		
			fr.setDateFin("12/11/2020");
			fr.setEmailPetSitter("saif@gmail.com");
			fr.setEmailclient("client@gmail.com");
			
			rdvService.createRDV(fr);
			
		};
	}

}
