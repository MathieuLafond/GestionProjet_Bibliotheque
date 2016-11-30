package prj.dao.newimplementations;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;


import prj.dto.LivreDTO;

public class LivreDAO extends DAO<LivreDTO> {

	public LivreDAO(List<LivreDTO> dtos){
		super(dtos);
	}
	
	public void deleteAllInCategorie(String idCategorie){
		List<LivreDTO> newList = Collections.emptyList();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(!idCategorie.equals(livre.getCategorieDTO())){
				newList.add(livre);
			}
		}
		replace(newList);
	}
	
	public List<LivreDTO> findByTitre(String titre){
		List<LivreDTO> retour = Collections.emptyList();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getTitre().contains(titre)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByAuteur(String auteur){
		List<LivreDTO> retour = Collections.emptyList();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getAuteur().contains(auteur)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByEditeur(String editeur){
		List<LivreDTO> retour = Collections.emptyList();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getEditeur().contains(editeur)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByLangue(String langue){
		List<LivreDTO> retour = Collections.emptyList();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getLangue().contains(langue)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByCategorie(String categorie){
		List<LivreDTO> retour = Collections.emptyList();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getCategorieDTO().getIdCategorie().contains(categorie)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByEmplacement(String emplacement){
		List<LivreDTO> retour = Collections.emptyList();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getEmplacement().contains(emplacement)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByDateParution(Timestamp dateParution){
		List<LivreDTO> retour = Collections.emptyList();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getDateParution().equals(dateParution)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByForm(LivreDTO livreDTO){
		List<LivreDTO> retour = Collections.emptyList();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(		   livre.getTitre().contains(livreDTO.getTitre())
					&& livre.getAuteur().contains(livreDTO.getAuteur())
					&& livre.getEditeur().contains(livreDTO.getEditeur())
					&& livre.getLangue().contains(livreDTO.getLangue())
					&& livre.getEmplacement().contains(livreDTO.getEmplacement())
					&& livre.getCategorieDTO().getNomCategorie().contains(livreDTO.getCategorieDTO().getNomCategorie())){
				retour.add(livre);
			}
		}
		return retour;
	}
	
}
