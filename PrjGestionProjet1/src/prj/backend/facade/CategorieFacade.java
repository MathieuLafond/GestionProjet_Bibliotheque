package prj.backend.facade;

import prj.backend.dao.CategorieDAO;
import prj.backend.dto.CategorieDTO;
import prj.backend.exception.FacadeException;
import prj.backend.exception.ServiceException;
import prj.backend.service.CategorieService;

public class CategorieFacade extends Facade<CategorieDTO,CategorieDAO,CategorieService>{
	
	public CategorieFacade(CategorieService service){
		super(service);
	}
	
	public void ajouter(CategorieDTO categorieDTO) throws FacadeException{
		try {
			getService().ajouter(categorieDTO);
		} catch (ServiceException exception) {
			throw new FacadeException(exception);
		}
	}
	
	public void supprimer(CategorieDTO categorieDTO) throws FacadeException{
		try {
			getService().supprimer(categorieDTO);
		} catch (ServiceException exception) {
			throw new FacadeException(exception);
		}
	}
	
}
