package prj.service.interfaces;

import java.util.List;

import prj.dto.CategorieDTO;
import prj.dto.LivreDTO;

public interface ICategorieService extends IService{

	void create(CategorieDTO categorieDTO);
	CategorieDTO read(CategorieDTO categorieDTO);
	void update(CategorieDTO categorieDTO);
	void delete(CategorieDTO categorieDTO);
	List<CategorieDTO> getAll();
	
	List<LivreDTO> findByNom(String nom);
}
