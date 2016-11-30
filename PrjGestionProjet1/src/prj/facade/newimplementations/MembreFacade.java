package prj.facade.newimplementations;

import prj.dao.newimplementations.MembreDAO;
import prj.dto.MembreDTO;
import prj.service.newimplementations.MembreService;

public class MembreFacade extends Facade<MembreDTO,MembreDAO,MembreService>{

	public MembreFacade(MembreService service) {
		super(service);
	}
	
	void inscrire(MembreDTO membreDTO){
		create(membreDTO);
	}
	void desinscrire(MembreDTO membreDTO){
		delete(membreDTO);
	}
	void modifier(MembreDTO membreDTO){
		update(membreDTO);
	}
	
}
