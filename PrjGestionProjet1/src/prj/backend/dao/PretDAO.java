package prj.backend.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import prj.backend.dto.LivreDTO;
import prj.backend.dto.MembreDTO;
import prj.backend.dto.PretDTO;

public class PretDAO extends DAO<PretDTO>{

	public PretDAO(List<PretDTO> dtos) {
		super(dtos);
	}

	public List<PretDTO> findByMembre(MembreDTO membreDTO){
		ArrayList<PretDTO> retour = new ArrayList<>();
		List<PretDTO> prets = getAll();
		for(PretDTO pret : prets){
			if(pret.getMembreDTO().getIdMembre().equals(membreDTO.getIdMembre())){
				retour.add(pret);
			}
		}
		return retour;
	}
	public List<PretDTO> findByLivre(LivreDTO livreDTO){
		ArrayList<PretDTO> retour = new ArrayList<>();
		List<PretDTO> prets = getAll();
		for(PretDTO pret : prets){
			if(pret.getLivreDTO().getIdLivre().equals(livreDTO.getIdLivre())){
				retour.add(pret);
			}
		}
		return retour;
	}
	public List<PretDTO> findByRetard(){
		ArrayList<PretDTO> retour = new ArrayList<>();
		List<PretDTO> prets = getAll();
		for(PretDTO pret : prets){
			if(pret.getDateRetour()==null){
				if(pret.getDateLimite().before(new Timestamp(System.currentTimeMillis()))){
					retour.add(pret);
				}
			}
			else {
				if(pret.getDateLimite().before(pret.getDateRetour())){
					retour.add(pret);
				}
			}
		}
		return retour;
	}

}
