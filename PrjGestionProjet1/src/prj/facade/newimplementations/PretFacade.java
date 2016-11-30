package prj.facade.newimplementations;

import java.util.List;

import prj.dao.newimplementations.PretDAO;
import prj.dto.LivreDTO;
import prj.dto.MembreDTO;
import prj.dto.PretDTO;
import prj.service.newimplementations.PretService;

public class PretFacade extends Facade<PretDTO,PretDAO,PretService>{

	public PretFacade(PretService service) {
		super(service);
	}

	void creer(PretDTO pretDTO){
		getService().creer(pretDTO);
	}
	void retourner(PretDTO pretDTO){
		getService().retourner(pretDTO);
	}
	void payer(PretDTO pretDTO){
		getService().payer(pretDTO);
	}
	
	double calculerFraisRetard(PretDTO pretDTO){
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
