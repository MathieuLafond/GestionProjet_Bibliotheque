package prj.facade.interfaces;

import java.util.List;

import prj.dto.MembreDTO;

public interface IMembreFacade extends IFacade {

	MembreDTO read(MembreDTO membreDTO);
	List<MembreDTO> getAll();
	
	void inscrire(MembreDTO membreDTO);
	void desinscrire(MembreDTO membreDTO);
	void modifier(MembreDTO membreDTO);
	
	List<MembreDTO> findByRetard();
	
}
