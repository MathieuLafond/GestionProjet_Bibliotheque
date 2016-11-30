package prj.facade.newimplementations;

import prj.dao.newimplementations.CategorieDAO;
import prj.dto.CategorieDTO;
import prj.service.newimplementations.CategorieService;

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
