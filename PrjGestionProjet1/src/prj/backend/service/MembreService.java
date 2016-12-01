package prj.backend.service;

import prj.backend.dao.MembreDAO;
import prj.backend.dto.MembreDTO;

public class MembreService extends Service<MembreDTO,MembreDAO>{

	public MembreService(MembreDAO dao) {
		super(dao);
	}
	
	public void inscrire(MembreDTO membreDTO){
		create(membreDTO);
	}
	public void desinscrire(MembreDTO membreDTO){
		delete(membreDTO);//TODO vérifications
	}
	public void modifier(MembreDTO membreDTO){
		update(membreDTO);
	}
	
}
