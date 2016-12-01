package prj.backend.service;

import java.sql.Timestamp;
import java.util.List;

import prj.backend.dao.LivreDAO;
import prj.backend.db.Database;
import prj.backend.dto.LivreDTO;
import prj.backend.dto.PretDTO;
import prj.backend.exception.ServiceException;

public class LivreService extends Service<LivreDTO,LivreDAO> {

	public LivreService(LivreDAO dao){
		super(dao);
	}
	
	public void acquerir(LivreDTO livreDTO){
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
	
	public void deleteAllInCategorie(String idCategorie) throws ServiceException{
		List<LivreDTO> livres = findByCategorie(idCategorie);
		List<PretDTO> prets = Database.getPrets();
		for(LivreDTO livre : livres){
			for(PretDTO pret : prets){
				if(pret.getLivreDTO().equals(livre)){
					throw new ServiceException("Erreur : un prêt est en cours sur un livre de cette catégorie");
				}
			}
		}
		getDAO().deleteAllInCategorie(idCategorie);
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
	public List<LivreDTO> findByCategorie(String idCategorie){
		return getDAO().findByCategorie(idCategorie);
	}
	public List<LivreDTO> findByEmplacement(String emplacement){
		return getDAO().findByEmplacement(emplacement);
	}
	public List<LivreDTO> findByDateParution(Timestamp dateParution){
		return getDAO().findByDateParution(dateParution);
	}
	public List<LivreDTO> findByForm(LivreDTO livreDTO){
		return getDAO().findByForm(livreDTO);
	}
	
}
