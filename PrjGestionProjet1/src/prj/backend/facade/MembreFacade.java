package prj.backend.facade;

import prj.backend.dao.MembreDAO;
import prj.backend.dto.MembreDTO;
import prj.backend.service.MembreService;

public class MembreFacade extends Facade<MembreDTO,MembreDAO,MembreService>{

	public MembreFacade(MembreService service) {
		super(service);
	}
	
	public void inscrire(MembreDTO membreDTO){
		getService().inscrire(membreDTO);
	}
	public void desinscrire(MembreDTO membreDTO){
		getService().desinscrire(membreDTO);
	}
	public void modifier(MembreDTO membreDTO){
		getService().modifier(membreDTO);
	}
	
}
