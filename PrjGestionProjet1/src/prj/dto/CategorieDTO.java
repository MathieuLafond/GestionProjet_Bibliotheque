package prj.dto;

public class CategorieDTO extends DTO {

	private String idCategorie;
	
	private String nomCategorie;
	
	
	//getters/setters
	public String getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
		setId(idCategorie);
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	
	
}
