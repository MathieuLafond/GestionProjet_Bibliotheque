package prj.backend.facade;

import prj.backend.dao.CategorieDAO;
import prj.backend.dto.CategorieDTO;
import prj.backend.service.CategorieService;

public class CategorieFacade extends Facade<CategorieDTO,CategorieDAO,CategorieService>{
	
	public CategorieFacade(CategorieService service){
		super(service);
	}
	
	public void ajouter(CategorieDTO categorieDTO){
		getService().ajouter(categorieDTO);
	}
	
	public void supprimer(CategorieDTO categorieDTO){
		getService().supprimer(categorieDTO);
	}
	
}