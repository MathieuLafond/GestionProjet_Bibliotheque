package prj.service.interfaces;

import java.util.List;

import prj.dto.PretDTO;

public interface IPretService extends IService {
	
	void create(PretDTO pretDTO);
	PretDTO read(PretDTO pretDTO);
	void update(PretDTO pretDTO);
	void delete(PretDTO pretDTO);
	List<PretDTO> getAll();
	
	void creer(PretDTO pretDTO);
	void retourner(PretDTO pretDTO);
	
	List<PretDTO> findByMembre();
	List<PretDTO> findByLivre();
	List<PretDTO> findByRetard();
}
