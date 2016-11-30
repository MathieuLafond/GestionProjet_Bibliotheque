package prj.service.newimplementations;

import prj.dao.newimplementations.CategorieDAO;
import prj.dto.CategorieDTO;

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
