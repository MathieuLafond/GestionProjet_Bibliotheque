package prj.backend.facade;

import java.sql.Timestamp;
import java.util.List;

import prj.backend.dao.LivreDAO;
import prj.backend.dto.LivreDTO;
import prj.backend.exception.FacadeException;
import prj.backend.exception.ServiceException;
import prj.backend.service.LivreService;

public class LivreFacade extends Facade<LivreDTO,LivreDAO,LivreService> {

	public LivreFacade(LivreService service){
		super(service);
	}
	
	public void acquerir(LivreDTO livreDTO){
		getService().acquerir(livreDTO);
	}
	public void vendre(LivreDTO livreDTO) throws FacadeException{
		try {
			getService().vendre(livreDTO);
		} catch (ServiceException exception) {
			throw new FacadeException(exception);
		}
	}
	
	public void deleteAllInCategorie(String idCategorie) throws FacadeException{
		try{
			getService().deleteAllInCategorie(idCategorie);
		} catch (ServiceException exception) {
			throw new FacadeException(exception);
		}
		
	}
	
	public List<LivreDTO> findByTitre(String titre){
		return getService().findByTitre(titre);
	}
	public List<LivreDTO> findByAuteur(String auteur){
		return getService().findByAuteur(auteur);
	}
	public List<LivreDTO> findByEditeur(String editeur){
		return getService().findByEditeur(editeur);
	}
	public List<LivreDTO> findByLangue(String langue){
		return getService().findByLangue(langue);
	}
	public List<LivreDTO> findByCategorie(String idCategorie){
		return getService().findByCategorie(idCategorie);
	}
	public List<LivreDTO> findByEmplacement(String emplacement){
		return getService().findByEmplacement(emplacement);
	}
	public List<LivreDTO> findByDateParution(Timestamp dateParution){
		return getService().findByDateParution(dateParution);
	}
	public List<LivreDTO> findByForm(LivreDTO livreDTO){
		return getService().findByForm(livreDTO);
	}
	
}
