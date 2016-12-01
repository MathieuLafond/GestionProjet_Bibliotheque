package prj.backend.dto;

public class MembreDTO extends DTO{
	
	private String idMembre;
	
	private String prenom;
	
	private String nom;
	
	private String adresse;
	
	private String codePostal;
	
	private String telephone;
	
	private String courriel;
	
	private String limitePret;
	
	
	// getters/setters
	public String getIdMembre() {
		return idMembre;
	}

	public void setIdMembre(String idMembre) {
		this.idMembre = idMembre;
		setId(idMembre);
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getLimitePret() {
		return limitePret;
	}

	public void setLimitePret(String limitePret) {
		this.limitePret = limitePret;
	}
	
	
	
}
