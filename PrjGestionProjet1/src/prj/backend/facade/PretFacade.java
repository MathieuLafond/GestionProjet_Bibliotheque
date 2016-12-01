package prj.backend.facade;

import java.util.List;

import prj.backend.dao.PretDAO;
import prj.backend.dto.LivreDTO;
import prj.backend.dto.MembreDTO;
import prj.backend.dto.PretDTO;
import prj.backend.service.PretService;

public class PretFacade extends Facade<PretDTO,PretDAO,PretService>{

	public PretFacade(PretService service) {
		super(service);
	}

	public void creer(PretDTO pretDTO){
		getService().creer(pretDTO);
	}
	public void retourner(PretDTO pretDTO){
		getService().retourner(pretDTO);
	}
	public void payer(PretDTO pretDTO){
		getService().payer(pretDTO);
	}
	
	public double calculerFraisRetard(PretDTO pretDTO){
		return getService().calculerFraisRetard(pretDTO);
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
