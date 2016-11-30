package prj.service.newimplementations;

import java.util.List;

import prj.dao.newimplementations.DAO;
import prj.dto.DTO;
import prj.dao.interfaces.IDAO;

public class Service<E extends DTO,T extends DAO<E>> implements IDAO{
	
	private T dao;
	
	public Service(T dao){
		this.dao=dao;
	}
	
	public void create(E dto){
		dao.create(dto);
	}
	
	public E read(String id){
		return dao.read(id);
	}

	public void update(E objDto){
		dao.update(objDto);
	}
	
	public void delete(E objDto){
		dao.delete(objDto);
	}
	
	public List<E> getAll(){
		return dao.getAll();
	}
	
	protected T getDAO(){
		return dao;
	}
	
}
