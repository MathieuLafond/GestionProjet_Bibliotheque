package prj.backend.dto;

import java.sql.Timestamp;

public class LivreDTO extends DTO {
	
	private String idLivre;
	
	private CategorieDTO categorie;
	
	private String titre;
	
	private String auteur;
	
	private String editeur;
	
	private String langue;
	
	private Timestamp dateParution;
	
	private String emplacement;
	
	
	//getters/setters
	@Override
	public void setId(String id){
		this.idLivre = id;
		super.setId(id);
	}
	
	public String getIdLivre() {
		return idLivre;
	}
	
	public void setIdLivre(String idLivre) {
		this.idLivre = idLivre;
		super.setId(idLivre);
	}

	public CategorieDTO getCategorieDTO() {
		return categorie;
	}

	public void setCategorieDTO(CategorieDTO categorie) {
		this.categorie = categorie;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public Timestamp getDateParution() {
		return dateParution;
	}

	public void setDateParution(Timestamp dateParution) {
		this.dateParution = dateParution;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String stock() {
		return idLivre+";"+categorie.getIdCategorie()+";"+titre+";"+auteur+";"+editeur+";"+langue+";"+dateParution.getTime()+";"+emplacement;
	}
	
	
	
}
