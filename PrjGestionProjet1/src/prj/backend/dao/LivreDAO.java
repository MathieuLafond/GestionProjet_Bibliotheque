package prj.backend.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import prj.backend.dto.CategorieDTO;
import prj.backend.dto.LivreDTO;

public class LivreDAO extends DAO<LivreDTO> {

	public LivreDAO(List<LivreDTO> dtos){
		super(dtos);
	}
	
	public void deleteAllInCategorie(CategorieDTO categorie){
		ArrayList<LivreDTO> newList = new ArrayList<>();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(!categorie.equals(livre.getCategorieDTO())){
				newList.add(livre);
			}
		}
		replace(newList);
	}
	
	public List<LivreDTO> findByTitre(String titre){
		ArrayList<LivreDTO> retour = new ArrayList<>();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getTitre().contains(titre)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByAuteur(String auteur){
		ArrayList<LivreDTO> retour = new ArrayList<>();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getAuteur().contains(auteur)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByEditeur(String editeur){
		ArrayList<LivreDTO> retour = new ArrayList<>();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getEditeur().contains(editeur)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByLangue(String langue){
		ArrayList<LivreDTO> retour = new ArrayList<>();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getLangue().contains(langue)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByCategorie(CategorieDTO categorie){
		ArrayList<LivreDTO> retour = new ArrayList<>();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getCategorieDTO().getIdCategorie().equals(categorie.getIdCategorie())){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByEmplacement(String emplacement){
		ArrayList<LivreDTO> retour = new ArrayList<>();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getEmplacement().contains(emplacement)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByDateParution(Timestamp dateParution){
		ArrayList<LivreDTO> retour = new ArrayList<>();
		List<LivreDTO> livres = getAll();
		for(LivreDTO livre : livres){
			if(livre.getDateParution().equals(dateParution)){
				retour.add(livre);
			}
		}
		return retour;
	}
	public List<LivreDTO> findByForm(LivreDTO livreDTO){
		ArrayList<LivreDTO> retour = new ArrayList<>();
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
