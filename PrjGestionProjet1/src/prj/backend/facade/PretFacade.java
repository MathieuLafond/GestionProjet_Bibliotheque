package prj.backend.facade;

import java.util.List;

import prj.backend.dao.PretDAO;
import prj.backend.dto.LivreDTO;
import prj.backend.dto.MembreDTO;
import prj.backend.dto.PretDTO;
import prj.backend.exception.FacadeException;
import prj.backend.exception.ServiceException;
import prj.backend.service.PretService;

public class PretFacade extends Facade<PretDTO,PretDAO,PretService>{

	public PretFacade(PretService service) {
		super(service);
	}

	public void creer(PretDTO pretDTO) throws FacadeException{
		try {
			getService().creer(pretDTO);
		} catch (ServiceException exception) {
			throw new FacadeException(exception);
		}
	}
	public void retourner(PretDTO pretDTO) throws FacadeException{
		try {
			getService().retourner(pretDTO);
		} catch (ServiceException exception) {
			throw new FacadeException(exception);
		}
	}
	public void payer(PretDTO pretDTO) throws FacadeException{
		try {
			getService().payer(pretDTO);
		} catch (ServiceException exception) {
			throw new FacadeException(exception);
		}
	}
	
	public double calculerFraisRetard(PretDTO pretDTO) throws FacadeException{
		try {
			return getService().calculerFraisRetard(pretDTO);
		} catch (ServiceException exception) {
			throw new FacadeException(exception);
		}
	}
	
	public List<PretDTO> findByMembre(MembreDTO membreDTO){
		return getService().findByMembre(membreDTO);
	}
	public List<PretDTO> findByLivre(LivreDTO livreDTO){
		return getService().findByLivre(livreDTO);
	}
	public List<PretDTO> findByRetard(){
		return getService().findByRetard();
	}

}
