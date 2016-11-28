package prj.service.interfaces;

import java.util.List;

import prj.dto.MembreDTO;

public interface IMembreService extends IService {

	void create(MembreDTO membreDTO);
	MembreDTO read(MembreDTO membreDTO);
	void update(MembreDTO membreDTO);
	void delete(MembreDTO membreDTO);
	List<MembreDTO> getAll();
	
	void inscrire(MembreDTO membreDTO);
	void desinscrire(MembreDTO membreDTO);
	void modifier(MembreDTO membreDTO);
	
	List<MembreDTO> findByRetard();
	
}
