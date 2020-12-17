package org.sid.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class RdvForm {
	

	private String dateDebut;
	private String dateFin;
	private String description;
	private String emailPetSitter;
	private String emailclient;
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmailPetSitter() {
		return emailPetSitter;
	}
	public void setEmailPetSitter(String emailPetSitter) {
		this.emailPetSitter = emailPetSitter;
	}
	public String getEmailclient() {
		return emailclient;
	}
	public void setEmailclient(String emailclient) {
		this.emailclient = emailclient;
	}
	
	

}
