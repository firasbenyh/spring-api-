package org.sid.dao;

import java.util.List;

import org.sid.entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RdvRepository  extends JpaRepository<Rdv, Long>{
	
	@Query(value= "SELECT r.* FROM RDV  r , APP_USER  u WHERE  r.petsitter_id=u.id AND u.email = ?1", nativeQuery = true)
	public List<Rdv> getAllRdvByPetSitter(String email);
	
	@Query(value= "SELECT r.* FROM RDV  r , APP_USER  u WHERE  r.client_id=u.id AND u.email = ?1", nativeQuery = true)
	public List<Rdv> getAllRdvByClient(String email);

}
