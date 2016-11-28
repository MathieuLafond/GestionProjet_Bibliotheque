package prj.dto;

import java.sql.Timestamp;

public class PretDTO {

	
	private String idPret;
	
	private MembreDTO membreDTO;
	
	private LivreDTO livreDTO;
	
	private Timestamp datePret;
	
	private Timestamp dateRetour;
	
	private Timestamp dateLimite;

	
	//getters/setters
	public String getIdPret() {
		return idPret;
	}

	public void setIdPret(String idPret) {
		this.idPret = idPret;
	}

	public MembreDTO getMembreDTO() {
		return membreDTO;
	}

	public void setIdMembre(MembreDTO membreDTO) {
		this.membreDTO = membreDTO;
	}

	public LivreDTO getIdLivre() {
		return livreDTO;
	}

	public void setIdLivre(LivreDTO livreDTO) {
		this.livreDTO = livreDTO;
	}

	public Timestamp getDatePret() {
		return datePret;
	}

	public void setDatePret(Timestamp datePret) {
		this.datePret = datePret;
	}

	public Timestamp getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Timestamp dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Timestamp getDateLimite() {
		return dateLimite;
	}

	public void setDateLimite(Timestamp dateLimite) {
		this.dateLimite = dateLimite;
	}

}
