package prj.service.newimplementations;

import java.util.List;

import prj.dao.newimplementations.PretDAO;
import prj.dto.LivreDTO;
import prj.dto.MembreDTO;
import prj.dto.PretDTO;

public class PretService extends Service<PretDTO,PretDAO>{

	public PretService(PretDAO dao) {
		super(dao);
	}

	public void creer(PretDTO pretDTO){
		create(pretDTO);//TODO vérifications
	}
	public void retourner(PretDTO pretDTO){
		update(pretDTO);//TODO vérifications+...
		delete(pretDTO);
	}
	public void payer(PretDTO pretDTO){
		delete(pretDTO);
	}
	
	public double calculerFraisRetard(PretDTO pretDTO){
		return 0;//TODO
	}
	
	public List<PretDTO> findByMembre(MembreDTO membreDTO){
		return getDAO().findByMembre(membreDTO);
	}
	public List<PretDTO> findByLivre(LivreDTO livreDTO){
		return getDAO().findByLivre(livreDTO);
	}
	public List<PretDTO> findByRetard(){
		return getDAO().findByRetard();
	}

}
