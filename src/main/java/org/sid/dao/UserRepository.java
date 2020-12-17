package org.sid.dao;

import java.util.List;

import org.sid.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface UserRepository  extends JpaRepository<AppUser, Long>{
	
	@Query(value="Select * from app_user where email = ?1", nativeQuery = true)
	public AppUser LoadUserByEmail(String email);
	
	@Query(value="Select * from app_user where petsitter = true", nativeQuery = true)
	public List<AppUser> getAllPet();
	
	@Query(value = "SELECT * FROM app_user  WHERE email = ?1 and password = ?2", nativeQuery = true)
	public AppUser  getUserByEmailAndPassword(String email, String password);

}
