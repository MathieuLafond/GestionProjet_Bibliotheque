package prj.backend.facade;

import java.util.List;

import prj.backend.dao.DAO;
import prj.backend.dto.DTO;
import prj.backend.service.Service;

public class Facade<E extends DTO,F extends DAO<E>,T extends Service<E,F>>{
	
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
