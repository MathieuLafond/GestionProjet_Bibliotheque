package prj.backend.facade;

import java.util.List;

import prj.backend.dao.DAO;
import prj.backend.dto.DTO;
import prj.backend.exception.FacadeException;
import prj.backend.exception.ServiceException;
import prj.backend.service.Service;

public class Facade<E extends DTO,F extends DAO<E>,T extends Service<E,F>>{
	
	private T service;
	
	protected Facade(T service){
		this.service=service;
	}
	
	protected void create(E dto) throws FacadeException{
		try {
			service.create(dto);
		} catch (ServiceException e) {
			throw new FacadeException(e);
		}
	}
	
	public E read(String id) throws FacadeException{
		try {
			return service.read(id);
		} catch (ServiceException e) {
			throw new FacadeException(e);
		}
	}

	protected void update(E objDto) throws FacadeException{
		try {
			service.update(objDto);
		} catch (ServiceException e) {
			throw new FacadeException(e);
		}
	}
	
	protected void delete(E objDto) throws FacadeException{
		try {
			service.delete(objDto);
		} catch (ServiceException e) {
			throw new FacadeException(e);
		}
	}
	
	public List<E> getAll(){
		return service.getAll();
	}
	
	protected T getService(){
		return service;
	}
	
}
