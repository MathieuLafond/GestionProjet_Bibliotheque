package prj.service.interfaces;

import java.sql.Timestamp;
import java.util.List;

import prj.dto.LivreDTO;

public interface ILivreService extends IService {

	void create(LivreDTO livreDTO);
	LivreDTO read(LivreDTO livreDTO);
	void update(LivreDTO livreDTO);
	void delete(LivreDTO livreDTO);
	List<LivreDTO> getAll();
	
	void acquerir(LivreDTO livreDTO);
	void vendre(LivreDTO livreDTO);
	
	void deleteAllInCategorie(String categorie);
	
	List<LivreDTO> findByTitre(String titre);
	List<LivreDTO> findByAuteur(String auteur);
	List<LivreDTO> findByEditeur(String editeur);
	List<LivreDTO> findByLangue(String langue);
	List<LivreDTO> findByCategorie(String categorie);
	List<LivreDTO> findByEmplacement(String emplacement);
	List<LivreDTO> findByDateParution(Timestamp dateParution);
	List<LivreDTO> findByForm(LivreDTO livreDTO);
	
	
	
	
}
