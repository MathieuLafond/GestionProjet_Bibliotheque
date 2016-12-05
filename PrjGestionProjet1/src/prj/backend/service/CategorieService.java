package prj.backend.service;

import java.util.List;

import prj.backend.dao.CategorieDAO;
import prj.backend.db.Database;
import prj.backend.dto.CategorieDTO;
import prj.backend.dto.LivreDTO;
import prj.backend.exception.ServiceException;

public class CategorieService extends Service<CategorieDTO,CategorieDAO>{
	
	public CategorieService(CategorieDAO dao){
		super(dao);
	}

	public void ajouter(CategorieDTO categorieDTO) throws ServiceException {
		categorieDTO.setIdCategorie(""+Database.getSeqCategorieVal());
		create(categorieDTO);
	}

	public void supprimer(CategorieDTO categorieDTO) throws ServiceException {
		CategorieDTO categorie = read(categorieDTO.getIdCategorie());
		List<LivreDTO> livres = Database.getLivres();
		for(LivreDTO livre : livres){
			if(livre.getCategorieDTO().equals(categorie)){
				throw new ServiceException("Erreur : des livres utilisent encore cette catégorie");
			}
		}
		delete(categorie);
	}
	
}
