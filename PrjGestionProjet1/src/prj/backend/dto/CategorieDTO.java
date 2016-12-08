package prj.backend.dto;

public class CategorieDTO extends DTO {

	private String idCategorie;
	
	private String nomCategorie;
	
	
	//getters/setters
	@Override
	public void setId(String id){
		this.idCategorie = id;
		super.setId(id);
	}
	
	public String getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
		super.setId(idCategorie);
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String stock() {
		return getIdCategorie()+";"+getNomCategorie();
	}
	
	public String toString(){
		return nomCategorie;
	}
	
	
}
