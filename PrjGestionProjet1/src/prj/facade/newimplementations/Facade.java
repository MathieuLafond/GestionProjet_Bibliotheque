package prj.facade.newimplementations;

import java.util.List;

import prj.dao.newimplementations.DAO;
import prj.dto.DTO;
import prj.service.newimplementations.Service;
import prj.dao.interfaces.IDAO;

public class Facade<E extends DTO,F extends DAO<E>,T extends Service<E,F>> implements IDAO{
	
	private T service;
	
	public Facade(T service){
		this.service=service;
	}
	
	protected void create(E dto){
		service.create(dto);
	}
	
	public E read(String id){
		return service.read(id);
	}

	protected void update(E objDto){
		service.update(objDto);
	}
	
	protected void delete(E objDto){
		service.delete(objDto);
	}
	
	public List<E> getAll(){
		return service.getAll();
	}
	
	protected T getService(){
		return service;
	}
	
}
