package prj.backend.service;

import prj.backend.dao.CategorieDAO;
import prj.backend.dto.CategorieDTO;

public class CategorieService extends Service<CategorieDTO,CategorieDAO>{
	
	public CategorieService(CategorieDAO dao){
		super(dao);
	}

	public void ajouter(CategorieDTO categorieDTO) {
		create(categorieDTO);
	}

	public void supprimer(CategorieDTO categorieDTO) {
		delete(categorieDTO);//TODO vérifications
	}
	
}
