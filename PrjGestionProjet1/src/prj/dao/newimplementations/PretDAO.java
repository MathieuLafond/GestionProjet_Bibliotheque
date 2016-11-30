package prj.dao.newimplementations;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import prj.dto.LivreDTO;
import prj.dto.MembreDTO;
import prj.dto.PretDTO;

public class PretDAO extends DAO<PretDTO>{

	public PretDAO(List<PretDTO> dtos) {
		super(dtos);
	}

	public List<PretDTO> findByMembre(MembreDTO membreDTO){
		List<PretDTO> prets = getAll();
		List<PretDTO> retour = Collections.emptyList();
		for(PretDTO pret : prets){
			if(pret.getMembreDTO().getIdMembre()==membreDTO.getIdMembre()){
				retour.add(pret);
			}
		}
		return retour;
	}
	public List<PretDTO> findByLivre(LivreDTO livreDTO){
		List<PretDTO> prets = getAll();
		List<PretDTO> retour = Collections.emptyList();
		for(PretDTO pret : prets){
			if(pret.getLivreDTO().getIdLivre()==livreDTO.getIdLivre()){
				retour.add(pret);
			}
		}
		return retour;
	}
	public List<PretDTO> findByRetard(){
		List<PretDTO> prets = getAll();
		List<PretDTO> retour = Collections.emptyList();
		for(PretDTO pret : prets){
			if(pret.getDateRetour()==null){
				if(pret.getDateLimite().compareTo(new Timestamp(System.currentTimeMillis()))<0){
					retour.add(pret);
				}
			}
			else {
				if(pret.getDateLimite().compareTo(pret.getDateRetour())<0){
					retour.add(pret);
				}
			}
		}
		return retour;
	}

}
