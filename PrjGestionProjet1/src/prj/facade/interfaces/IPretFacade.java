package prj.facade.interfaces;

import java.util.List;

import prj.dto.PretDTO;

public interface IPretFacade extends IFacade {
	
	PretDTO read(PretDTO pretDTO);
	List<PretDTO> getAll();
	
	void creer(PretDTO pretDTO);
	void retourner(PretDTO pretDTO);
	
	List<PretDTO> findByMembre();
	List<PretDTO> findByLivre();
	List<PretDTO> findByRetard();
}
