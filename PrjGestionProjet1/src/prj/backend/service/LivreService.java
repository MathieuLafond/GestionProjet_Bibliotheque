package prj.backend.service;

import java.sql.Timestamp;
import java.util.List;

import prj.backend.dao.LivreDAO;
import prj.backend.dto.LivreDTO;

public class LivreService extends Service<LivreDTO,LivreDAO> {

	public LivreService(LivreDAO dao){
		super(dao);
	}
	
	public void acquerir(LivreDTO livreDTO){
		create(livreDTO);
	}
	public void vendre(LivreDTO livreDTO){
		delete(livreDTO);//TODO v�rifications
	}
	
	public void deleteAllInCategorie(String idCategorie){
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