package prj.backend.service;

import java.sql.Timestamp;
import java.util.List;

import prj.backend.dao.LivreDAO;
import prj.backend.db.Database;
import prj.backend.dto.CategorieDTO;
import prj.backend.dto.LivreDTO;
import prj.backend.dto.PretDTO;
import prj.backend.exception.DAOException;
import prj.backend.exception.ServiceException;
import prj.backend.util.QuickLoad;

public class LivreService extends Service<LivreDTO,LivreDAO> {

	public LivreService(LivreDAO dao){
		super(dao);
	}
	
	public void acquerir(LivreDTO livreDTO) throws ServiceException{
		livreDTO.setIdLivre(""+Database.getSeqLivreVal());
		create(livreDTO);
	}
	public void vendre(LivreDTO livreDTO) throws ServiceException{
		LivreDTO livre = read(livreDTO.getIdLivre());
		List<PretDTO> prets = Database.getPrets();
		for(PretDTO pret : prets){
			if(pret.getLivreDTO().equals(livre)){
				throw new ServiceException("Erreur : un prêt est en cours sur ce livre");
			}
		}
		delete(livre);
	}
	
	public void deleteAllInCategorie(CategorieDTO categorie) throws ServiceException{
		try {
			CategorieDTO categorieDTO = QuickLoad.read(categorie.getIdCategorie(), Database.getCategories());
			List<LivreDTO> livres = findByCategorie(categorieDTO);
			List<PretDTO> prets = Database.getPrets();
			for(LivreDTO livre : livres){
				for(PretDTO pret : prets){
					if(pret.getLivreDTO().equals(livre)){
						throw new ServiceException("Erreur : un prêt est en cours sur un livre de cette catégorie");
					}
				}
			}
			getDAO().deleteAllInCategorie(categorieDTO);
		} catch (DAOException exception) {
			throw new ServiceException(exception);
		}
	}
	
	public List<LivreDTO> findByTitre(String titre){
		return getDAO().findByTitre(titre);
	}
	public List<LivreDTO> findByAuteur(String auteur){
		return getDAO().findByAuteur(auteur);
	}
	public List<LivreDTO> findByEditeur(String editeur){
		return getDAO().findByEditeur(editeur);
	}
	public List<LivreDTO> findByLangue(String langue){
		return getDAO().findByLangue(langue);
	}
	public List<LivreDTO> findByCategorie(CategorieDTO categorie){
		return getDAO().findByCategorie(categorie);
	}
	public List<LivreDTO> findByEmplacement(String emplacement){
		return getDAO().findByEmplacement(emplacement);
	}
	public List<LivreDTO> findByDateParution(Timestamp dateParution){
		return getDAO().findByDateParution(dateParution);
	}
	public List<LivreDTO> findByForm(LivreDTO livreDTO){
		if(livreDTO.getCategorieDTO()==null){
			livreDTO.setCategorieDTO(new CategorieDTO());
		}
		if(livreDTO.getCategorieDTO().getNomCategorie()==null){
			livreDTO.getCategorieDTO().setNomCategorie("");
		}
		if(livreDTO.getAuteur()==null){
			livreDTO.setAuteur("");
		}
		if(livreDTO.getEditeur()==null){
			livreDTO.setEditeur("");
		}
		if(livreDTO.getEmplacement()==null){
			livreDTO.setEmplacement("");
		}
		if(livreDTO.getLangue()==null){
			livreDTO.setLangue("");
		}
		if(livreDTO.getTitre()==null){
			livreDTO.setTitre("");
		}
		return getDAO().findByForm(livreDTO);
	}
	
}
