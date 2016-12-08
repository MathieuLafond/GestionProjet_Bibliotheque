package prj.backend.dto;

import java.sql.Timestamp;

public class PretDTO extends DTO {

	
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
		setId(idPret);
	}

	public MembreDTO getMembreDTO() {
		return membreDTO;
	}

	public void setMembreDTO(MembreDTO membreDTO) {
		this.membreDTO = membreDTO;
	}

	public LivreDTO getLivreDTO() {
		return livreDTO;
	}

	public void setLivreDTO(LivreDTO livreDTO) {
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
	
	public String stock() {
		String date = "0";
		if(dateRetour!=null){
			date=""+dateRetour.getTime();
		}
		return idPret+";"+membreDTO.getIdMembre()+";"+livreDTO.getIdLivre()+";"+datePret.getTime()+";"+date+";"+dateLimite.getTime();
	}

}
