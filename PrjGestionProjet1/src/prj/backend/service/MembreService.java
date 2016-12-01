package prj.backend.service;

import java.util.List;

import prj.backend.dao.MembreDAO;
import prj.backend.db.Database;
import prj.backend.dto.MembreDTO;
import prj.backend.dto.PretDTO;
import prj.backend.exception.ServiceException;

public class MembreService extends Service<MembreDTO,MembreDAO>{

	public MembreService(MembreDAO dao) {
		super(dao);
	}
	
	public void inscrire(MembreDTO membreDTO){
		create(membreDTO);
	}
	public void desinscrire(MembreDTO membreDTO) throws ServiceException{
		MembreDTO membre = read(membreDTO.getIdMembre());
		List<PretDTO> prets = Database.getPrets();
		for(PretDTO pret : prets){
			if(pret.getMembreDTO().equals(membre)){
				throw new ServiceException("Erreur : le membre a des prêts en cours");
			}
		}
		delete(membre);
	}
	public void modifier(MembreDTO membreDTO){
		update(membreDTO);
	}
	
}
